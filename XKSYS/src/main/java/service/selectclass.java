package service;

import java.util.Date;
import java.util.List;

import pojo.VJwCjGgxx;
import pojo.VJwGgxx;
import pojo.VJwXkqxGgxx;
import pojo.Xkmd;

public interface selectclass {
	public List<VJwGgxx> findClasses(String xh,String xq);
	public double findNJ(String xh);
	public Integer findMc(Integer nj);
	public String findXq(double nj);
	public Date findBegin(Integer nj);
	public void save(Xkmd xkmd);
	public String findXm(String xh);
	public Integer findnumber(String kcxh,String xq);
	public List<VJwCjGgxx> findBefSelect(String xh);
	public List<Xkmd> findNowClass(String xh,String xq);
	public void TxClass(String xh,String xq,String kcmc,Date date);
	public VJwXkqxGgxx findqx(int nj);
}
