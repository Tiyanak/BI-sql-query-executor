package hr.fer.pi.model.custom_sql_model;

import java.io.Serializable;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
public class DimenzijeSQL implements Serializable {

    // tabAtribut
    private Integer sifTablica;
    private Integer rbrAtrib;
    private String imeSQLAtrib;
    private Integer sifTipAtrib;
    private String imeAtrib;

    //dimCinj
    private Integer sifCinjTablica;
    private Integer sifDimTablica;
    private Integer rbrCinj;
    private Integer rbrDim;

    // tablica dimTablica
    private Integer sifTablicaDim;
    private String nazTablicaDim;
    private String nazSQLTablicaDim;
    private Integer sifTipTablicaDim;

    // tablica cinjTablica
    private Integer sifTablicaCinj;
    private String nazTablicaCinj;
    private String nazSQLTablicaCinj;
    private Integer sifTipTablicaCinj;

    // tabAtributCinj
    private Integer sifTablicaCinjAtr;
    private Integer rbrAtribCinjAtr;
    private String imeSQLAtribCinjAtr;
    private Integer sifTipAtribCinjAtr;
    private String imeAtribCinjAtr;

    // tabAtributDim
    private Integer sifTablicaDimAtr;
    private Integer rbrAtribDimAtr;
    private String imeSQLAtribDimAtr;
    private Integer sifTipAtribDimAtr;
    private String imeAtribDimAtr;

    public DimenzijeSQL() {
    }

