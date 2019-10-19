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
import pojo.VJwGgxx;
import pojo.VJwXkqxGgxx;
import service.selectclassimp;

@Controller
public class newxksys {

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private  selectclassimp scimp;
	
	
	@RequestMapping("ready.action")
	public ModelAndView ready(@RequestParam(value="xh",required=false)String xh) {
		ModelAndView mView=new ModelAndView();
		
		//找到nj 
		char[] xhnum=xh.toCharArray();
		int nj=2000+Integer.parseInt(String.valueOf(xhnum[0]))*10+Integer.parseInt(String.valueOf(xhnum[1]));
		//找到选课权限，并放入redis
		VJwXkqxGgxx qx=scimp.findqx(nj);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("xh", xh);
		map.put("xq", qx.getXq());
		map.put("qx1", qx.getQx1());
		map.put("qx2", qx.getQx2());
		map.put("mc1", qx.getMc1());
		map.put("mc2", qx.getMc2());
		map.put("bz1", qx.getBz1());
		map.put("beg", qx.getBegindate());
		map.put("end", qx.getEnddate());
		String xhqx=xh+"qx";
		redisUtil.hmset(xhqx, map, 259200);
		
		//找到可选课程信息
		List<VJwGgxx> classes=scimp.findClasses(xh, qx.getXq());
		//清空map键值对
		map.clear();
		for (VJwGgxx vj : classes) {
			map.put("xq", vj.getXq());
			map.put("lbdh", vj.getLbdh());
			map.put("jsmc", vj.getJsmc());
			map.put("jc1", vj.getJc1());
			map.put("jc2", vj.getJc2());
			map.put("jse", vj.getJse());
			map.put("xxrs", vj.getXxrs());
			map.put("zc1", vj.getZc1());
			map.put("zc2", vj.getZc2());
			map.put("kcmc", vj.getVjwkcdm().getKcmc());
			map.put("lbmc", vj.getVjwlbdh().getLbmc());
			redisUtil.hmset(vj.getVjwkcdm().getKcmc(), map,259200);
		}
		return mView;
		
	}
	
	@RequestMapping("redis.action")
	public void TTCCLayout() {
		redisUtil.set("name",1234);
		System.out.println(redisUtil.get("name"));	
	}
	
	@RequestMapping("load.action")
	public ModelAndView load() {
		ModelAndView mv=new ModelAndView();
		return mv;
	}
}
