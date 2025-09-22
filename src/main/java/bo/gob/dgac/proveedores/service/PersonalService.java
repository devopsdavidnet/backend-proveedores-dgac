package bo.gob.dgac.proveedores.service;

// Ejemplo de un servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.dgac.proveedores.model.PersonalOrganizacionEntity;
import bo.gob.dgac.proveedores.repository.PersonalOrganizacionRepository;

@Service
public class PersonalService {

    @Autowired
    private PersonalOrganizacionRepository repository;

    public PersonalOrganizacionEntity guardarPersonal(PersonalOrganizacionEntity personal) {
        return repository.save(personal);
    }
}