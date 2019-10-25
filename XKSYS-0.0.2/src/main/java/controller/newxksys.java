package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.EndDocument;

import org.apache.log4j.TTCCLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Main.RedisUtil;
import pojo.VJwCjGgxx;
import pojo.VJwGgxx;
import pojo.VJwXkqxGgxx;
import service.selectclassimp;

@Controller
public class newxksys {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private  selectclassimp scimp;
	
	
	@RequestMapping("kcxh.action")
	public void kcxh() {
		String xq="18-19-2";
		List<VJwGgxx> allclasses=scimp.findAllClassses(xq);
		
		
	}
	@RequestMapping("ready2.action")
	public ModelAndView ready2() {
		ModelAndView mView=new ModelAndView();
		mView.setViewName("index");
		String xq="18-19-2";
		List<String> allxh=scimp.findAllXh();
		
		
		//找到已开课程信息 找不到是因为查询学期为19-20-1  数据库中数据为空 
				List<VJwGgxx> allclasses=scimp.findAllClassses(xq);
				//List<VJwGgxx> allclasses=scimp.findAllClassses();
				//放入可选课程信息的 kcxh 和  xxrs
				for (VJwGgxx vj : allclasses) {
					/*map.put("xq", vj.getXq());
					map.put("lbdh", vj.getLbdh());
					map.put("kcxh", vj.getKcxh());
					map.put("jsmc", vj.getJsmc());
					map.put("jc1", vj.getJc1());
					map.put("jc2", vj.getJc2());
					map.put("jse", vj.getJse());
					map.put("xxrs", vj.getXxrs());
					map.put("zc1", vj.getZc1());
					map.put("zc2", vj.getZc2());*/
					redisUtil.set(String.valueOf(vj.getKcxh())+"xxrs",vj.getXxrs(),2592000);      // kcxh + "xxrs"
					//map.clear();
					//已开序号存入
					//redisUtil.hmset(vj.getVjwkcdm().getKcmc(), map);
				}
				
				
		for (String xh : allxh) {
			Map<String, Object> map=new HashMap<String, Object>();
			xh=xh.replace(" ", "");
		
		//找到以前成绩和类别
			List<VJwCjGgxx> befclass=scimp.findBefSelect(xh);
			map.put("befclass",befclass);
			redisUtil.hmset(xh+"befclass", map,2592000);
			/*
			for (VJwCjGgxx bef:befclass) {
				map.put("lbmc",bef.getLbmc());
				map.put("kscj",bef.getKscj());
				//map.put("kcmc",bef.getKcmc());
				redisUtil.hmset(xh+"befclass", map,2592000);           //  xh + "befclass"
			}
			*/
			map.clear();
			
			
		//找到nj 
		/*char[] xhnum=xh.toCharArray();
		int nj=2000+Integer.parseInt(String.valueOf(xhnum[0]))*10+Integer.parseInt(String.valueOf(xhnum[1]));
		
		//找到选课权限，并放入redis   key =  xh+'qx'
		VJwXkqxGgxx qx=scimp.findqx(nj);
		qx.setXq("18-19-2");
		map.put("xh", xh);
		map.put("xq", qx.getXq());
		map.put("qx1", qx.getQx1());
		map.put("qx2", qx.getQx2());
		map.put("mc1", qx.getMc1());
		map.put("mc2", qx.getMc2());
		map.put("bz1", qx.getBz1());
		map.put("beg", qx.getBegindate());
		map.put("end", qx.getEnddate());
		//选课权限存入
		redisUtil.hmset(xh+"qx", map, 2592000);          //   xh+"qx"
		map.clear();
		*/
		
		//找到可选课程序号
		//List<Integer> xhkcxh=scimp.findAllKcxh(xh);
		//map.put(xh+"kcxh", xhkcxh);
		//可选课程序号存入
		//redisUtil.hmset(xh+"kcxh", map,2592000);		
		//清空map键值对
		//map.clear();		
		
		System.out.println("===="+xh+"========="+xq+"====");
		
		
		//找到学生可选
		List<VJwGgxx> stuclasses=scimp.findClasses(xh, xq);
		map.put("nowclass",stuclasses);
		redisUtil.hmset(xh+"nowclass", map,2592000);
		/*
		for (VJwGgxx vj : stuclasses) {
			System.out.println(vj.toString());
			map.put("kcxh",vj.getKcxh());
			map.put("kcmc",vj.getVjwkcdm().getKcmc());
			map.put("lbmc", vj.getVjwlbdh().getLbmc());
			map.put("jsmc", vj.getJsmc());
			map.put("jc1", vj.getJc1());
			map.put("jc2", vj.getJc2());
			map.put("jse", vj.getJse());
			map.put("xxrs", vj.getXxrs());
			map.put("zc1", vj.getZc1());
			map.put("zc2", vj.getZc2());
			redisUtil.hmset(xh+"nowclass", map,2592000);
			map.clear();
		}*/
		}
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
				for (VJwGgxx vj : allclasses) {
					redisUtil.set(String.valueOf(vj.getKcxh())+"xxrs",vj.getXxrs(),2592000);      // kcxh + "xxrs"
				}
				
				
		for (String xh : allxh) {
			Map<String, Object> map=new HashMap<String, Object>();
			xh=xh.replace(" ", "");
		//找到以前成绩和类别
			List<VJwCjGgxx> befclass=scimp.findBefSelect(xh);
			map.put("befclass",befclass);
			redisUtil.hmset(xh+"befclass", map,2592000);   //   xh + befclass
			map.clear();
			System.out.println("===="+xh+"========="+xq+"====");
		
		
		//找到学生可选
			List<VJwGgxx> stuclasses=scimp.findClasses(xh, xq);
			map.put("nowclass",stuclasses);
			redisUtil.hmset(xh+"nowclass", map,2592000);
		}
		
		return mvAndView;
	}
	
	@RequestMapping("load.action")
	public ModelAndView load() {
		ModelAndView mv=new ModelAndView();
		return mv;
	}
}
