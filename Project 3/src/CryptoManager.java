public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		// Turn into a char array
		char[] charArray = plainText.toCharArray();
		
		// Check if it's in bounds referring to the upper bound and lower bound
		for(char nextChar : charArray) 
			if (nextChar > UPPER_BOUND || nextChar < LOWER_BOUND)
				return false;
		
		// If the last loop had no problems, return true
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// Create int key so you can work with it
		int nKey = key;
		
		// Put the key in the right range if it's not in range already.
		while(nKey > RANGE) {
			nKey -= RANGE;
		}
		
		// Set the encrypted text to nothing
		String encryptedText="";
		
		// Check if it's in bounds
		if(stringInBounds(plainText)) {
			// Go through every character in the plainText
			for(int i =  0; i < plainText.length(); i++) {
				// Set the current char to the current char at index i of plaintext
				char newChar = plainText.charAt(i);
				// Add the key to char
				newChar += nKey;
				// Check if it's out of bounds, if it is, loop back around and make it in bounds
				if(newChar > UPPER_BOUND) {
					newChar = (char) (newChar - UPPER_BOUND + LOWER_BOUND - 1);
				}
				
				// Add the encrypted char to the whole encrypted text
				encryptedText += newChar;
			}
			// Return the encrypted text after it's all done.
			return encryptedText;
		} else {
			// Return nothing if it's not in bounds
			return "";
		}
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// Create String array for the bellaso key
		String[] bellasoKey = new String[plainText.length()];
		// Turn every the text into a character array
		char[] plainChar = plainText.toCharArray();
		// Create encrypted text variable
		String encryptedText = "";
		
		// check if it's in bounds
		if (stringInBounds(plainText)) {
			// Loop through every character of the plain text
			for(int i = 0; i < plainText.length();i++) {
				// Check if the current index is greater than the length of the key, loop back around
				if(i > bellasoStr.length() - 1) {
					// Make the bellaso key go back, so it would follow the format with key CMSC and a plainText of helloworld
					// C,M,S,C,C,M,S,C,C,M
					bellasoKey[i] = bellasoStr.split("")[i % bellasoStr.length()];
				} else {
					// Just make the current index the instance of index i
					bellasoKey[i] = bellasoStr.split("")[i];
				}
			}
			
			// Loop through the char array
			for(int i = 0; i < plainChar.length; i++) {
				// Encrypt the char
				char encryptedChar = (char)(plainChar[i] + bellasoKey[i].charAt(0));
				
				// Make sure it's in bounds by going forward or backwards
				while(encryptedChar > UPPER_BOUND)
					encryptedChar -= RANGE;
				
				while(encryptedChar < LOWER_BOUND)
					encryptedChar += RANGE;
				
				// Add the encrypted char to the text
				encryptedText += encryptedChar;
			}
			
			// Return the encrypted text when done
			return encryptedText;
		}
		
		// Return nothing if the string is not in bounds
		return "";
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// Create a variable to work with the key
		int nKey = key;
		// Put the key in range
		while(nKey > RANGE) {
			nKey -= RANGE;
		}
		
		// Create decrypted text variable
		String decryptedText="";
		
		// Go through the whole length of the encrypted text
		for(int i = 0; i < encryptedText.length(); i++) {
			// Set the current char to the current index of encryptedText
			char newChar = encryptedText.charAt(i);
			
			// Subtract the key from the current char
			newChar -= nKey;
			
			// Make sure it's in bounds
			if(newChar < LOWER_BOUND) {
				newChar = (char) (newChar + RANGE);
			}
			
			// add the decrypted char to the decrypted text
			decryptedText+=newChar;
		}
		
		// Return the decrypted text
		return decryptedText;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// Create key array as before
		String[] bellasoKey = new String[encryptedText.length()];
		
		// Create encrypted char Array
		char[] encryptedChar = encryptedText.toCharArray();
		
		// Create decrypted text
		String decryptedText = "";
		
		// Loop through the length of encryptedText
		for(int i = 0; i < encryptedText.length();i++) {
			
			// Check if i is greater than the length of the key
			if(i > bellasoStr.length() - 1) {
				// If it is, loop back through the key and start over
				bellasoKey[i] = bellasoStr.split("")[i % bellasoStr.length()];
			} else {
				// Just make the current index i to the current index of the key
				bellasoKey[i] = bellasoStr.split("")[i];
			}
		}
		
		// Loop through the length of the encryptedChar
		for(int i = 0; i < encryptedChar.length; i++) {
			// Decrypt the char by subtracting the key.
			char decryptedChar = (char)(encryptedChar[i] - bellasoKey[i].charAt(0));
			
			// Make sure the char is in bounds
			while(decryptedChar < LOWER_BOUND)
				decryptedChar += RANGE;
			
			while(decryptedChar > UPPER_BOUND)
				decryptedChar -= RANGE;
			
			// Add the encrypted char to the decrypted text
			decryptedText += decryptedChar;
		}
		
		// Return the decrypted text
		return decryptedText;
	}
}
