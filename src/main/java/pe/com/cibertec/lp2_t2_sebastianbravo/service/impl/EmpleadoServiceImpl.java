package pe.com.cibertec.lp2_t2_sebastianbravo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.EmpleadoEntity;
import pe.com.cibertec.lp2_t2_sebastianbravo.repository.EmpleadoRepository;
import pe.com.cibertec.lp2_t2_sebastianbravo.service.EmpleadoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> buscarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoEntity buscarEmpleadoPorDni(String dni) {
        return empleadoRepository.findByDni(dni);
    }

    @Override
    public void crearEmpleado(EmpleadoEntity empleadoEntity) {
        empleadoRepository.save(empleadoEntity);
    }

    @Override
    public void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity) {
        EmpleadoEntity empleadoExistente = empleadoRepository.findByDni(empleadoEntity.getDni());
        if(empleadoExistente == null) {
            throw new RuntimeException("Empleado no encontrado");
        }
        try {
            empleadoExistente.setNombreEmpleado(empleadoEntity.getNombreEmpleado());
            empleadoExistente.setApellidoEmpleado(empleadoEntity.getApellidoEmpleado());
            empleadoExistente.setFechaNacimiento(empleadoEntity.getFechaNacimiento());
            empleadoExistente.setCorreoEmpleado(empleadoEntity.getCorreoEmpleado());
            empleadoExistente.setDireccionEmpleado(empleadoEntity.getDireccionEmpleado());
            empleadoExistente.setArea(empleadoEntity.getArea());
            empleadoRepository.save(empleadoExistente);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al actualizar");
        }
    }

    @Override
    public void eliminarEmpleado(String dniEmpleado) {
        EmpleadoEntity empleadoExistente = empleadoRepository.findByDni(dniEmpleado);
        if(empleadoExistente != null) {
            empleadoRepository.delete(empleadoExistente);
        }
    }
}
