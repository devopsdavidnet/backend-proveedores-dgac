package bo.gob.dgac.proveedores.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonNode;

public record UsuarioLoginDTO(
	    String nombre,
	    String primerApellido,
	    String segundoApellido,
	    String celular,
	    Integer rolUsuario,
	    Integer idOrganizacion,
	    String nombreOrganizacion,
	    String tipoExplotador,
	    Integer departamentoId,
	    String direccion,
	    String telefono,
	    String correo,
	    LocalDate fechaInicialCertificacion,
	    LocalDate fechaExpiracionCertificacion,
	    String numeroCertificado,
	    String numeroResolucion,
	    Integer resolucionClaseCertificacion,
	    String otraResolucionClaseCertificacion,
	    Boolean tieneSms,
	    LocalDate fechaAceptacion,
	    JsonNode objetivosIndicadores,
	    String nacionalidadOrganizacion,
	    JsonNode certificadosEspecificosAprobados,
	    JsonNode aerovanvesRegistradas,
	    String tamanoOrganizacion,
	    String complejidadOrganizacion,
	    String tipoOperacion,
	    String otroTipoOperacion,
	    JsonNode capacidadesOrganizacion,
	    JsonNode certificados,
	    JsonNode  personalDirectorio,
	    JsonNode  personalCertificado,
	    JsonNode  certificaciones,
	    JsonNode tipoCiacCeac
	   
	    

) {}


