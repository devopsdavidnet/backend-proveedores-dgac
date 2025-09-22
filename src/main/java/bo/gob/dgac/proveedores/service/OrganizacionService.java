package bo.gob.dgac.proveedores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.dgac.proveedores.dto.OrganizacionDTO;
import bo.gob.dgac.proveedores.dto.PersonalOrganizacionDTO;
import bo.gob.dgac.proveedores.mapper.OrganizacionMapper;
import bo.gob.dgac.proveedores.mapper.PersonalOrganizacionMapper;
import bo.gob.dgac.proveedores.model.OrganizacionEntity;
import bo.gob.dgac.proveedores.model.PersonalOrganizacionEntity;
import bo.gob.dgac.proveedores.repository.OrganizacionRepository;
import bo.gob.dgac.proveedores.repository.PersonalOrganizacionRepository;



@Service
public class OrganizacionService {

	 private final OrganizacionRepository organizacionRepository;
 
	public OrganizacionService(OrganizacionRepository organizacionRepository) {
		this.organizacionRepository = organizacionRepository;
	  }

	  public OrganizacionEntity save(OrganizacionEntity organizacionEntity) {
		  return organizacionRepository.save(organizacionEntity);
	  }
	  
     @Autowired
    private PersonalOrganizacionRepository personalOrganizacionRepository; // o un servicio
	 
	public OrganizacionDTO saveOrganizacion1(OrganizacionDTO organizacionDto){
            
		  OrganizacionEntity organizacionEntity=OrganizacionEntity.builder()
		              .nombreOrganizacion(organizacionDto.getNombreOrganizacion())
		              .tipoExplotador(organizacionDto.getTipoExplotador())
					  .aerovanvesRegistradas(organizacionDto.getAeronaveInfo())
					  .objetivosIndicadores(organizacionDto.getObjetivosMetasIndicadoresInfo())
                      .build();
		         organizacionRepository.save(organizacionEntity);
				
		
		          return  organizacionDto;

	  }


