package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Main.RedisUtil;
import pojo.VJwCjGgxx;
import pojo.VJwGgxx;
import pojo.VJwXkqxGgxx;
import pojo.VJwXs;
import pojo.Xkmd;
import service.selectclassimp;

@Controller
public class XKSYS {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private  selectclassimp scimp;
	@RequestMapping("redis.action")
	public ModelAndView redis(){
		ModelAndView mvAndView=new ModelAndView();
		mvAndView.setViewName("index");
		String xq="18-19-2";
		List<String> allxh=scimp.findAllXh();
		
		//找到已开课程信息 找不到是因为查询学期为19-20-1  数据库中数据为空 
				List<VJwGgxx> allclasses=scimp.findAllClassses(xq);
				//List<VJwGgxx> allclasses=scimp.findAllClassses();
				//放入可选课程信息的 kcxh 和  xxrs
				Map<Object, Object> map=new HashMap<Object, Object>();
				List<Xkmd> list=new ArrayList<>();
				map.put("0",list);
				redisUtil.hmset("today", map);                       //  today是为今天选课人数创建空间
				map.clear();
				for (VJwGgxx vj : allclasses) {
					redisUtil.set(String.valueOf(vj.getKcxh())+"xxrs",vj.getXxrs(),2592000);      // kcxh + "xxrs"
					// 创建已经选课的空间
					
				}
				
				System.out.println("============="+xq+"====");
		for (String xh : allxh) {
			xh=xh.replace(" ", "");
		//找到以前成绩和类别
			List<VJwCjGgxx> befclass=scimp.findBefSelect(xh);
			map.put("befclass",befclass);
			redisUtil.hmset(xh+"befclass", map,2592000);   //   xh + befclass
			map.clear();
			System.out.println("===="+xh+"========="+xq+"====");
		
		// 找到学生班级 姓名  年级
			VJwXs stu=scimp.findstu(xh);
			Map<Object, Object> stumap=new HashMap<Object, Object>();
				stumap.put("bj",stu.getBj());
				stumap.put("xh",stu.getXh());
				stumap.put("xm",stu.getXm());
				int nj=2000+Integer.parseInt(xh.substring(0, 2));
				System.out.println("======="+nj+"========");
				stumap.put("nj",2000+Integer.parseInt(xh.substring(0, 2)));
			redisUtil.hmset(xh+"message", stumap,2592000);      ///   xh message         
			
			
			//找到选课权限
			stumap.clear();
			VJwXkqxGgxx xkqx=scimp.findqx(nj);
			stumap.put("qx",xkqx);
			redisUtil.hmset(xh+"qx", stumap);		 		//      xh  + qx
			
			stumap.clear();
		//找到学生可选
			List<VJwGgxx> stuclasses=scimp.findClasses(xh, xq);
			for (VJwGgxx vj : stuclasses) {
				map.put(vj.getKcxh().toString(),vj);
			}
			
			redisUtil.hmset(xh+"nowclass", map,2592000);	  //  xh   nowclass
			map.clear();
		}
		
		return mvAndView;
	}
	
	
	@RequestMapping("load.action")
	public ModelAndView load(@RequestParam(value="xh",required=false)String xh) {
		ModelAndView mv=new ModelAndView();
		//创建map来保存redis返回的键值对
		Map<Object, Object> mapnowclass=new HashMap<Object, Object>();
		Map<Object, Object> mapbefclass=new HashMap<Object, Object>();
		Map<Object, Object> stumessageMap=new HashMap<Object, Object>();
		
		@SuppressWarnings("unused")
		Map<Object, Object> map=new HashMap<Object, Object>();
		
		//获取保存本次选课信息的map
		mapnowclass=redisUtil.hmget(xh+"nowclass");
		map=redisUtil.hmget("today");
		
		//创建一个list保存本次选课的信息
		@SuppressWarnings({ "unused", "unchecked" })
		List<Xkmd> list=(List<Xkmd>) map.get(xh);

		//
		List<VJwGgxx> classes=new ArrayList<VJwGgxx>();
		map=redisUtil.hmget("today");
		for (Object key :  mapnowclass.keySet()) { 
			// 更新课程限选人数
			VJwGgxx vj=(VJwGgxx) mapnowclass.get(key);
			vj.setXxrs((int) redisUtil.get(key.toString()+"xxrs"));
			classes.add(vj);
			}
		
		//System.out.println("=============2====");
		// 对可选程序排序
		Collections.sort(classes, new Comparator<VJwGgxx>() {
        @Override
        public int compare(VJwGgxx o1, VJwGgxx o2) {
            return o1.getLbdh().compareTo(o2.getLbdh());
        }
});	
		
		mapbefclass=redisUtil.hmget(xh+"befclass");
		@SuppressWarnings("unchecked")
		List<VJwCjGgxx> befclass=(List<VJwCjGgxx>) mapbefclass.get("befclass");	
		stumessageMap=redisUtil.hmget(xh+"message");
		mv.addObject("NowClass",list);
		mv.addObject("xh",xh);
		mv.addObject("bj",stumessageMap.get("bj").toString());
		mv.addObject("xm",stumessageMap.get("xm").toString());
		mv.addObject("xq","18-19-2");
		mv.addObject("befclass",befclass);
		mv.addObject("classes",classes);
		mv.setViewName("choiceClasses");
		return mv;
	}
	
	
	@RequestMapping("select.action")
	public void select(
			@RequestParam(value="kcmc",required=false)String kcmc,
			@RequestParam(value="kcxh",required=false)String kcxh,
			@RequestParam(value="xh",required=false)String xh,
			@RequestParam(value="xq",required=false)String xq,
			HttpServletResponse res)throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat();// 日期
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");  // 
        Date date = new Date();// 
		sdf.format(date); //格式化日期
		Map<Object, Object> mapstu=new HashMap<Object, Object>();
		System.out.println("=============1====");
		System.out.println("===xh==="+xh+"======");
		System.out.println("====kcxh=="+kcxh+"======");
		System.out.println("====kcmc====="+kcmc+"========");
		//找到个人权限的门次信息
		mapstu=redisUtil.hmget(xh+"qx");
		VJwXkqxGgxx xkqxGgxx=(VJwXkqxGgxx)mapstu.get("qx");
		int mc=xkqxGgxx.getMc1();
		System.out.println("===mc===="+mc+"=======");
		mapstu.clear();
		System.out.println("=============2====");
		// 查找已选课程信息
		boolean bool=false;
		mapstu=redisUtil.hmget("today");
		
