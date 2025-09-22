package bo.gob.dgac.proveedores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.proveedores.model.ProveedorEntity;
import bo.gob.dgac.proveedores.service.ProveedoresService;

@RestController
@RequestMapping(
	    value = "/api/proveedores",
	    produces = MediaType.APPLICATION_JSON_VALUE  
	)
@CrossOrigin(origins ="*")
public class ProveedorController {

	
	@Autowired
    private ProveedoresService service;


    @GetMapping("/listar")
    public ResponseEntity<List<ProveedorEntity>> getAll() {
        return ResponseEntity.ok(service.findAll());
      }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorEntity> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<ProveedorEntity> create(@RequestBody ProveedorEntity proveedor) {
    	
        return ResponseEntity.ok(service.save(proveedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorEntity> update(@PathVariable Long id, @RequestBody ProveedorEntity proveedor) {
        return ResponseEntity.ok(service.update(id, proveedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}




