package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Main.RedisUtil;
import pojo.VJwGgxx;


public class test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");
		System.out.println("===========");
		Map<Object, Object> map=new HashMap<Object, Object>();
		String xhnowclass="17484114nowclass";
		map=redisUtil.hmget(xhnowclass);
		List<VJwGgxx> nowclass=(List<VJwGgxx>) map.get("nowclass");
		for (VJwGgxx vj : nowclass) {
			System.out.print(vj.getJsmc()+"--");
			System.out.print(vj.getKcxh()+"--");
			System.out.print(vj.getVjwkcdm().getKcmc()+"--");
			System.out.print(vj.getVjwlbdh().getLbmc()+"--");
			System.out.print(vj.getJc1()+"--");
			System.out.print(vj.getJc2()+"--");
			System.out.print(vj.getJse()+"--");
			System.out.print(vj.getXxrs()+"--");
			System.out.print(vj.getZc1()+"--");
			System.out.print(vj.getZc2()+"--");
			System.out.println();
		}
	}
}
