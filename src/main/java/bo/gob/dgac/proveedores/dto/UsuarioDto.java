package bo.gob.dgac.proveedores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String estadoRegistro;


}
