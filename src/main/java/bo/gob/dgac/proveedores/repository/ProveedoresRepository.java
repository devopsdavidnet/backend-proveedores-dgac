package bo.gob.dgac.proveedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.proveedores.model.ProveedorEntity;

@Repository
public interface ProveedoresRepository extends JpaRepository<ProveedorEntity, Long> {
}



