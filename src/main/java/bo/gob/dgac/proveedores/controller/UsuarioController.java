package bo.gob.dgac.proveedores.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.proveedores.dto.UsuarioLoginDTO;
import bo.gob.dgac.proveedores.model.UsuarioEntity;
import bo.gob.dgac.proveedores.service.UsuarioService;
import bo.gob.dgac.proveedores.utils.ErrorResponse;

@RestController
@RequestMapping(value ="/api/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins ="*")
public class UsuarioController {
	
   @Autowired
	private UsuarioService service;

    public ResponseEntity<List<UsuarioEntity>> getAll(){
    	return ResponseEntity.ok(service.findAll());
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String correo,
                                 @RequestParam String contrasenia) {
        UsuarioLoginDTO usuario = service.login(correo, contrasenia);
        if (usuario != null) {

            return new ResponseEntity<UsuarioLoginDTO>(usuario, HttpStatus.OK);
        } else {

            ErrorResponse error = new ErrorResponse("No se encontraron datos para el usuario especificado.");
            return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping()
public ResponseEntity<List<UsuarioEntity>> findAll() {
    List<UsuarioEntity> usuarios = service.findAll();
    return ResponseEntity.ok(usuarios);
}
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioEntity> getByCorreo(@PathVariable String correo) {
        return service.findByCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<UsuarioEntity> create(@RequestBody UsuarioEntity usuario){
    	return ResponseEntity.ok(service.save(usuario));
    }
    /*
    @PutMapping("/put/{id}")
	public ResponseEntity<UsuarioEntity> update (@PathVariable Long id,@RequestBody UsuarioEntity usuario){
    	return ResponseEntity.ok(service.update(id, usuario));
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
