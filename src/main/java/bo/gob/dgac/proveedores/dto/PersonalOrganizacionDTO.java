package bo.gob.dgac.proveedores.dto;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class PersonalOrganizacionDTO {
    private Long id;
    private Long organizacionId;
    private Long cargoId;
    private String nombre;
    private String telefono;
    private String correo;
    private LocalDate fechaDesignacion;
}