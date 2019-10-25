package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javafx.scene.chart.PieChart.Data;
import mapper.VJwGgxxMapper;
import pojo.VJwCjGgxx;
import pojo.VJwGgxx;
import pojo.VJwXkqxGgxx;
import pojo.Xkmd;
import pojo.XsVNew;
import service.selectclassimp;
//@Controller
public class xksys {
	/*
	private Integer mc;
	private Integer nj;
	private  String xq;
	private  String xm;
	@Autowired
	private  selectclassimp scimp;
	@RequestMapping("load.action")
	public ModelAndView loadin(@RequestParam(value="xh",required=false)String xh,
			@RequestParam(value="password",required=false)String password) {
		ModelAndView mv=new ModelAndView();
		this.xm=scimp.findXm(xh);
		if(xh.equals(password)) {
			List<VJwGgxx> classes=scimp.findClasses(xh);//��ѯ�γ�
			this.nj=(int) scimp.findNJ(xh);//�ҵ��꼶
			this.xq=scimp.findXq(nj);//�ҵ�ѧ��
			// ����
			Collections.sort(classes, new Comparator<VJwGgxx>() {;
            @Override
            public int compare(VJwGgxx o1, VJwGgxx o2) {
                return o1.getLbdh().compareTo(o2.getLbdh());
            }
	});
			//�ҵ���ѡ�γ����
			List<VJwCjGgxx> befClass=scimp.findBefSelect(xh);
			//���ұ�����ѡ
			List<Xkmd> xkmd=scimp.findNowClass(xh,xq);
			//���ݲ���
			mv.addObject("classes",classes);
			mv.addObject("befClass",befClass);
			mv.addObject("NowClass",xkmd);
			mv.addObject("xh",xh);
			mv.addObject("xm",xm);
			mv.addObject("xq",xq);
			mv.addObject("nj",nj);
			mv.setViewName("choiceClasses");
		}
		else {
			mv.setViewName("error");
		}
		return mv;
	}
	@RequestMapping("select.action")
	public void select(
			@RequestParam(value="kcxh",required=false)String kcxh,
			@RequestParam(value="kcmc",required=false)String kcmc,
			@RequestParam(value="xh",required=false)String xh,
			@RequestParam(value="nj",required=false)String nj,
			@RequestParam(value="xq",required=false)String xq,
			HttpServletResponse res) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");  // ��ʽ��ʱ�� 
        Date date = new Date();// ��ʽ��ʱ�� 
		sdf.format(date);
		List<Xkmd> xkmdmod=scimp.findNowClass(xh,xq);//������ѡ
		Date date2=scimp.findBegin(this.nj); //��ѯʱ��Ȩ��
		Integer num=scimp.findnumber(kcxh,xq);//������ѡ�˴�
		this.mc=scimp.findMc(this.nj); //�ҵ��Ŵ�
		int mccopy=xkmdmod.size();
		Xkmd xkmd = new Xkmd();
		xkmd.setXh(xh);
		xkmd.setXkrq(date);
		xkmd.setTx(false);
		xkmd.setXq(xq);
		xkmd.setKcmc(kcmc);
		xkmd.setKcxh(Integer.parseInt(kcxh));
		boolean bool=false;
			for (Xkmd xkmd2 : xkmdmod) {
				System.out.println(xkmd.getKcmc()+"---"+xkmd2.getKcmc());
			if(xkmd.getKcmc().equals(xkmd2.getKcmc())) {
				bool=true;
			}
			else {
				bool=false;
			}
		}
		//�жϱ���
		if(bool){
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script language='javascript'>alert('���Ѿ�ѡ���ÿγ�!');javascript:history.go(-1);</script>");
		}
		else {
		if((this.mc-mccopy)>0) {
			if(num>0) {
				if(date.compareTo(date2)>0) {
					scimp.save(xkmd);
					res.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
				out.println("<script language='javascript'>alert('ѡ�γɹ�!���غ���ˢ�½���!');javascript:history.go(-1);</script>");
		}
				else {
					res.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
				out.println("<script language='javascript'>alert('ѡ��ʧ��!ʱ���ѹ�!���غ���ˢ�½���!');javascript:history.go(-1);</script>");
				}
			}
			else {
				res.setContentType("text/html;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script language='javascript'>alert('ѡ��ʧ��!ѡ���˴�����!���غ���ˢ�½���!');javascript:history.go(-1);</script>");
			}
		}
		else{
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script language='javascript'>alert('ѡ��ʧ��!ѡ���Ŵβ���!���غ���ˢ�½���!');javascript:history.go(-1);</script>");
		}
		}
	}
	@RequestMapping("reselect.action")
	public void reselect(@RequestParam(value="kcmc",required=false)String kcmc,
			@RequestParam(value="xh",required=false)String xh,
			@RequestParam(value="xq",required=false)String xq,
			HttpServletResponse res) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");  // ��ʽ��ʱ�� 
        Date date = new Date();// ��ʽ��ʱ�� 
		sdf.format(date);
		scimp.TxClass(xh, xq, kcmc,date);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script language='javascript'>alert('�˿γɹ�!���غ���ˢ�½���!');javascript:history.go(-1);</script>");
	}*/
}
