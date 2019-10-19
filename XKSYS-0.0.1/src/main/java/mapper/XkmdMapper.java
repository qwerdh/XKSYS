package mapper;

import java.util.Date;
import java.util.List;

import pojo.Xkmd;

public interface XkmdMapper {
	public void save(Xkmd xkmd);
	public Integer findnumber(Integer kcxh);
	public List<Xkmd> findNowClass(String xh, String xq);
	public void TxClass(String xh,String xq,String kcmc,Date date);
}