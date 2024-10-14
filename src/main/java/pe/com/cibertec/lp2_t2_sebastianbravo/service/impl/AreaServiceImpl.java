package pe.com.cibertec.lp2_t2_sebastianbravo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.AreaEntity;
import pe.com.cibertec.lp2_t2_sebastianbravo.repository.AreaRepository;
import pe.com.cibertec.lp2_t2_sebastianbravo.service.AreaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    @Override
    public List<AreaEntity> buscarArea() {
        return areaRepository.findAll();
    }

    @Override
    public AreaEntity buscarAreaPorId(Integer id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearArea(AreaEntity areaEntity) {
        areaRepository.save(areaEntity);
    }

    @Override
    public void actualizarArea(Integer id, AreaEntity areaEntity) {
        AreaEntity areaEncontrada = buscarAreaPorId(areaEntity.getAreaId());
        if(areaEncontrada == null) {
            throw new RuntimeException("Area no encontrada");
        }
        try{
            areaEncontrada.setAreaNombre(areaEntity.getAreaNombre());
            areaEncontrada.setEmpleados(areaEntity.getEmpleados());
            areaRepository.save(areaEncontrada);
        } catch (Exception e){
            throw new RuntimeException("Ocurrió un error al actualizar "+e.getMessage());
        }
    }

    @Override
    public void eliminarArea(Integer id) {
        AreaEntity areaEncontrada = buscarAreaPorId(id);
        if(areaEncontrada != null) {
            areaRepository.delete(areaEncontrada);
        }
    }
}
