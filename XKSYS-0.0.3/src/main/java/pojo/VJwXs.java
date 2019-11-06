package pojo;

import java.io.Serializable;

public class VJwXs implements Serializable{
    private Double nj;

    private String bh;

    private String bj;

    private String xh;

    private String xm;

    private String xb;

    private String xbdm;

    private String xbmc;

    private String zydm;

    private String zymc;

    private Integer xjqkdm;

    private String xjqk;

    public Double getNj() {
        return nj;
    }

    public void setNj(Double nj) {
        this.nj = nj;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj == null ? null : bj.trim();
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    public String getXbdm() {
        return xbdm;
    }

    public void setXbdm(String xbdm) {
        this.xbdm = xbdm == null ? null : xbdm.trim();
    }

    public String getXbmc() {
        return xbmc;
    }

    public void setXbmc(String xbmc) {
        this.xbmc = xbmc == null ? null : xbmc.trim();
    }

    public String getZydm() {
        return zydm;
    }

    public void setZydm(String zydm) {
        this.zydm = zydm == null ? null : zydm.trim();
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc == null ? null : zymc.trim();
    }

    public Integer getXjqkdm() {
        return xjqkdm;
    }

    public void setXjqkdm(Integer xjqkdm) {
        this.xjqkdm = xjqkdm;
    }

    public String getXjqk() {
        return xjqk;
    }

    public void setXjqk(String xjqk) {
        this.xjqk = xjqk == null ? null : xjqk.trim();
    }
}