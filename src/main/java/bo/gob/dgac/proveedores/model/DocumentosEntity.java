package bo.gob.dgac.proveedores.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="documentos", schema="proveedores")
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DocumentosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@Column(name = "id_organizacion")
	private Integer idOrganizacion;
	*/
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_organizacion", referencedColumnName="id")
	private OrganizacionEntity organizacion;
	
		
	@Column(name="nombre_archivo")
	private String nombreArchivo;
	

	@Column(name = "fecha_creacion", updatable = false, insertable = false)
		private LocalDateTime fechaCreacion;
	
	
		
}
