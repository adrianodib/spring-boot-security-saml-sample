package br.com.assesso.dcsecurity.saml.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils; 

public class RandomGenerator {
	
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static SecureRandom rnd = new SecureRandom();

	public static String generatePassword(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*=+<>?";
		return  RandomStringUtils.random(length, characters);
	}

	public static String generateTokenToValid() {
		String token = randomString(8);
		token += "-" + randomString(4);
		token += "-" + randomString(4);
		token += "-" + randomString(12);
		return token;
	}
	
	private static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}	
	
	/**
	 * Gera uma String com números aleatório de 6 dígitos
	 * 
	 * @return DC+<numero gerado>
	 */
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return "DC-"+String.format("%06d", number); 
	}
}
