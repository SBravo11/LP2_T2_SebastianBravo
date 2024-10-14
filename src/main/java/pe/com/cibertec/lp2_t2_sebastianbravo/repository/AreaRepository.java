package pe.com.cibertec.lp2_t2_sebastianbravo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.AreaEntity;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Integer> {

}
