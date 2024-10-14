package pe.com.cibertec.lp2_t2_sebastianbravo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoEntity {

    @Id
    @Column(name = "dni_empleado", nullable = false, columnDefinition = "CHAR(8)", length = 8)
    private String dni;

    @Column(name = "nombre_empleado", nullable = false, columnDefinition = "VARCHAR(45)", length = 45)
    private String nombreEmpleado;

    @Column(name = "apellido_empleado", nullable = false, columnDefinition = "VARCHAR(45)", length = 45)
    private String apellidoEmpleado;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "direccion", nullable = false, length = 45, columnDefinition = "VARCHAR(45)")
    private String direccionEmpleado;

    @Column(name = "correo", nullable = false, length = 45, columnDefinition = "VARCHAR(45)")
    private String correoEmpleado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    private AreaEntity area;
}
