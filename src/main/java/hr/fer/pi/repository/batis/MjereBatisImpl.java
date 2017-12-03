package hr.fer.pi.repository.batis;

import hr.fer.pi.model.custom_sql_model.MjereSQL;
import hr.fer.pi.repository.batis.mapper.MjereMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
@Transactional
@Repository
public class MjereBatisImpl {

    private final MjereMapper mjereMapper;

    @Autowired
    public MjereBatisImpl(MjereMapper mjereMapper) {
        this.mjereMapper = mjereMapper;
    }

    public List<MjereSQL> getMjereBySifTablica(Integer ID){
        return mjereMapper.getMjere(ID);
    }
}
