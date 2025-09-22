package bo.gob.dgac.proveedores.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.dgac.proveedores.externo.CorreoWebClientService;
import bo.gob.dgac.proveedores.model.ProveedorEntity;
import bo.gob.dgac.proveedores.repository.ProveedoresRepository;


@Service
public class ProveedoresService {

   @Autowired
	 private ProveedoresRepository repository;

   @Autowired
   CorreoWebClientService correoWebClientService;
   
    public List<ProveedorEntity> findAll() {
        return repository.findAll();
    }

    public Optional<ProveedorEntity> findById(Long id) {
        return repository.findById(id);
    }

    public ProveedorEntity save(ProveedorEntity proveedor) {
        return repository.save(proveedor);
    }

    public ProveedorEntity update(Long id, ProveedorEntity proveedor) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNombreProveedor(proveedor.getNombreProveedor());
                    existing.setDescripcion(proveedor.getDescripcion());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con id " + id));
     }

    	public void delete(Long id) {
        repository.deleteById(id);
    	}
}


