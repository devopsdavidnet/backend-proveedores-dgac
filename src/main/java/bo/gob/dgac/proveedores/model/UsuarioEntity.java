package bo.gob.dgac.proveedores.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
   
   @ManyToOne 
   @JoinColumn(name="rol_usuario", referencedColumnName="id_rol")
   private RolEntity rolUsuario;
   
   @Column(name="estado_registro")
   private String estadoRegistro;
   
    @Column(name = "fecha_creado", columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime fechaCreado;
    
    @PrePersist
    protected void onCreate() {
        this.fechaCreado = OffsetDateTime.now();
    }

    
}