    public DimenzijeSQL(Integer sifTablica, Integer rbrAtrib, String imeSQLAtrib, Integer sifTipAtrib, String imeAtrib, Integer sifCinjTablica, Integer sifDimTablica, Integer rbrCinj, Integer rbrDim, Integer sifTablicaDim, String nazTablicaDim, String nazSQLTablicaDim, Integer sifTipTablicaDim, Integer sifTablicaCinj, String nazTablicaCinj, String nazSQLTablicaCinj, Integer sifTipTablicaCinj, Integer sifTablicaCinjAtr, Integer rbrAtribCinjAtr, String imeSQLAtribCinjAtr, Integer sifTipAtribCinjAtr, String imeAtribCinjAtr, Integer sifTablicaDimAtr, Integer rbrAtribDimAtr, String imeSQLAtribDimAtr, Integer sifTipAtribDimAtr, String imeAtribDimAtr) {
        this.sifTablica = sifTablica;
        this.rbrAtrib = rbrAtrib;
        this.imeSQLAtrib = imeSQLAtrib;
        this.sifTipAtrib = sifTipAtrib;
        this.imeAtrib = imeAtrib;
        this.sifCinjTablica = sifCinjTablica;
        this.sifDimTablica = sifDimTablica;
        this.rbrCinj = rbrCinj;
        this.rbrDim = rbrDim;
        this.sifTablicaDim = sifTablicaDim;
        this.nazTablicaDim = nazTablicaDim;
        this.nazSQLTablicaDim = nazSQLTablicaDim;
        this.sifTipTablicaDim = sifTipTablicaDim;
        this.sifTablicaCinj = sifTablicaCinj;
        this.nazTablicaCinj = nazTablicaCinj;
        this.nazSQLTablicaCinj = nazSQLTablicaCinj;
        this.sifTipTablicaCinj = sifTipTablicaCinj;
        this.sifTablicaCinjAtr = sifTablicaCinjAtr;
        this.rbrAtribCinjAtr = rbrAtribCinjAtr;
        this.imeSQLAtribCinjAtr = imeSQLAtribCinjAtr;
        this.sifTipAtribCinjAtr = sifTipAtribCinjAtr;
        this.imeAtribCinjAtr = imeAtribCinjAtr;
        this.sifTablicaDimAtr = sifTablicaDimAtr;
        this.rbrAtribDimAtr = rbrAtribDimAtr;
        this.imeSQLAtribDimAtr = imeSQLAtribDimAtr;
        this.sifTipAtribDimAtr = sifTipAtribDimAtr;
        this.imeAtribDimAtr = imeAtribDimAtr;
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

    public String getImeAtrib() {
        return imeAtrib;
    }

    public void setImeAtrib(String imeAtrib) {
        this.imeAtrib = imeAtrib;
    }

    public Integer getSifCinjTablica() {
        return sifCinjTablica;
    }

    public void setSifCinjTablica(Integer sifCinjTablica) {
        this.sifCinjTablica = sifCinjTablica;
    }

    public Integer getSifDimTablica() {
        return sifDimTablica;
    }

    public void setSifDimTablica(Integer sifDimTablica) {
        this.sifDimTablica = sifDimTablica;
    }

    public Integer getRbrCinj() {
        return rbrCinj;
    }

    public void setRbrCinj(Integer rbrCinj) {
        this.rbrCinj = rbrCinj;
    }

    public Integer getRbrDim() {
        return rbrDim;
    }

    public void setRbrDim(Integer rbrDim) {
        this.rbrDim = rbrDim;
    }

    public Integer getSifTablicaDim() {
        return sifTablicaDim;
    }

    public void setSifTablicaDim(Integer sifTablicaDim) {
        this.sifTablicaDim = sifTablicaDim;
    }

    public String getNazTablicaDim() {
        return nazTablicaDim;
    }

    public void setNazTablicaDim(String nazTablicaDim) {
        this.nazTablicaDim = nazTablicaDim;
    }

    public String getNazSQLTablicaDim() {
        return nazSQLTablicaDim;
    }

    public void setNazSQLTablicaDim(String nazSQLTablicaDim) {
        this.nazSQLTablicaDim = nazSQLTablicaDim;
    }

    public Integer getSifTipTablicaDim() {
        return sifTipTablicaDim;
    }

    public void setSifTipTablicaDim(Integer sifTipTablicaDim) {
        this.sifTipTablicaDim = sifTipTablicaDim;
    }

    public Integer getSifTablicaCinj() {
        return sifTablicaCinj;
    }

    public void setSifTablicaCinj(Integer sifTablicaCinj) {
        this.sifTablicaCinj = sifTablicaCinj;
    }

    public String getNazTablicaCinj() {
        return nazTablicaCinj;
    }

    public void setNazTablicaCinj(String nazTablicaCinj) {
        this.nazTablicaCinj = nazTablicaCinj;
    }

    public String getNazSQLTablicaCinj() {
        return nazSQLTablicaCinj;
    }

    public void setNazSQLTablicaCinj(String nazSQLTablicaCinj) {
        this.nazSQLTablicaCinj = nazSQLTablicaCinj;
    }

    public Integer getSifTipTablicaCinj() {
        return sifTipTablicaCinj;
    }

    public void setSifTipTablicaCinj(Integer sifTipTablicaCinj) {
        this.sifTipTablicaCinj = sifTipTablicaCinj;
    }

    public Integer getSifTablicaCinjAtr() {
        return sifTablicaCinjAtr;
    }

    public void setSifTablicaCinjAtr(Integer sifTablicaCinjAtr) {
        this.sifTablicaCinjAtr = sifTablicaCinjAtr;
    }

    public Integer getRbrAtribCinjAtr() {
        return rbrAtribCinjAtr;
    }

    public void setRbrAtribCinjAtr(Integer rbrAtribCinjAtr) {
        this.rbrAtribCinjAtr = rbrAtribCinjAtr;
    }

    public String getImeSQLAtribCinjAtr() {
        return imeSQLAtribCinjAtr;
    }

    public void setImeSQLAtribCinjAtr(String imeSQLAtribCinjAtr) {
        this.imeSQLAtribCinjAtr = imeSQLAtribCinjAtr;
    }

    public Integer getSifTipAtribCinjAtr() {
        return sifTipAtribCinjAtr;
    }

    public void setSifTipAtribCinjAtr(Integer sifTipAtribCinjAtr) {
        this.sifTipAtribCinjAtr = sifTipAtribCinjAtr;
    }

    public String getImeAtribCinjAtr() {
        return imeAtribCinjAtr;
    }

    public void setImeAtribCinjAtr(String imeAtribCinjAtr) {
        this.imeAtribCinjAtr = imeAtribCinjAtr;
    }

    public Integer getSifTablicaDimAtr() {
        return sifTablicaDimAtr;
    }

    public void setSifTablicaDimAtr(Integer sifTablicaDimAtr) {
        this.sifTablicaDimAtr = sifTablicaDimAtr;
    }

    public Integer getRbrAtribDimAtr() {
        return rbrAtribDimAtr;
    }

    public void setRbrAtribDimAtr(Integer rbrAtribDimAtr) {
        this.rbrAtribDimAtr = rbrAtribDimAtr;
    }

    public String getImeSQLAtribDimAtr() {
        return imeSQLAtribDimAtr;
    }

    public void setImeSQLAtribDimAtr(String imeSQLAtribDimAtr) {
        this.imeSQLAtribDimAtr = imeSQLAtribDimAtr;
    }

    public Integer getSifTipAtribDimAtr() {
        return sifTipAtribDimAtr;
    }

    public void setSifTipAtribDimAtr(Integer sifTipAtribDimAtr) {
        this.sifTipAtribDimAtr = sifTipAtribDimAtr;
    }

    public String getImeAtribDimAtr() {
        return imeAtribDimAtr;
    }

    public void setImeAtribDimAtr(String imeAtribDimAtr) {
        this.imeAtribDimAtr = imeAtribDimAtr;
    }
}


