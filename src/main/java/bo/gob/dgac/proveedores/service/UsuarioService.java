package bo.gob.dgac.proveedores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.dgac.proveedores.dto.UsuarioLoginDTO;
import bo.gob.dgac.proveedores.externo.CorreoWebClientService;
import bo.gob.dgac.proveedores.model.UsuarioEntity;
import bo.gob.dgac.proveedores.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UsuarioService {
@Autowired
private UsuarioRepository repository;	

@Autowired
CorreoWebClientService correoWebClientService;

@Autowired
private PasswordService passwordService;



public List<UsuarioEntity> findAll() {
    return repository.findAll();
}

public Optional<UsuarioEntity> findById(Long id) {
    return repository.findById(id);
}

public Optional<UsuarioEntity> findByCorreo(String correo) {
    return repository.findByCorreo(correo);
}

public UsuarioEntity save(UsuarioEntity usuario) {

	
	 
	
	String nuevaPassword = passwordService.generarPassword();
	correoWebClientService.enviarCorreo(usuario.getCorreo(),"Credenciales",""
			+ "<table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"max-width: 600px; margin: 20px auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); overflow: hidden;\">\n"
			+ "    <tr>\n"
			+ "        <td style=\"background-color: #007bff; color: #ffffff; padding: 20px; text-align: center;\">\n"
			+ "            <h1 style=\"margin: 0; font-size: 24px;\">¡Bienvenido!</h1>\n"
			+ "        </td>\n"
			+ "    </tr>\n"
			+ "    <tr>\n"
			+ "        <td style=\"padding: 40px 30px; color: #333333; line-height: 1.6;\">\n"
			+ "            <p style=\"margin: 0 0 15px;\">Hola "+usuario.getNombre()+",</p>\n"
			+ "            <p style=\"margin: 0 0 15px;\">Tu cuenta ha sido creada exitosamente. Para ingresar, por favor, utiliza las siguientes credenciales:</p>\n"
			+ "            \n"
			+ "            <div style=\"background-color: #e9ecef; padding: 20px; border-radius: 5px; text-align: center; margin: 25px 0;\">\n"
			+ "                <p style=\"margin: 0; font-size: 16px;\"><strong>Usuario:</strong> <span style=\"font-size: 18px; font-weight: bold; color: #007bff; word-break: break-all;\">"+usuario.getCorreo()+"</span></p>\n"
			+ "                <p style=\"margin: 15px 0 0; font-size: 16px;\"><strong>Contraseña:</strong> <span style=\"font-size: 18px; font-weight: bold; color: #007bff; word-break: break-all;\">"+nuevaPassword+"</span></p>\n"
			+ "            </div>\n"
			+ " <p style=\"margin: 20px 0 15px; font-weight: bold; color: #dc3545;\">Por tu seguridad, te recomendamos cambiar esta contraseña provisional en tu primer inicio de sesión.</p>\n"			
			+ "            <p style=\"margin: 0 0 15px;\">Si tienes alguna pregunta, no dudes en contactarnos.</p>\n"
			+ "            <p style=\"margin: 0;\">Saludos cordiales,<br>**DGAC-BOLIVIA**</p>\n"
			+ "        </td>\n"
			+ "    </tr>\n"
			+ "    <tr>\n"
			+ "        <td style=\"text-align: center; padding: 20px; font-size: 12px; color: #777777;\">\n"
			+ "            <p style=\"margin: 0;\">Este es un correo automático. Por favor, no lo respondas.</p>\n"
			+ "        </td>\n"
			+ "    </tr>\n"
			+ "</table> ");
			usuario.setContrasenia(nuevaPassword);
	
    return repository.save(usuario);
    
    
    
    
    
    
    
}
/*import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioLoginDTO login(String correo, String contrasenia) {
        // Paso 1: Verificar si el usuario existe usando findByCorreo
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findByCorreo(correo);

        if (usuarioExistente.isPresent()) {
            // Paso 2: Si el usuario existe, se procede a intentar el login
            return usuarioRepository.loginUsuario(correo, contrasenia);
        } else {
            // Si el usuario no existe, se puede lanzar una excepción o devolver null
            // para que el controlador sepa que el login falló.
            throw new UsuarioNoEncontradoException("El correo electrónico no está registrado.");
            // O simplemente: return null;
        }
    }
}*/

public UsuarioLoginDTO login(String correo, String contrasenia) {
    return repository.loginUsuario(correo, contrasenia);
}

/*
public UsuarioLoginDTO login(String correo, String contrasenia) {
	
	Optional<UsuarioEntity> usuarioExistente= usuarioRepository.
	
}*/

public void delete(Long id) {
    repository.deleteById(id);
}

}


