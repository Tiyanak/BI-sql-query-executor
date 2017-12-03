package hr.fer.pi.service;

import hr.fer.pi.model.custom_sql_model.DimenzijeSQL;
import hr.fer.pi.model.custom_sql_model.MjereSQL;
import hr.fer.pi.model.entity.AgrFun;
import hr.fer.pi.model.entity.DimCinj;
import hr.fer.pi.model.entity.TabAtribut;
import hr.fer.pi.model.entity.Tablica;
import hr.fer.pi.repository.batis.DimenzijeBatisImpl;
import hr.fer.pi.repository.batis.MjereBatisImpl;
import hr.fer.pi.repository.metadata_repository.*;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Service
public class MetadataService {

    private final AgrFunRepository agrFunRepository;
    private final TablicaRepository tablicaRepository;
    private final DimCinjRepository dimCinjRepository;
    private final TabAtributRepository tabAtributRepository;
    private final MjereBatisImpl mjereBatis;
    private final DimenzijeBatisImpl dimenzijeBatis;

    @Autowired
    public MetadataService(MjereBatisImpl mjereBatis, AgrFunRepository agrFunRepository, TablicaRepository tablicaRepository, DimenzijeBatisImpl dimenzijeBatis, DimCinjRepository dimCinjRepository, TabAtributRepository tabAtributRepository) {
        this.mjereBatis = mjereBatis;
        this.agrFunRepository = agrFunRepository;
        this.tablicaRepository = tablicaRepository;
        this.dimenzijeBatis = dimenzijeBatis;
        this.dimCinjRepository = dimCinjRepository;
        this.tabAtributRepository = tabAtributRepository;
    }

    public List<AgrFun> getAllAgrFun() {
        return agrFunRepository.findAll();
    }

    public List<Tablica> getAllCinjenice() {
        return tablicaRepository.findBySifTipTablica(1);
    }

    public List<MjereSQL> getMjereBySifTablica(Integer ID) {
        return mjereBatis.getMjereBySifTablica(ID);
    }

    public List<DimenzijeSQL> getDimenzijeBySifTablica(Integer ID) {
        return dimenzijeBatis.getDimenzije(ID);
    }

    public Tablica getTablicaBySif(Integer sif) {
        return tablicaRepository.findBySifTablica(sif);
    }

    public List<DimCinj> getDimCinjFK(Integer sifCinjTablica, Integer sifDimTablica) {
        return dimCinjRepository.findBySifCinjTablicaAndSifDimTablica(sifCinjTablica, sifDimTablica);
    }

    public TabAtribut getTabAtributBySifTablicaByRbrAtrib(Integer sifTablica, Integer rbrAtrib) {
        return tabAtributRepository.findBySifTablicaAndRbrAtrib(sifTablica, rbrAtrib);
    }
}
