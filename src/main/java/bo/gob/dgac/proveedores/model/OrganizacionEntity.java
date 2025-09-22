package bo.gob.dgac.proveedores.model;

import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organizaciones", schema = "proveedores")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrganizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="nombre_organizacion")
    private String nombreOrganizacion;
    @Column(name ="tipo_explotador")
    private String tipoExplotador;
    @Column(name ="departamento_id")
    private Integer departamentoId;
    @Column(name ="direccion")
    private String direccion;
    @Column(name ="telefono")
    private String telefono;
    @Column(name ="correo")
    private String correo;
    @Column(name ="fecha_inicial_certificacion")
    private LocalDate fechaInicialCertificacion;
    @Column(name ="fecha_expiracion_certificacion")
    private LocalDate fechaExpiracionCertificacion;
    @Column(name ="numero_certificado")
    private String numeroCertificado;
    @Column(name ="numero_resolucion")
    private String numeroResolucion;
    @Column (name ="resolucion_clase_certificacion")
    private Integer resolucionClaseCertificacion;
    
    @Column (name ="otra_resolucion_clase_certificacion")
    private String otraResolucionClaseCertificacion;
    
    @Column(name = "tamano_organizacion")
    private String tamanoOrganizacion;
    
    @Column(name = "complejidad_organizacion")
    private String complejidadOrganizacion;
    
    @Column(name ="capacidades_organizacion")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode capacidadesOrganizacion;
    
    @Column(name = "certificados", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode certificados;
    
    @Column(name ="tiene_sms")
    private Boolean tieneSms;
    @Column(name ="fecha_acpetacion")
    private LocalDate fechaAceptacion;
    
    @Column(name = "objetivos_indicadores", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode objetivosIndicadores; 
    
    @Column(name = "certificados_especificos_aprobados", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode certificadosEspecificosAprobados;
   
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "aerovanves_registradas", columnDefinition = "jsonb")
      private JsonNode  aerovanvesRegistradas;
//    private String aerovanvesRegistradas;
    @Column(name ="naciona_extranjera")
    private String nacionalidadOrganizacion;
    
    @Column(name = "tipo_operacion")
    private String tipoOperacion;
    @Column(name = "otro_tipo_operacion")
    private String otroTipoOperacion;
	@JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "personal_directorio", columnDefinition = "jsonb")
      private JsonNode  personalDirectorio;

    /*@Column(name ="tipo_organizacion_id")
    private Integer tipoOrganizacionId;
    @Column(name ="otras_certificaciones_id")
    private Integer otrasCertificacionesId;*/
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "personal_certificado", columnDefinition = "jsonb")
      private JsonNode  personalCertificado;


   // private String personalCertificado;
    
    @Column(name = "certificaciones", columnDefinition = "jsonb")
      private JsonNode  certificaciones;
    
    @Column(name = "tipo_ciac_ceac", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode tipoCiacCeac;
    
    
    
    
    
    

   // private String personalCertificado;
  //  @JdbcTypeCode(SqlTypes.JSON)
  //  @Column(name = "aprobacionesespecificascertificaciones", columnDefinition = "jsonb")
   //   private JsonNode  aprobacionesEspecificasCertificaciones;
    }
