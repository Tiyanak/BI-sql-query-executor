package hr.fer.pi.repository.metadata_repository;

import hr.fer.pi.model.entity.AgrFun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Transactional
public interface AgrFunRepository extends JpaRepository<AgrFun, Integer> {
}
