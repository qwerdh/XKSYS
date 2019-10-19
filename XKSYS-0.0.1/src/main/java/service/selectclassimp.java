package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.VJwCjGgxxMapper;
import mapper.VJwGgxxMapper;
import mapper.VJwKcdmMapper;
import mapper.VJwLbdhMapper;
import mapper.VJwXkqxGgxxMapper;
import mapper.VJwXsMapper;
import mapper.XkmdMapper;
import mapper.XsVNewMapper;
import pojo.VJwCjGgxx;
import pojo.VJwGgxx;
import pojo.VJwXkqxGgxx;
import pojo.Xkmd;
@Service
public class selectclassimp implements selectclass{
	/*ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	VJwGgxxMapper vjwggxxmapper=(VJwGgxxMapper) ac.getBean("VJwGgxxMapper");
	XkmdMapper xkmdmapper=(XkmdMapper) ac.getBean("XkmdMapper");*/
	@Autowired
	private VJwGgxxMapper vjwggxxmapper;
	@Autowired
	private XkmdMapper xkmdmapper;
	@Autowired
	private VJwXkqxGgxxMapper vjwxkqxggxxmapper;
	@Autowired
	private VJwXsMapper vjwxsmapper;
	@Autowired
	private VJwLbdhMapper vjwlbdhmapper;
	@Autowired
	private VJwCjGgxxMapper vjwcjggxxmapper;
	@Override
	public double findNJ(String xh) {
		double nj=vjwxsmapper.findNj(xh);
		return  nj;
	}
	@Override
	public List<VJwGgxx> findClasses(String xh,String xq) {
		List<VJwGgxx> studentclasses=vjwggxxmapper.findClassses(xh,xh);
		return studentclasses;
	}
	@Override
	public Integer findMc(Integer nj) {
		Integer mc=vjwxkqxggxxmapper.findMc(nj);
		return mc;
	}
	@Override
	public String findXq(double nj) {
		String Term=vjwxkqxggxxmapper.findTerm(nj);
		return Term;
	}
	@Override
	public Date findBegin(Integer nj) {
		Date date=vjwxkqxggxxmapper.findBegin(nj);
		return date;
	}
	@Override
	public void save(Xkmd xkmd) {
		xkmd.setTx(false);
		xkmdmapper.save(xkmd);
	}
	@Override
	public String findXm(String xh) {
		String xm=vjwxsmapper.findXm(xh);
		return xm;
	}
	@Override
	public Integer findnumber(String kcxh,String xq) {
		Integer num=xkmdmapper.findnumber(Integer.parseInt(kcxh));
		Integer xxrc=vjwggxxmapper.findxxrc(Integer.parseInt(kcxh),xq);
		return (xxrc-num);
	}
	@Override
	public List<VJwCjGgxx> findBefSelect(String xh) {
		List<VJwCjGgxx> BefClass=vjwcjggxxmapper.findBefSelect(xh);
		return BefClass;
	}
	@Override
	public List<Xkmd> findNowClass(String xh, String xq) {
		List<Xkmd> xkmd=xkmdmapper.findNowClass(xh,xq);
		return xkmd;
	}
	@Override
	public void TxClass(String xh,String xq,String kcmc,Date date) {
		xkmdmapper.TxClass(xh, xq, kcmc,date);
	}
	@Override
	public VJwXkqxGgxx findqx(int nj) {
		VJwXkqxGgxx qx=vjwxkqxggxxmapper.findqx(nj);
		return qx;
	}
}
