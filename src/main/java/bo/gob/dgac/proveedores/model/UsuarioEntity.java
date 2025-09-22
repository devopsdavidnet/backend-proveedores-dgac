package bo.gob.dgac.proveedores.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "usuarios", schema = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_proveedor", nullable = false)
    private Integer idProveedor;
    
    /*@ManyToOne(fetch = FetchType.LAZY)  // muchos usuarios pertenecen a una organización
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id", nullable = false)
    private OrganizacionEntity organizacion;*/

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(name = "primer_apellido", nullable = false, length = 255)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 255)
    private String segundoApellido;
    
    @Column(name = "cedula_identidad", nullable = false, length = 255, unique = true)
    private String cedulaIdentidad;

    @Column(nullable = false, length = 15)
    private String celular;

    @Column(nullable = false, length = 255)
    private String cargo;

    @Column(nullable = false, length = 255, unique = true)
    private String correo;

   @Column(nullable = false, length = 255)
    private String contrasenia;
   
   @Column(name="rol_usuario")
   private Integer rolUsuario;
   
    @Column(name = "fecha_creado", columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime fechaCreado;
    
    
    

    @PrePersist
    protected void onCreate() {
        this.fechaCreado = OffsetDateTime.now();
    }
    
    
    
}
