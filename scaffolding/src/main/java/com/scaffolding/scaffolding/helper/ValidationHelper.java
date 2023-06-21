package com.scaffolding.scaffolding.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.scaffolding.scaffolding.exceptions.ValidationException;


public class ValidationHelper {
    
    private static final String exprRegEmail = "^.+@.+\\..+$";
	private static final String exprRegFalseDNI = "[0-9]{8}[a-zA-Z]";

    //https://stackoverflow.com/questions/11533474/java-how-to-test-if-a-string-contains-both-letters-and-numbers - REGEX STRING WITH NUMBERS AND LETTERS BOTH
    //regex que almacena distintas posibilidades de regex separadas por "|"
    private static final String exprRegPassword = "([a-zA-Z].*[0-9]+)|([0-9].*[a-zA-Z]+)|([a-zA-Z].*[a-zA-Z0-9].*[0-9]+)|([0-9].*[a-zA-Z0-9].*[a-zA-Z]+)|([0-9].*[a-zA-Z].*[0-9]+)|([a-zA-Z].*[0-9].*[a-zA-Z]+)";
	
	public static void validateDNI(String DNI, String error) {
        DNI = DNI.trim().replaceAll(" ", "").toUpperCase();
       
        if (DNI.length() != 9 || !isNumeric(DNI.substring(0, 8))) {
            throw new ValidationException("Error en el dni");
        }
        else{
            int intPartDNI = Integer.parseInt(DNI.substring(0, 8));
            char cLetraDNI = DNI.charAt(8);
            int valNumDni = intPartDNI % 23;
            if ("TRWAGMYFPDXBNJZSQVHLCKE".charAt(valNumDni) != cLetraDNI) {
                throw new ValidationException(error);
            }
        }
	}
	
	public static void validateFalseDNI(String DNI, String error) {
		DNI = DNI.trim().replaceAll(" ", "").toUpperCase();
		Pattern p = Pattern.compile(exprRegFalseDNI);
		Matcher m = p.matcher(DNI);
		if (!m.matches()) {
			throw new ValidationException(error);
		}
	}
		
	public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	public static void validateStringLength(String strNombre, int minlength, int maxlength, String error) {
        if (strNombre.length() < minlength || strNombre.length() > maxlength) {
            throw new ValidationException("Longitud inadecuada: " + error);
        }
    }
	
	public static void validateEmail(String email, String error) {
        if (!email.isBlank()) {
            validateStringLength(email, 3, 255, error);
       
            Pattern p = Pattern.compile(exprRegEmail);
            Matcher m = p.matcher(email);
            if (!m.matches()) {
                throw new ValidationException(error);
            }
        }
    }

    public static void validatePassword(String password) {
        validateStringLength(password, 8, 30, "La longitud debe estar entre 8 y 30 caracteres");
        Pattern p = Pattern.compile(exprRegPassword);
		Matcher m = p.matcher(password);

		if (!m.matches()) {
			throw new ValidationException("Debe contener al menos números y letras");
		}
    }

}
