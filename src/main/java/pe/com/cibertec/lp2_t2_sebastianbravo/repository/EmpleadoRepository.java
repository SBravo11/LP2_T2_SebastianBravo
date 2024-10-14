package pe.com.cibertec.lp2_t2_sebastianbravo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {
    EmpleadoEntity findByDni(String dni);
}
