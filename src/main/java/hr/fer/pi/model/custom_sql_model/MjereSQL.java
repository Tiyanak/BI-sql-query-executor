package hr.fer.pi.model.custom_sql_model;

import java.io.Serializable;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
public class MjereSQL implements Serializable {

    // tabAtribut
    private Integer sifTablica;
    private Integer rbrAtrib;
    private String imeSQLAtrib;
    private Integer sifTipAtrib;
    private String imeAtribNoAgrFun;

    // agrFun
    private Integer sifAgrFun;
    private String nazAgrFun;

    // tablica
    private String nazTablica;
    private String nazSQLTablica;
    private Integer sifTipTablica;

    // tabAtributAgrFun
    private String imeAtrib;

    public MjereSQL() {
    }

    public MjereSQL(Integer sifTablica, Integer rbrAtrib, String imeSQLAtrib, Integer sifTipAtrib, String imeAtribNoAgrFun, Integer sifAgrFun, String nazAgrFun, String nazTablica, String nazSQLTablica, Integer sifTipTablica, String imeAtrib) {
        this.sifTablica = sifTablica;
        this.rbrAtrib = rbrAtrib;
        this.imeSQLAtrib = imeSQLAtrib;
        this.sifTipAtrib = sifTipAtrib;
        this.imeAtribNoAgrFun = imeAtribNoAgrFun;
        this.sifAgrFun = sifAgrFun;
        this.nazAgrFun = nazAgrFun;
        this.nazTablica = nazTablica;
        this.nazSQLTablica = nazSQLTablica;
        this.sifTipTablica = sifTipTablica;
        this.imeAtrib = imeAtrib;
    }

    public Integer getSifTablica() {
        return sifTablica;
    }

    public void setSifTablica(Integer sifTablica) {
        this.sifTablica = sifTablica;
    }

    public Integer getRbrAtrib() {
        return rbrAtrib;
    }

    public void setRbrAtrib(Integer rbrAtrib) {
        this.rbrAtrib = rbrAtrib;
    }

    public String getImeSQLAtrib() {
        return imeSQLAtrib;
    }

    public void setImeSQLAtrib(String imeSQLAtrib) {
        this.imeSQLAtrib = imeSQLAtrib;
    }

    public Integer getSifTipAtrib() {
        return sifTipAtrib;
    }

    public void setSifTipAtrib(Integer sifTipAtrib) {
        this.sifTipAtrib = sifTipAtrib;
    }

    public String getImeAtribNoAgrFun() {
        return imeAtribNoAgrFun;
    }

    public void setImeAtribNoAgrFun(String imeAtribNoAgrFun) {
        this.imeAtribNoAgrFun = imeAtribNoAgrFun;
    }

    public Integer getSifAgrFun() {
        return sifAgrFun;
    }

    public void setSifAgrFun(Integer sifAgrFun) {
        this.sifAgrFun = sifAgrFun;
    }

    public String getNazAgrFun() {
        return nazAgrFun;
    }

    public void setNazAgrFun(String nazAgrFun) {
        this.nazAgrFun = nazAgrFun;
    }

    public String getNazTablica() {
        return nazTablica;
    }

    public void setNazTablica(String nazTablica) {
        this.nazTablica = nazTablica;
    }

    public String getNazSQLTablica() {
        return nazSQLTablica;
    }

    public void setNazSQLTablica(String nazSQLTablica) {
        this.nazSQLTablica = nazSQLTablica;
    }

    public Integer getSifTipTablica() {
        return sifTipTablica;
    }

    public void setSifTipTablica(Integer sifTipTablica) {
        this.sifTipTablica = sifTipTablica;
    }

    public String getImeAtrib() {
        return imeAtrib;
    }

    public void setImeAtrib(String imeAtrib) {
        this.imeAtrib = imeAtrib;
    }
}


