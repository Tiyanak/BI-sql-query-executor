package hr.fer.pi.repository.batis.mapper;

import hr.fer.pi.model.custom_sql_model.MjereSQL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
@Mapper
public interface MjereMapper {

    static final String SELECT_MJERE =
            "SELECT"
                + " tabA.sifTablica AS sifTablica,"
                + " tabA.rbrAtrib AS rbrAtrib,"
                + " tabA.imeSQLAtrib AS imeSQLAtrib,"
                + " tabA.sifTipAtrib AS sifTipAtrib,"
                + " tabA.imeAtrib AS imeAtribNoAgrFun,"
                + " aF.sifAgrFun AS sifAgrFun,"
                + " aF.nazAgrFun AS nazAgrFun,"
                + " t.nazTablica AS nazTablica,"
                + " t.nazSQLTablica AS nazSQLTablica,"
                + " t.sifTipTablica AS sifTipTablica,"
                + " tabAF.imeAtrib AS imeAtrib"
                + " FROM tabAtribut tabA"
                + " JOIN tabAtributAgrFun tabAF ON tabA.sifTablica = tabAF.sifTablica AND tabA.rbrAtrib = tabAF.rbrAtrib"
                + " JOIN agrFun aF ON aF.sifAgrFun = tabAF.sifAgrFun"
                + " JOIN tablica t ON t.sifTablica = tabA.sifTablica"
                + " WHERE tabA.sifTablica = #{ID}"
                + " AND tabA.sifTipAtrib = 1"
                + " ORDER BY tabA.rbrAtrib";

    @Select(SELECT_MJERE) public List<MjereSQL> getMjere(Integer ID);

}
