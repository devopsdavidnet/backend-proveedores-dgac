package bo.gob.dgac.proveedores.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.proveedores.model.OrganizacionEntity;
@Repository
public interface OrganizacionRepository extends JpaRepository<OrganizacionEntity,Long>{


    /*@Query(value = "SELECT o.* " +
            "FROM proveedores.organizaciones o ",
    nativeQuery = true)*/
    List<OrganizacionEntity> findAll();
}
