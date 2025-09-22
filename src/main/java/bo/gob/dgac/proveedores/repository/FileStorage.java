package bo.gob.dgac.proveedores.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {
	
	String storeFile(MultipartFile file,Long id) throws IOException;
	List<String> listFiles() throws IOException;
	byte[] downloadFile(String filename) throws IOException;
	 

}
