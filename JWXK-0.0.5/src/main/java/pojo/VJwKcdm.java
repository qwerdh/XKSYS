package pojo;

import java.io.Serializable;

public class VJwKcdm  implements Serializable{
    private Integer id;

    private String kcdm;

    private String kcmc;

    private String dwh;

    private String kcywmc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKcdm() {
        return kcdm;
    }

    public void setKcdm(String kcdm) {
        this.kcdm = kcdm == null ? null : kcdm.trim();
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc == null ? null : kcmc.trim();
    }

    public String getDwh() {
        return dwh;
    }

    public void setDwh(String dwh) {
        this.dwh = dwh == null ? null : dwh.trim();
    }

    public String getKcywmc() {
        return kcywmc;
    }

    public void setKcywmc(String kcywmc) {
        this.kcywmc = kcywmc == null ? null : kcywmc.trim();
    }
    @Override
    public String toString() {
    	return kcmc;
    	
    }
}