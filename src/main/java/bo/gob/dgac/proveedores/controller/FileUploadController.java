package bo.gob.dgac.proveedores.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bo.gob.dgac.proveedores.service.FileStorageService;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "*")
public class FileUploadController {

    private final FileStorageService fileStorageService;

    
    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    /*@PostMapping("/subir")
    public ResponseEntity<Map<String, String>> subir(@RequestParam("file") MultipartFile file) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "El archivo se subió correctamente: " + file.getOriginalFilename());
        return ResponseEntity.ok(respuesta);
    }
    
    */
    @PostMapping("/subir")
    public ResponseEntity<String> subirArchivo(@RequestParam("file") MultipartFile file,
    	@RequestParam Long id){
    	try {
    		System.out.println("id de la orgnaización es :"+id);
    		
    		
    	String filename= fileStorageService.storeFile(file,id);
    	
    	
    	return ResponseEntity.ok("El archivo se subio correctamente :"+filename);
    	}catch(IOException e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir archivo : "+ e.getMessage());
    	}   	
    }
    
    @GetMapping("/listar")
    public ResponseEntity<?> listarArchivos(){
    	try {
    		return ResponseEntity.ok(fileStorageService.listFiles());
    	}catch(IOException e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    				.body("Error al listar archivos: "+e.getMessage());
    	}
    }
    
        	
    @GetMapping("/download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) {
        try {
            byte[] fileContent = fileStorageService.downloadFile(filename);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                    .body(fileContent);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Archivo no encontrado: " + filename);
        }
    }
}
