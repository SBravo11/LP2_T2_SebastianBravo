package pe.com.cibertec.lp2_t2_sebastianbravo.service;

import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.AreaEntity;
import java.util.List;

public interface AreaService {
    List<AreaEntity> buscarArea();
    AreaEntity buscarAreaPorId(Integer id);
    void crearArea(AreaEntity areaEntity);
    void actualizarArea(Integer id, AreaEntity areaEntity);
    void eliminarArea(Integer id);
}
