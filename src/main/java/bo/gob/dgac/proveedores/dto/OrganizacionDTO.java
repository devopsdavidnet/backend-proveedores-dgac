package bo.gob.dgac.proveedores.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import java.time.LocalDate;

@Data
public class OrganizacionDTO {
	private Long id;
    private String nombreOrganizacion;
    private String tipoExplotador;
    private Integer departamento;
    private String direccion;
    private String telefonoOrganizacion;
    private String correoOrganizacion;
    private LocalDate fechaInicialCertificacion;
    private LocalDate fechaExpiracionCertificacion;
    private String numeroCertificado;
    private String numeroResolucionAdministrativa;
    private Integer resolucionTipoOrganizacion;
    private String otraResolucionTipoOrganizacion;
    private String tipoOperacion;
    private String otroTipoOperacion;
    //private JsonNode especificaciones;   // JSONB
    private JsonNode certificadosEspecificosAprobados; 
    private JsonNode aeronaveInfo;   // JSONB
    private JsonNode objetivosMetasIndicadoresInfo; // JSONB
    private Boolean tieneSms;
    private LocalDate fechaAceptacionSms;
   /* private Boolean especificacionEdto;
    private Boolean especificacionPbn;
    private Boolean especificacionCat;
    private Boolean especificacionEfb;
    private Boolean especificacionRvsm;
    private Boolean especificacionMp;
    private Boolean especificacionLl;
    private Boolean especificacionesHets;
    private Boolean especificacionMedevac;
    private Boolean especificacionNoposee;
    private Boolean especificacionOtro;
    private String otraEspecificacion;*/
    private JsonNode aprobacionesEspecificasCertificaciones; // JSONB
    
    private String nacionalidadOrganizacion;
    private String tamanoOrganizacion;
    private String complejidadOrganizacion;
    private Boolean capacidadOrganizacionEstructuraAeronave;
    private Boolean capacidadOrganizacionMotorAeronave;
    private Boolean capacidadOrganizacionHelices;
    private Boolean capacidadOrganiazacionRadio;
    private Boolean capacidadOrganizacionSistema;
    private Boolean capacidadOrganizacionAccesorios;
    private Boolean capacidadOrganizacionServicio;
    private Boolean otroCapacidadOrganizacion;
    private String otroCapacidadOrganizaciones;
    private Boolean tipo1;
    private Boolean tipo2;
    private Boolean tipo3;
    private Boolean tipo4;
    private Boolean tipo5;
    /*private Boolean certificadoTrainair;
    private LocalDate fechaExpiracionCertificadoTrainair; 
    private Boolean certificadoIosa;
    private LocalDate fechaExpiracionCertificadoIosa;
    private Boolean certificadoIsago;
    private LocalDate fechaExpiracionIsago;
    private Boolean certificadoIss;
    private LocalDate fechaExpiracionIss;
    private Boolean certificadoClac;
    private LocalDate fechaExpiracionClac;
    private Boolean certificadoRolls;
    private LocalDate fechaExpiracionRoll; 
    private Boolean certificadoAirbus; 
    private LocalDate fechaExpiracionAirbus;
    private Boolean certificadoRedalc; 
   private LocalDate fechaExpiracioncertificadoRedalc; 
   private Boolean certificadoGadm;
   private LocalDate fechaExpiracionGadm;
   private Boolean certificadoBoeign;
   private LocalDate fechaExpiracionBoeign;
   private Boolean certificadoRasg;
   private LocalDate fechaExpiracionRasg;
   private Boolean certificadoCoscap;
   private LocalDate fechaExpiracionCoscap;
   private Boolean certificadoCalidad;
   private LocalDate fechaExpiracionCalidad;
   private Boolean certificadoTrabajo;
   private LocalDate fechaExpiracionTrabajo; 
   private Boolean certificadoMultinacional;
   private LocalDate fechaExpiracionMultinacional;
   private Boolean certificadoGcso;
   private LocalDate fechaExpiracionGcso;*/
    private JsonNode certificaciones; // JSONB
    private JsonNode capacidadesOrganizacion; // json
    private JsonNode certificados; // JSONB
    private JsonNode tipoCiacCeac; // json9
   private String nombreGerenteResponsable;
   private String telefonoGerenteResponsable;
   private String correoGerenteResponsable;
   private LocalDate fechaDesignacionGerenteResponsable;
   private String nombreResponsableOperaciones;
   private String telefonoResponsableOperaciones;
   private String correoResponsableOperaciones;
   private LocalDate fechaDesignacionResponsableOperaciones;
   private String nombreResponsableMantenimiento;
   private String telefonoResponsableMantenimineto;
   private String correoResponsableMantenimiento;
   private LocalDate fechaDesignacionResponsableMantenimiento;
   private String nombreResponsableSms;
   private String telefonoResponsableSms;
   private String correoResponsableSms;
   private LocalDate fechaDesignacionResponsableSms;
   private String nombreResponsableCalidad;
   private String telefonoResponsableCalidad;
   private String correoResponsableCalidad;
   private LocalDate fechaDesignacionResponsableCalidad;
   private String nombreJefePiloto;
   private String telefonoJefePiloto;
   private String correoJefePiloto;
   private LocalDate fechaDesignacionJefePiloto;
   private String nombreJefeInstruccion;
   private String telefonoJefeInstruccion;
   private String correoJefeInstruccion;
   private LocalDate fechaDesignacionJefeInstruccion;
   private String nombreGerenteResponsableCIAC;
   private String telefonoGerenteResponsableCIAC;
   private String correoGerenteResponsableCIAC;
   private LocalDate fechaDesignacionGerenteResponsableCIAC;
   private String nombreJefeVueloCIAC;
   private String telefonoJefeVueloCIAC;
   private String correoJefeVueloCIAC;
   private LocalDate fechaDesignacionJefeVueloCIAC;
   private String nombreJefeInstruccionTeoricaCIAC;
   private String telefonoJefeInstruccionTeoricaCIAC;
   private String correoJefeInstruccionTeoricaCIAC;
   private LocalDate fechaDesignacionJefeInstrucionTeoricaCIAC;
   private String nombreAistenteInstructorCiac;
   private String telefonoAsistenteInstructorCiac;
   private String correoAsistenteInstructorCiac;
   private LocalDate fechaDesignacionAsistenteInstructorCiac;
   private JsonNode instructoresCertificadosInfo; // JSONB
   private JsonNode personalDirectorio; // JSONB
   
   

}
