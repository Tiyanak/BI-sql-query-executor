package hr.fer.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Igor Farszky on 1.12.2017..
 */

@Entity
@Table(name = "tablica")
public class Tablica implements Serializable {

    @Id
    @Column(name = "sifTablica")
    @NotNull
    private Integer sifTablica;

    @Column(name = "nazTablica")
    @NotNull
    private String nazTablica;

    @Column(name = "nazSQLTablica")
    @NotNull
    private String nazSQLTablica;

    @Column(name = "sifTipTablica")
    @NotNull
    private Integer sifTipTablica;

    public Tablica() {
    }

    public Tablica(Integer sifTablica, String nazTablica, String nazSQLTablica, Integer sifTipTablica) {
        this.sifTablica = sifTablica;
        this.nazTablica = nazTablica;
        this.nazSQLTablica = nazSQLTablica;
        this.sifTipTablica = sifTipTablica;
    }

    public Integer getSifTablica() {
        return sifTablica;
    }

    public void setSifTablica(Integer sifTablica) {
        this.sifTablica = sifTablica;
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
}
