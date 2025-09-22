package bo.gob.dgac.proveedores.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import bo.gob.dgac.proveedores.model.DocumentosEntity;
import bo.gob.dgac.proveedores.repository.DocumentosRepository;
import bo.gob.dgac.proveedores.repository.FileStorage;
import bo.gob.dgac.proveedores.repository.OrganizacionRepository;

@Service
public class FileStorageService implements FileStorage{
	
	private final Path uploadPath=Paths.get("uploads");
	
	@Autowired
	private DocumentosRepository documentosRepository;
	
	@Autowired 
	private OrganizacionRepository organizacionRepository;
	
    @Override
	public String storeFile(MultipartFile file,Long id) throws IOException {
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }

	        Path filePath = uploadPath.resolve(file.getOriginalFilename());
	        
	        DocumentosEntity documentos=new DocumentosEntity();
	        documentos.setOrganizacion(organizacionRepository.getById(id));
	        String[] ruta= filePath.toString().split("/");
	        documentos.setNombreArchivo(ruta[1]);
	        documentosRepository.save(documentos);
	        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	        return file.getOriginalFilename();
	    }

	
	@Override
	public List<String> listFiles() throws IOException{
		
		if(!Files.exists(uploadPath)) {
			return List.of();
		}
		return Files.list(uploadPath).map(path->path.getFileName().toString())
				.collect(Collectors.toList());
	}
	
	@Override
	public byte[] downloadFile(String filename) throws IOException{
		Path filePath= uploadPath.resolve(filename);
		if(!Files.exists(filePath)) {
			throw new IOException("Archivo no encontrado : "+filename);
		}
		return Files.readAllBytes(filePath);
		
	}
	
	
	
	
	
	
	
	
	
	

}
