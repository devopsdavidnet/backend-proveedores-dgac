package bo.gob.dgac.proveedores.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles", schema="proveedores")
public class RolEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name ="id_rol")
	private Long idRol;
	@Column(name ="nombre_rol")
	private String nombreRol;
	@Column(name ="descripcion")
	private String descripcion;
	
	

}