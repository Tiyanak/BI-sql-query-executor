package hr.fer.pi.model.ajax;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class TreeNode {

    public String text;
    public String sifTablica;
    public String nazSQLTablica;
    public String tipTablica;
    public String imeSQLAtrib;
    public String imeAtrib;
    public String nazAgrFun;
    public String imeAtribAgrFun;
    public Boolean isMjera;
    public List<TreeNode> nodes;

    public TreeNode() {
    }

    public TreeNode(String text, List<TreeNode> nodes) {
        this.text = text;
        this.nodes = nodes;
        this.isMjera = false;
    }

    public TreeNode(String text, String sifTablica, String nazSQLTablica, String tipTablica, String imeSQLAtrib, String imeAtrib, String nazAgrFun, String imeAtribAgrFun, Boolean isMjera, List<TreeNode> nodes) {
        this.text = text;
        this.sifTablica = sifTablica;
        this.nazSQLTablica = nazSQLTablica;
        this.tipTablica = tipTablica;
        this.imeSQLAtrib = imeSQLAtrib;
        this.imeAtrib = imeAtrib;
        this.nazAgrFun = nazAgrFun;
        this.imeAtribAgrFun = imeAtribAgrFun;
        this.isMjera = isMjera;
        this.nodes = nodes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public String getSifTablica() {
        return sifTablica;
    }

    public void setSifTablica(String sifTablica) {
        this.sifTablica = sifTablica;
    }

    public String getNazSQLTablica() {
        return nazSQLTablica;
    }

    public void setNazSQLTablica(String nazSQLTablica) {
        this.nazSQLTablica = nazSQLTablica;
    }

    public String getTipTablica() {
        return tipTablica;
    }

    public void setTipTablica(String tipTablica) {
        this.tipTablica = tipTablica;
    }

    public String getImeSQLAtrib() {
        return imeSQLAtrib;
    }

    public void setImeSQLAtrib(String imeSQLAtrib) {
        this.imeSQLAtrib = imeSQLAtrib;
    }

    public String getImeAtrib() {
        return imeAtrib;
    }

    public void setImeAtrib(String imeAtrib) {
        this.imeAtrib = imeAtrib;
    }

    public String getNazAgrFun() {
        return nazAgrFun;
    }

    public void setNazAgrFun(String nazAgrFun) {
        this.nazAgrFun = nazAgrFun;
    }

    public String getImeAtribAgrFun() {
        return imeAtribAgrFun;
    }

    public void setImeAtribAgrFun(String imeAtribAgrFun) {
        this.imeAtribAgrFun = imeAtribAgrFun;
    }

    public Boolean getMjera() {
        return isMjera;
    }

    public void setMjera(Boolean mjera) {
        isMjera = mjera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        return text.equals(treeNode.text);

    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
