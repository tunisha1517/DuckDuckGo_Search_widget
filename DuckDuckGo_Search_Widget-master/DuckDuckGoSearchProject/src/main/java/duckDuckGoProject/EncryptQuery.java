package duckDuckGoProject;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncryptQuery {

	private static String ALGO = "AES/CBC/PKCS5PADDING";

	/**
	 * generates unique key using AES algorithm
	 * 
	 * @param keysize
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static SecretKey generateKey(int keysize) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(keysize);
		SecretKey key = keyGenerator.generateKey();
		return key;
	}

	/**
	 * encrypts the given input String with Secret key and iv parameter
	 * 
	 * @param input
	 * @param key
	 * @param iv
	 * @return cipherText or the encrypted string
	 */
	public static String encrypt(String input, SecretKey key, IvParameterSpec iv) {

		byte[] cipherText = null;
		try {
			Cipher cipher = Cipher.getInstance(ALGO);
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);
			cipherText = cipher.doFinal(input.getBytes());
		} catch (InvalidKeyException e) {
			System.out.println("Problem in genrated key, check key validity");
			e.getLocalizedMessage();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Set a valid algorithm for encryption.");
			e.getLocalizedMessage();
		} catch (NoSuchPaddingException e) {
			e.getLocalizedMessage();
		} catch (InvalidAlgorithmParameterException e) {
			e.getLocalizedMessage();
		} catch (IllegalBlockSizeException e) {
			e.getLocalizedMessage();
		} catch (BadPaddingException e) {
			e.getLocalizedMessage();
		}
		return Base64.getEncoder().encodeToString(cipherText);
	}

	/**
	 * generates iv parameter
	 * 
	 * @return generated iv parameter value
	 */
	public static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

}
