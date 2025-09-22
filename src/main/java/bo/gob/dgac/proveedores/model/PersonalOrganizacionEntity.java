package bo.gob.dgac.proveedores.model;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "personal_organizacion", schema = "proveedores")
@Data
@Builder
public class PersonalOrganizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "organizacion_id", nullable = false)
    private Integer organizacionId;

    @Column(name = "cargo_id", nullable = false)
    private Integer cargoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "fecha_designacion")
    private LocalDate fechaDesignacion;
}