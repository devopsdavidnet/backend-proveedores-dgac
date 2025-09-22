package bo.gob.dgac.proveedores.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import bo.gob.dgac.proveedores.dto.PersonalOrganizacionDTO;
import bo.gob.dgac.proveedores.model.PersonalOrganizacionEntity;

@Mapper
public interface PersonalOrganizacionMapper {

  PersonalOrganizacionMapper mapper= Mappers.getMapper(PersonalOrganizacionMapper.class);
  PersonalOrganizacionEntity toEntity(PersonalOrganizacionDTO dto);
    //     PersonalOrganizacionDTO toDto(PersonalOrganizacionEntity entity);

}
