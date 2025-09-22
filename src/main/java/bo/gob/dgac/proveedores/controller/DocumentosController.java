package bo.gob.dgac.proveedores.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.proveedores.model.DocumentosEntity;
import bo.gob.dgac.proveedores.service.DocumentosService;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;




@RestController
@RequestMapping("/api/documentos")
@CrossOrigin(origins = "*")
public class DocumentosController {

	@Autowired
	private DocumentosService documentosService;
	
	
	@PostMapping("/save")
	public ResponseEntity<DocumentosEntity> guardar(@RequestBody DocumentosEntity documentos){
		return ResponseEntity.ok(documentosService.save(documentos));
	}
	
	
    @GetMapping("/list/{idOrganizacion}")
	  public ResponseEntity<List<DocumentosEntity>> listar(@PathVariable("idOrganizacion") Long idOrganizacion) {
	        List<DocumentosEntity> doc = documentosService.findByOrganizacion(idOrganizacion);
	        
	        System.out.println("****************************************************"+idOrganizacion);
	        return ResponseEntity.ok(doc);
	    }	  
	   @GetMapping("/ver/{id}")
	   public ResponseEntity<InputStreamResource> verARchivo(@PathVariable Long id) throws IOException {
		   
		    File archivo = documentosService.getArchivoById(id);
		    
		    InputStreamResource archivoRecurso= new InputStreamResource(new FileInputStream(archivo));
		    
		    return ResponseEntity.ok()
		    		.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+archivo.getName())
		    		.contentType(MediaType.APPLICATION_PDF)
		    		.contentLength(archivo.length())
		    		.body(archivoRecurso);
	   }
}
