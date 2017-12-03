package hr.fer.pi.repository.batis;

import hr.fer.pi.model.custom_sql_model.DimenzijeSQL;
import hr.fer.pi.repository.batis.mapper.DimenzijeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
@Transactional
@Repository
public class DimenzijeBatisImpl {

    private final DimenzijeMapper dimenzijeMapper;

    @Autowired
    public DimenzijeBatisImpl(DimenzijeMapper dimenzijeMapper) {
        this.dimenzijeMapper = dimenzijeMapper;
    }

    public List<DimenzijeSQL> getDimenzije(Integer ID) {
        return dimenzijeMapper.getDimenzije(ID);
    }

}
