package mapper;

import java.util.List;

import pojo.VJwGgxx;

public interface VJwGgxxMapper {
	public List<VJwGgxx> findClassses(String xh,String xq);
	public Integer findxxrc(Integer kcxh,String xq);
	public List<VJwGgxx> findAllClassses(String xq);
}