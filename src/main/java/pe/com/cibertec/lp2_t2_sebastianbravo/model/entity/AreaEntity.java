package pe.com.cibertec.lp2_t2_sebastianbravo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "nombre_area", nullable = false, columnDefinition = "VARCHAR(45)", unique = true, length = 45)
    private String areaNombre;

    @OneToMany(mappedBy = "area")
    private Set<EmpleadoEntity> empleados = new HashSet<>();
}
