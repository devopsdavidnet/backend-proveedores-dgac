package bo.gob.dgac.proveedores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.proveedores.model.DocumentosEntity;
import bo.gob.dgac.proveedores.model.OrganizacionEntity;

@Repository
public interface DocumentosRepository extends JpaRepository<DocumentosEntity, Long> {
   
    List<DocumentosEntity> findByOrganizacion_IdOrderByIdDesc(Long idOrganizacion);

}

