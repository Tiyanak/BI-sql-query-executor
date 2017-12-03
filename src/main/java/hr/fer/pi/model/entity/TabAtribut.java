package hr.fer.pi.model.entity;

import hr.fer.pi.model.embedded.TabAtributId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * Created by Igor Farszky on 1.12.2017..
 */

@Entity
@Table(name = "tabAtribut")
public class TabAtribut implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TabAtributId tabAtributId;

    @Column(name = "imeSQLAtrib")
    @NotNull
    private String imeSQLAtrib;

    @Column(name = "sifTipAtrib")
    @Null
    private Integer sifTipAtrib;

    @Column(name = "imeAtrib")
    @NotNull
    private String imeAtrib;

    public TabAtribut() {
    }

    public TabAtribut(String imeSQLAtrib, Integer sifTipAtrib, String imeAtrib) {
        this.imeSQLAtrib = imeSQLAtrib;
        this.sifTipAtrib = sifTipAtrib;
        this.imeAtrib = imeAtrib;
    }

    public TabAtribut(TabAtributId tabAtributId, String imeSQLAtrib, Integer sifTipAtrib, String imeAtrib) {
        this.tabAtributId = tabAtributId;
        this.imeSQLAtrib = imeSQLAtrib;
        this.sifTipAtrib = sifTipAtrib;
        this.imeAtrib = imeAtrib;
    }

    public TabAtributId getTabAtributId() {
        return tabAtributId;
    }

    public void setTabAtributId(TabAtributId tabAtributId) {
        this.tabAtributId = tabAtributId;
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
}
