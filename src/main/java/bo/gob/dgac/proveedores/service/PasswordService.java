package bo.gob.dgac.proveedores.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PasswordService {

    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String ESPECIALES = "@#$%&*!";

    private static final String TODOS = MAYUSCULAS + MINUSCULAS + NUMEROS + ESPECIALES;

    private final SecureRandom random = new SecureRandom();

    public String generarPassword(int length) {
        if (length < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }

        List<Character> password = new ArrayList<>();

        // Asegurar 1 de cada tipo
        password.add(MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length())));
        password.add(MINUSCULAS.charAt(random.nextInt(MINUSCULAS.length())));
        password.add(NUMEROS.charAt(random.nextInt(NUMEROS.length())));
        password.add(ESPECIALES.charAt(random.nextInt(ESPECIALES.length())));

        // Rellenar el resto
        for (int i = 4; i < length; i++) {
            password.add(TODOS.charAt(random.nextInt(TODOS.length())));
        }

        // Mezclar
        Collections.shuffle(password, random);

        // Convertir a String
        StringBuilder sb = new StringBuilder();
        for (char c : password) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String generarPassword() {
        return generarPassword(12); // Longitud por defecto
    }
}