	//public OrganizacionDTO saveOrganizacion(OrganizacionDTO organizacionDto){
	public OrganizacionEntity saveOrganizacion(OrganizacionDTO organizacionDto){            
		OrganizacionEntity organizacionEntity =OrganizacionMapper.mapper.toEntity(organizacionDto);
		Long c= organizacionRepository.save(organizacionEntity).getId();
		 //System.out.println("DAVID ================:"+organizacionDto.getEspecificaciones());
		 
        if(organizacionDto.getTipoExplotador().equals("AOC")){
		 PersonalOrganizacionDTO personalGerente = new PersonalOrganizacionDTO() ;
		   personalGerente.setNombre(organizacionDto.getNombreGerenteResponsable());
		   personalGerente.setTelefono(organizacionDto.getTelefonoGerenteResponsable());
		   personalGerente.setCorreo(organizacionDto.getCorreoGerenteResponsable());
		   personalGerente.setFechaDesignacion(organizacionDto.getFechaDesignacionGerenteResponsable());
		   personalGerente.setOrganizacionId(c);
		   personalGerente.setCargoId(1L);
         PersonalOrganizacionEntity personalOrganizacionEntity = PersonalOrganizacionMapper.mapper.toEntity(personalGerente);
         personalOrganizacionRepository.save(personalOrganizacionEntity);
          
         PersonalOrganizacionDTO responsableSms = new PersonalOrganizacionDTO() ;
		   responsableSms.setNombre(organizacionDto.getNombreResponsableSms());
		   responsableSms.setTelefono(organizacionDto.getTelefonoResponsableSms());
		   responsableSms.setCorreo(organizacionDto.getCorreoResponsableSms());
		   responsableSms.setFechaDesignacion(organizacionDto.getFechaDesignacionResponsableSms());
		   responsableSms.setOrganizacionId(c);
		   responsableSms.setCargoId(2L);
         PersonalOrganizacionEntity responsableSmsEntity = PersonalOrganizacionMapper.mapper.toEntity(responsableSms);
         personalOrganizacionRepository.save(responsableSmsEntity);
        
		  PersonalOrganizacionDTO responsableOperaciones = new PersonalOrganizacionDTO() ;
		   responsableOperaciones.setNombre(organizacionDto.getNombreResponsableOperaciones());
		   responsableOperaciones.setTelefono(organizacionDto.getTelefonoResponsableOperaciones());
		   responsableOperaciones.setCorreo(organizacionDto.getCorreoResponsableOperaciones());
		   responsableOperaciones.setFechaDesignacion(organizacionDto.getFechaDesignacionResponsableOperaciones());
		   responsableOperaciones.setOrganizacionId(c);
		   responsableOperaciones.setCargoId(3L);
           PersonalOrganizacionEntity personalResponsable = PersonalOrganizacionMapper.mapper.toEntity(responsableOperaciones);
          personalOrganizacionRepository.save(personalResponsable);
        
         PersonalOrganizacionDTO responsableMantenimiento = new PersonalOrganizacionDTO() ;
		   responsableMantenimiento.setNombre(organizacionDto.getNombreResponsableMantenimiento());
		   responsableMantenimiento.setTelefono(organizacionDto.getTelefonoResponsableMantenimineto());
		   responsableMantenimiento.setCorreo(organizacionDto.getCorreoResponsableMantenimiento());
		   responsableMantenimiento.setFechaDesignacion(organizacionDto.getFechaDesignacionResponsableMantenimiento());
		   responsableMantenimiento.setOrganizacionId(c);
		   responsableMantenimiento.setCargoId(4L);
           PersonalOrganizacionEntity personalMantenimientoEntity = PersonalOrganizacionMapper.mapper.toEntity(responsableMantenimiento);
          personalOrganizacionRepository.save(personalMantenimientoEntity);
        
         
        
        PersonalOrganizacionDTO responsableCalidad = new PersonalOrganizacionDTO() ;
		   responsableCalidad.setNombre(organizacionDto.getNombreResponsableCalidad());
		   responsableCalidad.setTelefono(organizacionDto.getTelefonoResponsableCalidad());
		   responsableCalidad.setCorreo(organizacionDto.getCorreoResponsableCalidad());
		   responsableCalidad.setFechaDesignacion(organizacionDto.getFechaDesignacionResponsableCalidad());
		   responsableCalidad.setOrganizacionId(c);
		   responsableCalidad.setCargoId(5L);
           PersonalOrganizacionEntity responsableCalidadEntity = PersonalOrganizacionMapper.mapper.toEntity(responsableCalidad);
          personalOrganizacionRepository.save(responsableCalidadEntity);
          PersonalOrganizacionDTO jefePiloto = new PersonalOrganizacionDTO() ;
		   jefePiloto.setNombre(organizacionDto.getNombreJefePiloto());
		   jefePiloto.setTelefono(organizacionDto.getTelefonoJefePiloto());
		   jefePiloto.setCorreo(organizacionDto.getCorreoJefePiloto());
		   jefePiloto.setFechaDesignacion(organizacionDto.getFechaDesignacionJefePiloto());
		   jefePiloto.setOrganizacionId(c);
		   jefePiloto.setCargoId(6L);
           PersonalOrganizacionEntity jefePilotoEntity = PersonalOrganizacionMapper.mapper.toEntity(jefePiloto);
           personalOrganizacionRepository.save(jefePilotoEntity);
        }
        if(organizacionDto.getTipoExplotador().equals("OMA")){
            
        	PersonalOrganizacionDTO personalGerente = new PersonalOrganizacionDTO() ;
 		   personalGerente.setNombre(organizacionDto.getNombreGerenteResponsable());
 		   personalGerente.setTelefono(organizacionDto.getTelefonoGerenteResponsable());
 		   personalGerente.setCorreo(organizacionDto.getCorreoGerenteResponsable());
 		   personalGerente.setFechaDesignacion(organizacionDto.getFechaDesignacionGerenteResponsable());
 		   personalGerente.setOrganizacionId(c);
 		   personalGerente.setCargoId(1L);
          PersonalOrganizacionEntity personalOrganizacionEntity = PersonalOrganizacionMapper.mapper.toEntity(personalGerente);
          personalOrganizacionRepository.save(personalOrganizacionEntity);
           
          PersonalOrganizacionDTO responsableSms = new PersonalOrganizacionDTO() ;
 		   responsableSms.setNombre(organizacionDto.getNombreResponsableSms());
 		   responsableSms.setTelefono(organizacionDto.getTelefonoResponsableSms());
 		   responsableSms.setCorreo(organizacionDto.getCorreoResponsableSms());
 		   responsableSms.setFechaDesignacion(organizacionDto.getFechaDesignacionResponsableSms());
 		   responsableSms.setOrganizacionId(c);
 		   responsableSms.setCargoId(2L);
          PersonalOrganizacionEntity responsableSmsEntity = PersonalOrganizacionMapper.mapper.toEntity(responsableSms);
          personalOrganizacionRepository.save(responsableSmsEntity);
          
          PersonalOrganizacionDTO responsableMantenimiento = new PersonalOrganizacionDTO() ;
		   responsableMantenimiento.setNombre(organizacionDto.getNombreResponsableMantenimiento());
		   responsableMantenimiento.setTelefono(organizacionDto.getTelefonoResponsableMantenimineto());
		   responsableMantenimiento.setCorreo(organizacionDto.getCorreoResponsableMantenimiento());
		   responsableMantenimiento.setFechaDesignacion(organizacionDto.getFechaDesignacionResponsableMantenimiento());
		   responsableMantenimiento.setOrganizacionId(c);
		   responsableMantenimiento.setCargoId(4L);
         PersonalOrganizacionEntity personalMantenimientoEntity = PersonalOrganizacionMapper.mapper.toEntity(responsableMantenimiento);
         personalOrganizacionRepository.save(personalMantenimientoEntity);
         
         PersonalOrganizacionDTO responsableCalidad = new PersonalOrganizacionDTO() ;
		   responsableCalidad.setNombre(organizacionDto.getNombreResponsableCalidad());
		   responsableCalidad.setTelefono(organizacionDto.getTelefonoResponsableCalidad());
		   responsableCalidad.setCorreo(organizacionDto.getCorreoResponsableCalidad());
		   responsableCalidad.setFechaDesignacion(organizacionDto.getFechaDesignacionResponsableCalidad());
		   responsableCalidad.setOrganizacionId(c);
		   responsableCalidad.setCargoId(5L);
         PersonalOrganizacionEntity responsableCalidadEntity = PersonalOrganizacionMapper.mapper.toEntity(responsableCalidad);
         personalOrganizacionRepository.save(responsableCalidadEntity);

        } 	 
        if(organizacionDto.getTipoExplotador().equals("CIAC")){
        	PersonalOrganizacionDTO personalGerente = new PersonalOrganizacionDTO() ;
  		   personalGerente.setNombre(organizacionDto.getNombreGerenteResponsable());
  		   personalGerente.setTelefono(organizacionDto.getTelefonoGerenteResponsable());
  		   personalGerente.setCorreo(organizacionDto.getCorreoGerenteResponsable());
  		   personalGerente.setFechaDesignacion(organizacionDto.getFechaDesignacionGerenteResponsable());
  		   personalGerente.setOrganizacionId(c);
  		   personalGerente.setCargoId(1L);
             PersonalOrganizacionEntity personalOrganizacionEntity = PersonalOrganizacionMapper.mapper.toEntity(personalGerente);
            personalOrganizacionRepository.save(personalOrganizacionEntity);
            
 	       PersonalOrganizacionDTO jefeVuelo = new PersonalOrganizacionDTO() ;
		   jefeVuelo.setNombre(organizacionDto.getNombreJefeVueloCIAC());
		   jefeVuelo.setTelefono(organizacionDto.getTelefonoJefeVueloCIAC());
		   jefeVuelo.setCorreo(organizacionDto.getCorreoJefeVueloCIAC());
		   jefeVuelo.setFechaDesignacion(organizacionDto.getFechaDesignacionJefeVueloCIAC());
		   jefeVuelo.setOrganizacionId(c);
		   jefeVuelo.setCargoId(8L);
           PersonalOrganizacionEntity jefeVueloEntity = PersonalOrganizacionMapper.mapper.toEntity(jefeVuelo);
          personalOrganizacionRepository.save(jefeVueloEntity);
            
          PersonalOrganizacionDTO jefeInstruccion = new PersonalOrganizacionDTO() ;
		   jefeInstruccion.setNombre(organizacionDto.getNombreJefeInstruccionTeoricaCIAC());
		   jefeInstruccion.setTelefono(organizacionDto.getTelefonoJefeInstruccionTeoricaCIAC());
		   jefeInstruccion.setCorreo(organizacionDto.getCorreoJefeInstruccionTeoricaCIAC());
		   jefeInstruccion.setFechaDesignacion(organizacionDto.getFechaDesignacionJefeInstrucionTeoricaCIAC());
		   jefeInstruccion.setOrganizacionId(c);
		   jefeInstruccion.setCargoId(9L);
          PersonalOrganizacionEntity jefeInstruccionEntity = PersonalOrganizacionMapper.mapper.toEntity(jefeInstruccion);
         personalOrganizacionRepository.save(jefeInstruccionEntity);
         
		    PersonalOrganizacionDTO asistenteInstructor = new PersonalOrganizacionDTO() ;
		   asistenteInstructor.setNombre(organizacionDto.getNombreAistenteInstructorCiac());
		   asistenteInstructor.setTelefono(organizacionDto.getTelefonoAsistenteInstructorCiac());
		   asistenteInstructor.setCorreo(organizacionDto.getCorreoAsistenteInstructorCiac());
		   asistenteInstructor.setFechaDesignacion(organizacionDto.getFechaDesignacionAsistenteInstructorCiac());
		   asistenteInstructor.setOrganizacionId(c);
		   asistenteInstructor.setCargoId(10L);
        PersonalOrganizacionEntity asistenteInstructorEntity = PersonalOrganizacionMapper.mapper.toEntity(asistenteInstructor);
       personalOrganizacionRepository.save(asistenteInstructorEntity);

        	
        	
        }
        /*  
          PersonalOrganizacionDTO jefeInstruccion = new PersonalOrganizacionDTO() ;
		   jefeInstruccion.setNombre(organizacionDto.getNombreJefeInstruccion());
		   jefeInstruccion.setTelefono(organizacionDto.getTelefonoJefeInstruccion());
		   jefeInstruccion.setCorreo(organizacionDto.getCorreoJefeInstruccion());
		   jefeInstruccion.setFechaDesignacion(organizacionDto.getFechaDesignacionJefeInstruccion());
		   jefeInstruccion.setOrganizacionId(c);
		   jefeInstruccion.setCargoId(7L);
           PersonalOrganizacionEntity jefeInstruccionEntity = PersonalOrganizacionMapper.mapper.toEntity(jefeInstruccion);
          personalOrganizacionRepository.save(jefeInstruccionEntity);

		    PersonalOrganizacionDTO jefeVuelo = new PersonalOrganizacionDTO() ;
		   jefeVuelo.setNombre(organizacionDto.getNombreJefeVueloCIAC());
		   jefeVuelo.setTelefono(organizacionDto.getTelefonoJefeVueloCIAC());
		   jefeVuelo.setCorreo(organizacionDto.getCorreoJefeVueloCIAC());
		   jefeVuelo.setFechaDesignacion(organizacionDto.getFechaDesignacionJefeVueloCIAC());
		   jefeVuelo.setOrganizacionId(c);
		   jefeVuelo.setCargoId(8L);
           PersonalOrganizacionEntity jefeVueloEntity = PersonalOrganizacionMapper.mapper.toEntity(jefeVuelo);
          personalOrganizacionRepository.save(jefeVueloEntity);

		    PersonalOrganizacionDTO jefeInstruccionTeorica = new PersonalOrganizacionDTO() ;
		   jefeInstruccionTeorica.setNombre(organizacionDto.getNombreJefeInstruccionTeoricaCIAC());
		   jefeInstruccionTeorica.setTelefono(organizacionDto.getTelefonoJefeInstruccionTeoricaCIAC());
		   jefeInstruccionTeorica.setCorreo(organizacionDto.getCorreoJefeInstruccionTeoricaCIAC());
		   jefeInstruccionTeorica.setFechaDesignacion(organizacionDto.getFechaDesignacionJefeInstruccion());
		   jefeInstruccionTeorica.setOrganizacionId(c);
		   jefeInstruccionTeorica.setCargoId(9L);
           PersonalOrganizacionEntity jefeInstruccionTeoricaEntity = PersonalOrganizacionMapper.mapper.toEntity(jefeInstruccionTeorica);
          personalOrganizacionRepository.save(jefeInstruccionTeoricaEntity);

		    PersonalOrganizacionDTO asistenteInstructor = new PersonalOrganizacionDTO() ;
		   asistenteInstructor.setNombre(organizacionDto.getNombreAistenteInstructorCiac());
		   asistenteInstructor.setTelefono(organizacionDto.getTelefonoAsistenteInstructorCiac());
		   asistenteInstructor.setCorreo(organizacionDto.getCorreoAsistenteInstructorCiac());
		   asistenteInstructor.setFechaDesignacion(organizacionDto.getFechaDesignacionAsistenteInstructorCiac());
		   asistenteInstructor.setOrganizacionId(c);
		   asistenteInstructor.setCargoId(10L);
           PersonalOrganizacionEntity asistenteInstructorEntity = PersonalOrganizacionMapper.mapper.toEntity(asistenteInstructor);
          personalOrganizacionRepository.save(asistenteInstructorEntity);

*/


        // } 
 	//	          return  organizacionDto;
 		  return organizacionEntity;

	  }

	
	 public OrganizacionEntity updateOrganizacion(OrganizacionDTO dto) {
	        // verificar que exista
	        OrganizacionEntity organizacionObj = organizacionRepository.findById(dto.getId())
	                .orElseThrow(() -> new RuntimeException("Organización no encontrada"));

	        // actualizar solo los campos que vienen en el DTO
	        //existente.setNombreOrganizacion(dto.getNombreOrganizacion());
	        //existente.setTipoExplotador(dto.getTipoExplotador());
	        organizacionObj.setDireccion(dto.getDireccion());
	        organizacionObj.setDepartamentoId(dto.getDepartamento());
	        organizacionObj.setTelefono(dto.getTelefonoOrganizacion());
	        organizacionObj.setCorreo(dto.getCorreoOrganizacion());
	        organizacionObj.setFechaInicialCertificacion(dto.getFechaInicialCertificacion());
	        organizacionObj.setFechaExpiracionCertificacion(dto.getFechaExpiracionCertificacion());
	        organizacionObj.setNumeroCertificado(dto.getNumeroCertificado());
	        organizacionObj.setNumeroResolucion(dto.getNumeroResolucionAdministrativa());
	        organizacionObj.setResolucionClaseCertificacion(dto.getResolucionTipoOrganizacion());
	        organizacionObj.setOtraResolucionClaseCertificacion(dto.getOtraResolucionTipoOrganizacion());
	        organizacionObj.setTieneSms(dto.getTieneSms());
	        organizacionObj.setAerovanvesRegistradas(dto.getAeronaveInfo());
	        organizacionObj.setFechaAceptacion(dto.getFechaAceptacionSms());
	        organizacionObj.setObjetivosIndicadores(dto.getObjetivosMetasIndicadoresInfo());
	        organizacionObj.setNacionalidadOrganizacion(dto.getNacionalidadOrganizacion());
	        organizacionObj.setTamanoOrganizacion(dto.getTamanoOrganizacion());
	        organizacionObj.setComplejidadOrganizacion(dto.getComplejidadOrganizacion());
	        organizacionObj.setCapacidadesOrganizacion(dto.getCapacidadesOrganizacion());
	        organizacionObj.setCertificados(dto.getCertificados());
	        organizacionObj.setPersonalDirectorio(dto.getPersonalDirectorio());
	        organizacionObj.setCertificadosEspecificosAprobados(dto.getCertificadosEspecificosAprobados());
	        organizacionObj.setTipoOperacion(dto.getTipoOperacion());
	        organizacionObj.setOtroTipoOperacion(dto.getOtroTipoOperacion());
	        organizacionObj.setTipoCiacCeac(dto.getTipoCiacCeac());       
	        organizacionObj.setPersonalCertificado(dto.getInstructoresCertificadosInfo());
	     //   existente.setTelefono(dto.getTelefono());
	    //    existente.setCorreo(dto.getCorreo());
	        // … resto de campos

	        return organizacionRepository.save(organizacionObj);
	    }



}
