package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import Main.RedisUtil;
import net.sf.json.JSONObject;
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
	@RequestMapping("coding.action")
	public ModelAndView Coding(){
		ModelAndView mView=new ModelAndView();
		mView.setViewName("coding");
		return mView;
		
	}
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
					redisUtil.set(String.valueOf(vj.getKcxh())+"xxrs",vj.getXxrs(),2592000);      // kcxh + "xxrs" 限选人次
					// 创建已经选课的空间
					
				}
				
				//System.out.println("============="+xq+"====");
		for (String xh : allxh) {
			xh=xh.replace(" ", "");
			redisUtil.set(xh+"yxkc", 0);
		//找到以前成绩和类别
			List<VJwCjGgxx> befclass=scimp.findBefSelect(xh);
			map.put("befclass",befclass);
			redisUtil.hmset(xh+"befclass", map,2592000);   //   xh + befclass 以前课程
			map.clear();
			//System.out.println("===="+xh+"========="+xq+"====");
		
		// 找到学生班级 姓名  年级
			VJwXs stu=scimp.findstu(xh);
			Map<Object, Object> stumap=new HashMap<Object, Object>();
				stumap.put("bj",stu.getBj());
				stumap.put("xh",stu.getXh());
				stumap.put("xm",stu.getXm());
				int nj=2000+Integer.parseInt(xh.substring(0, 2));
				System.out.println("======="+nj+"========");
				stumap.put("nj",2000+Integer.parseInt(xh.substring(0, 2)));
			redisUtil.hmset(xh+"message", stumap,2592000);      ///   xh message      学生信息 
			
			
			//找到选课权限
			stumap.clear();
			VJwXkqxGgxx xkqx=scimp.findqx(nj);
			redisUtil.set(xh+"qx", xkqx);
			//stumap.put("qx",xkqx);
			//redisUtil.hmset(xh+"qx", stumap);		 		//      xh  + qx   学生权限
			
			//stumap.clear();
		//找到学生可选
			List<VJwGgxx> stuclasses=scimp.findClasses(xh, xq);
			for (VJwGgxx vj : stuclasses) {
				map.put(vj.getKcxh().toString(),vj);
			}
			
			redisUtil.hmset(xh+"nowclass", map,2592000);	  //  xh   nowclass   现在可选
			map.clear();
		}
		
		return mvAndView;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("load.action")
	public ModelAndView load(@RequestParam(value="xh",required=false)String xh,
			@RequestParam(value="pass",required=false)String pass) {
		System.out.println("===xh===="+xh);
		System.out.println("===pass=="+pass);
		ModelAndView mv=new ModelAndView();
		if(xh.equals(pass)==false){
			mv.setViewName("error");
			return mv;
		}
		System.out.println("===xh===="+xh);
		System.out.println("===pass=="+pass);
		
		//创建map来保存redis返回的键值对
		//Map<Object, Object> mapnowclass=new HashMap<Object, Object>();
		//Map<Object, Object> mapbefclass=new HashMap<Object, Object>();
		//Map<Object, Object> stumessageMap=new HashMap<Object, Object>();
		
		Map<Object, Object> map=new HashMap<Object, Object>();
		
		//本次可选课程信息
		
		
		//获取保存本次选课信息的map
		map=redisUtil.hmget("today");
		
		//创建一个list保存本次选课的信息
		
		if(Integer.parseInt(redisUtil.get(xh+"yxkc").toString())!=0){
		List<Xkmd> list=new ArrayList<Xkmd>();
		list=(List<Xkmd>)map.get(xh);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTx()){
				list.remove(i);
				i--;
		}
		}
		mv.addObject("NowClass",list);
		}
		map.clear();
		map=redisUtil.hmget(xh+"nowclass");
		//
		List<VJwGgxx> classes=new ArrayList<VJwGgxx>();
		for (Object key :  map.keySet()) { 
			// 更新课程限选人数
			VJwGgxx vj=(VJwGgxx) map.get(key);
			vj.setXxrs(Integer.parseInt(redisUtil.get(key.toString()+"xxrs").toString()));
			classes.add(vj);
			}
		
		System.out.println("=============2====");
		// 对可选程序排序
		Collections.sort(classes, new Comparator<VJwGgxx>() {
        @Override
        public int compare(VJwGgxx o1, VJwGgxx o2) {
            return o1.getLbdh().compareTo(o2.getLbdh());
        }
});	
		//以前课程
		map.clear();
		map=redisUtil.hmget(xh+"befclass");
		List<VJwCjGgxx> befclass=(List<VJwCjGgxx>) map.get("befclass");	
		map.clear();
		//学生信息
		map=redisUtil.hmget(xh+"message");
		
		mv.addObject("xh",xh);
		mv.addObject("bj",map.get("bj").toString());
		mv.addObject("xm",map.get("xm").toString());
		map.clear();
		mv.addObject("xq","18-19-2");
		mv.addObject("befclass",befclass);
		mv.addObject("classes",classes);
		mv.setViewName("choiceClasses");
		return mv;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("select.action")
	@ResponseBody
	public JSONObject select(@RequestBody String mapjson)throws IOException {
		//字符串编码修改，防止乱码			HttpServletResponse res,HttpServletRequest request
		JSONObject mapmap=JSONObject.fromObject(mapjson);
		JSONObject succes=new JSONObject();
       // System.out.println(queryString);
       // System.out.println(decode);
        
        //获得中文
        String kcmc=mapmap.get("kcmc").toString();
        String kcxh=mapmap.get("kcxh").toString();
        String xh=mapmap.get("xh").toString();
        String xq=mapmap.get("xq").toString();
       // System.out.println(kcmc);
        
        
		SimpleDateFormat sdf = new SimpleDateFormat();// 日期
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");  // 
        Date date = new Date();// 
		sdf.format(date); //格式化日期
		
		
		
		//找到个人权限的门次信息
		//mapstu=redisUtil.hmget(xh+"qx");
		//VJwXkqxGgxx xkqxGgxx=(VJwXkqxGgxx)mapstu.get("qx");
		VJwXkqxGgxx xkqxGgxx=(VJwXkqxGgxx)redisUtil.get(xh+"qx");
		int mc=xkqxGgxx.getMc1();
		
		//mapstu.clear();
		
		// 查找已选课程信息
		boolean bool=true;
		if(redisUtil.get(xh+kcxh)==null||(Integer.parseInt(redisUtil.get(xh+kcxh).toString())==0)){
			bool=false;
		}
		
		//判断是否选过,得先用list保存map里面的值，不然一次更新之后就会丢失上一次的值
	//判断保存
	if(bool){
		succes.put("message", "你已经选过该课程!");
	}
	else {
	if(mc>0) {		// 可选门次
		// 找到课程的可选人数
		Map<Object, Object> mapstu=new HashMap<Object, Object>();
		mapstu=redisUtil.hmget("today");
		Xkmd xkmd = new Xkmd();  
		xkmd.setCzrq(date);
		xkmd.setTx(false);
		xkmd.setXh(xh);
		xkmd.setXq(xq);
		xkmd.setKcmc(kcmc);
		xkmd.setKcxh(Integer.parseInt(kcxh));
		List<Xkmd> list=new ArrayList<Xkmd>();
		if(Integer.parseInt(redisUtil.get(xh+"yxkc").toString())!=0){
		list=(List<Xkmd>) mapstu.get(xh);
		}
		int num=Integer.parseInt(redisUtil.get(kcxh+"xxrs").toString());
			if(num>0) {  // 限选人次
				//	if(true) {   // 选课时间限定			
				// 保存选课信息
				// 选课成功			
						redisUtil.set(kcxh+"xxrs",Integer.parseInt(redisUtil.get(kcxh+"xxrs").toString())-1);
						list.add(xkmd);
						mapstu.put(xh,list);             
						redisUtil.hmset("today", mapstu);      // 放到已选课程
						mapstu.clear();
						
						xkqxGgxx.setMc1(mc-1);	
						redisUtil.set(xh+"qx",xkqxGgxx); // 选课权限的更新

						//标志选过课
						redisUtil.set(xh+kcxh, "1");
						redisUtil.set(xh+"yxkc",1);
				// 更新课程限选人数
						succes.put("message", "选课成功!刷新界面可更新课程可选人次信息!");
				//		}
		}
		else {
			succes.put("message", "选课失败!选课人次已满!刷新界面可更新课程可选人次信息!");
		}
	}
	else{
		succes.put("message", "选课失败!选课门次不足!刷新界面可更新课程可选人次信息!");	}
	}
	return succes;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("tuike.action") 
	@ResponseBody
	public JSONObject tuike(@RequestBody String mapjson){
		//对json格式的转换
		JSONObject map=JSONObject.fromObject(mapjson);
		System.out.println("方法调用成功！");
		System.out.println(map.get("kcxh"));
		System.out.println(map.get("xh"));
		System.out.println(map.get("xq"));
		String xh=map.get("xh").toString();
		String kcxh=map.get("kcxh").toString();
        
		SimpleDateFormat sdf = new SimpleDateFormat();// 日期
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");  // 
        Date date = new Date();// 
		sdf.format(date); //格式化日期
		
		//课程可选人次的修改
		int xxrs=Integer.parseInt(redisUtil.get(kcxh+"xxrs").toString());
		redisUtil.set(kcxh+"xxrs", xxrs+1);
		redisUtil.set(xh+kcxh, "0"); //将判断是否选了这么课的标志更改为否
		
		// 个人权限的修改
		//选课
		VJwXkqxGgxx xkqxGgxx=(VJwXkqxGgxx)redisUtil.get(xh+"qx");
		xkqxGgxx.setMc1(xkqxGgxx.getMc1()+1);
		redisUtil.set(xh+"qx", xkqxGgxx);

		
		//已选课程的修改
		Map<Object, Object> mapstu=new HashMap<Object, Object>();
		mapstu=redisUtil.hmget("today");
		List<Xkmd> list=new ArrayList<Xkmd>();
		list=(List<Xkmd>) mapstu.get(xh);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getKcxh().toString().equals(kcxh)){
				list.get(i).setTx(true);
				list.get(i).setCzrq(date);
			}
		}
		mapstu.put(xh, list);
		redisUtil.hmset("today",mapstu);
		map.put("message", "退课成功!刷新界面可更新课程可选人次信息!");
		return map;
	}
	
}
