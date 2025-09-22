package bo.gob.dgac.proveedores.utils;

import org.apache.commons.text.RandomStringGenerator;

public class PasswordGenerator {

    public static String generatePassword() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange(33, 122) // caracteres imprimibles ASCII
                .filteredBy(Character::isLetterOrDigit, ch -> "!@#$%&*".indexOf(ch) >= 0)
                .build();

        return generator.generate(12);
    }

    public static void main(String[] args) {
        System.out.println("Contraseña generada: " + generatePassword());
    }
}
