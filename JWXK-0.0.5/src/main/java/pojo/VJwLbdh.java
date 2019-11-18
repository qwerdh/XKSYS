package pojo;

import java.io.Serializable;

public class VJwLbdh implements Serializable{
    private String lbdh;

    private String lbmc;

    public String getLbdh() {
        return lbdh;
    }

    public void setLbdh(String lbdh) {
        this.lbdh = lbdh == null ? null : lbdh.trim();
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc == null ? null : lbmc.trim();
    }
}