package bo.gob.dgac.proveedores.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import bo.gob.dgac.proveedores.dto.OrganizacionDTO;
import bo.gob.dgac.proveedores.model.OrganizacionEntity;

@Mapper
public interface OrganizacionMapper {
	
   OrganizacionMapper mapper= Mappers.getMapper(OrganizacionMapper.class);
     // de dto a entity
	 @Mapping(source = "departamento", target = "departamentoId")
     @Mapping(source = "direccion", target = "direccion")
     @Mapping(source = "telefonoOrganizacion", target = "telefono")
	 @Mapping(source = "correoOrganizacion", target = "correo")
     @Mapping(source = "resolucionTipoOrganizacion", target = "resolucionClaseCertificacion")
	 @Mapping(source = "otraResolucionTipoOrganizacion", target = "otraResolucionClaseCertificacion")
    // @Mapping(source = "especificaciones", target = "certificadosEspecificosAprobados")
	 @Mapping(source = "fechaAceptacionSms", target = "fechaAceptacion")
     @Mapping(source = "numeroResolucionAdministrativa", target = "numeroResolucion")
     @Mapping(source = "aeronaveInfo", target = "aerovanvesRegistradas")
	 @Mapping(source = "objetivosMetasIndicadoresInfo", target = "objetivosIndicadores")
	 @Mapping(source = "instructoresCertificadosInfo", target = "personalCertificado")
      OrganizacionEntity toEntity(OrganizacionDTO dto);

	//OrganizacionMapper INSTANCE = Mappers.getMapper(OrganizacionMapper.class);
	
	
    // De DTO -> Entidad
	/* @Mapping(source = "id", ignore = true) // Ignorar el ID porque es autogenerado
	 @Mapping(source = "nombreOrganizacion", target = "nombreOrganizacion")
	 @Mapping(source = "tipoExplotador", target = "tipoExplotador")
     @Mapping(source = "departamentoId", target = "departamento") // <-- Mapeo corregido
	 @Mapping(source = "direccion", target = "direccionOrganizacion")
	 @Mapping(source = "telefono", target = "telefonoOrganizacion")
	 @Mapping(source = "correo", target = "correoOrganizacion")
	 OrganizacionEntity toEntity(OrganizacionDTO dto);
    //De Entidad -> DTO
	  De Entidad -> DTO (si quieres mapear de vuelta)
    @Mapping(source = "departamento", target = "departamentoId")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "fechaInicialCertificacion", target = "fechaInicialCertificacion")
    @Mapping(source = "fechaExpiracionCertificacion", target = "fechaExpiracionCertificacion")
    @Mapping(source = "numeroCertificado", target = "numeroCertificado")
    @Mapping(source = "numeroResolucion", target = "numeroResolucion")
    @Mapping(source = "tieneSms", target = "tieneSms")
    @Mapping(source = "fechaAcpetacion", target = "fechaAcpetacion")
    @Mapping(source = "objetivosIndicadores", target = "objetivosIndicadores")
    @Mapping(source = "aprobacionesEspecificadas", target = "aprobacionesEspecificadas")
    @Mapping(source = "aerovanvesRegistradas", target = "aerovanvesRegistradas")
    @Mapping(source = "nacionaExtranjera", target = "nacionaExtranjera")
    @Mapping(source = "tamanoOrganzacion", target = "tamanoOrganzacion")
    @Mapping(source = "tipoOrganizacionId", target = "tipoOrganizacionId")
    @Mapping(source = "otrasCertificacionesId", target = "otrasCertificacionesId")
    @Mapping(source = "personalCertificado", target = "personalCertificado")
    OrganizacionDTO toDto(OrganizacionEntity entity);*/
    //OrganizacionDTO toDto(Organizacion entity);
	
}
    
    
    