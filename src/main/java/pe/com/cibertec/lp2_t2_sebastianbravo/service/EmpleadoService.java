package pe.com.cibertec.lp2_t2_sebastianbravo.service;

import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.EmpleadoEntity;
import java.util.List;

public interface EmpleadoService {
    List<EmpleadoEntity> buscarEmpleados();
    EmpleadoEntity buscarEmpleadoPorDni(String dni);
    void crearEmpleado(EmpleadoEntity empleadoEntity);
    void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity);
    void eliminarEmpleado(String dniEmpleado);
}
