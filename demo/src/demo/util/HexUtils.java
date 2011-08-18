package demo.util;

import java.util.Arrays;

/**
 * Taken from http://www.snippetit.com/2009/08/java-format-long-integer-into-hexadecimal-string/
 */
public class HexUtils {
	private final static char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static long toLong(String hexadecimal) throws NumberFormatException {
		char[] chars;
		char c;
		long value = 0;

		if (hexadecimal == null)
			throw new IllegalArgumentException();

		hexadecimal = addLeadingZeros(hexadecimal);
		chars = hexadecimal.toUpperCase().toCharArray();

		for (int i = 0; i < 16; i++) {
			c = chars[i];
			if (c >= '0' && c <= '9') {
				value = ((value << 4) | (0xff & (c - '0')));
			} else if (c >= 'A' && c <= 'F') {
				value = ((value << 4) | (0xff & (c - 'A' + 10)));
			} else {
				throw new NumberFormatException("Invalid hex character: " + c);
			}
		}

		return value;
	}

	private static String addLeadingZeros(String hexadecimal) {
		int numOfZeros = 16 - hexadecimal.length();
		char[] result = new char[16];
		Arrays.fill(result, 0, numOfZeros, '0');
		
		for(int i = 0; i < hexadecimal.length(); i++) {
			result[numOfZeros + i] = hexadecimal.charAt(i);
		}
		
		return String.valueOf(result);
	}

	public static String fromLong(long value) {
		char[] hexs;
		int c;

		hexs = new char[16];
		for (int i = 0; i < 16; i++) {
			c = (int) (value & 0xf);
			hexs[16 - i - 1] = HEX[c];
			value = value >> 4;
		}
		return new String(hexs);
	}
}