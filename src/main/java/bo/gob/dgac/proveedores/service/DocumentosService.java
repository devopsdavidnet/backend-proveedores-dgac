package bo.gob.dgac.proveedores.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.dgac.proveedores.model.DocumentosEntity;
import bo.gob.dgac.proveedores.repository.DocumentosRepository;

@Service
public class DocumentosService {

	@Autowired
	private DocumentosRepository documentosRepository;
	
	public List<DocumentosEntity> findAll(){
		return documentosRepository.findAll();
	}
	
	public DocumentosEntity save(DocumentosEntity documentos) {
		return documentosRepository.save(documentos);
	}
	
	public Optional<DocumentosEntity> findById(Long id){
		return documentosRepository.findById(id);
	}
	
	/*public List<DocumentosEntity> findByOrganizacion(Long id){
		
		return documentosRepository.findByOrganizacion(id);
		
	}*/
	/*
	public List<DocumentosEntity> findByOrganizacion(Long id){
		System.out.println("LEGO :"+id);
	Optional<DocumentosEntity> doc = findById(id);
	return documentosRepository.findByOrganizacion(doc);
	
	}*/
	
	public List<DocumentosEntity> findByOrganizacion(Long idOrganizacion) {
        return documentosRepository.findByOrganizacion_IdOrderByIdDesc(idOrganizacion);
    }
	public void delete(Long id) {
		documentosRepository.deleteById(id);	
	}
	
	
	
	
	public File getArchivoById(Long id) {
		
		Optional<DocumentosEntity> optionalDoc = documentosRepository.findById(id);
	    DocumentosEntity doc = optionalDoc.get();
		java.io.File file= new File("uploads/" + doc.getNombreArchivo());
		if(!file.exists()) {
			throw new RuntimeException("El archivo no existe en el servidor: " + file.getAbsolutePath());		
		}
		return file;
	}

/*
	public File getArchivoById(Long id) {
	    DocumentosEntity doc = documentosRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Documento no encontrado con id: " + id));

	    File file = new File(rutaBase + doc.getNombreArchivo());

	    if (!file.exists()) {
	        throw new RuntimeException("El archivo no existe en el servidor: " + file.getAbsolutePath());
	    }

	    return file;
	}
	
	*/
}
