package caesar_cipher;

import java.util.Scanner;

public class CaesarCipher {
	public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

	public static String encrypt(String message, int shiftKey) {
		message = message.toLowerCase();
		String cipherText = "";
		for (int i = 0; i < message.length(); i++) {
			int charPosition = alpha.indexOf(message.charAt(i));
			int keyVal = (shiftKey + charPosition) % 26;

			System.out.println(keyVal);

			char replaceChar = alpha.charAt(keyVal);
			cipherText += replaceChar;
		}
		return cipherText;
	}

	public static String decrypt(String cipherText, int shiftKey) {
		cipherText = cipherText.toLowerCase();
		String message = "";
		for (int i = 0; i < cipherText.length(); i++) {
			int charPosition = alpha.indexOf(cipherText.charAt(i));
			int keyVal = (charPosition - shiftKey) % 26;
			System.out.println(keyVal);

			if (keyVal < 0) {
				keyVal = alpha.length() + keyVal;
			}

			char replaceChar = alpha.charAt(keyVal);
			message += replaceChar;
		}
		return message;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = new String();
		System.out.println("Enter the String for Encryption: ");
		message = sc.next();

		System.out.println("\n\nEnter Shift Key or Offset: ");
		int offset = sc.nextInt();
		sc.close();

		String encrypted = encrypt(message, offset);
		System.out.println("\nEncrypted String is: " + encrypted);
		String decrypted = decrypt(encrypted, offset);
		System.out.println("\nDecrypted String is: " + decrypted);
	}

}