		//判断是否选过,得先用list保存map里面的值，不然一次更新之后就会丢失上一次的值
		@SuppressWarnings({ "unused", "unchecked" })
		List<Xkmd> list=(List<Xkmd>) mapstu.get(xh);
		Xkmd xkmd = new Xkmd();  
		xkmd.setKcmc(kcmc.toString());
		System.out.println(kcmc);
		xkmd.setXh(xh);
		xkmd.setXkrq(date);
		xkmd.setTx(false);
		xkmd.setXq(xq);
		xkmd.setKcxh(Integer.parseInt(kcxh));
		bool=list.contains(xkmd);
		//redisUtil.hmset(kcxh+"today", map);  
		// kcxh + today        xh+kcxh
		
		System.out.println("============3===========");
	//判断保存
	if(bool){
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script language='javascript'>alert('你已经选过该课程!');javascript:history.go(-1);</script>");
	}
	else {
	if(mc>0) {		// 可选门次
		// 找到课程的可选人数
		int num=Integer.parseInt((String) redisUtil.get(kcxh.toString()+"xxrs"));
		if(num>0) {  // 限选人次
			if(true) {   // 选课时间限定
				
				// 保存选课信息
				// 选课成功
				list.add(xkmd);
				mapstu.put(xh,list);             
				redisUtil.hmset("today", mapstu);      // 放到已选课程
				mapstu.clear();
				xkqxGgxx.setMc1(mc-1);				// 更新个人权限可选门数
				mapstu.put("xq",xkqxGgxx);
				redisUtil.hmset(xh+"qx",mapstu);	
		
				// 更新课程限选人数
				redisUtil.set(kcxh+"xxrs",Integer.parseInt(redisUtil.get(kcxh+"xxrs").toString())-1);
				
				res.setContentType("text/html;charset=utf-8");
				PrintWriter out = res.getWriter();
			out.println("<script language='javascript'>alert('选课成功!返回后请刷新界面!');javascript:history.go(-1);</script>");
	}
			/*else {
				res.setContentType("text/html;charset=utf-8");
				PrintWriter out = res.getWriter();
			out.println("<script language='javascript'>alert('选课失败!时间已过!返回后请刷新界面!');javascript:history.go(-1);</script>");
			}*/
		}
		else {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script language='javascript'>alert('选课失败!选课人次已满!返回后请刷新界面!');javascript:history.go(-1);</script>");
		}
	}
	else{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script language='javascript'>alert('选课失败!选课门次不足!返回后请刷新界面!');javascript:history.go(-1);</script>");
	}
	}
		
	}
	
}
