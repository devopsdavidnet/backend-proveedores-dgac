package bo.gob.dgac.proveedores.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.proveedores.model.OrganizacionEntity;
@Repository
public interface OrganizacionRepository extends JpaRepository<OrganizacionEntity,Long>{

}
