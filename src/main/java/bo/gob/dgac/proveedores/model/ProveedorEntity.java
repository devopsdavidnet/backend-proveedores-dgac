package bo.gob.dgac.proveedores.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "proveedores", schema = "proveedores")
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor

public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

    @Column(name = "nombre_proveedor", length = 255)
    private String nombreProveedor;
    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "fecha_creado")
    private OffsetDateTime fechaCreado;

    @PrePersist
    protected void onCreate() {
        this.fechaCreado = OffsetDateTime.now();
    }
}
