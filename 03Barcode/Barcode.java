public class Barcode implements Comparable<Barcode> {
	private String _zip;
	private int _checkDigit;


	public Barcode(String zip) {
		if (validZip(zip)) {
			_zip = zip;
			_checkDigit = checkSum(zip);
		} else {
			throw new IllegalArgumentException("Your zip must be 5 digits!");
		}
	}

	private static boolean validZip(String zip) {
		boolean result = true;
		for (int i = 0; i < zip.length(); i++) {
			if (!Character.isDigit(zip.charAt(i)) && zip.length() != 5) {
				result = false;
			}
		}
		return result;
	}

	public Barcode clone() {
		Barcode barcode = new Barcode(_zip);
		return barcode;
	}

	private static int checkSum(String zip) {
		int result = 0;
		for (int i = 0; i < zip.length(); i++) {
			result += (int)zip.charAt(i);
		}
		result = result % 10;
		return result;
	}

	public String toString() {
		String result = _zip + _checkDigit;
		result += " " + toCode(_zip);
		return result;
	}

	public int compareTo(Barcode other) {
		String o = _zip + checkSum(_zip);
		String p = other._zip + other.checkSum(other._zip);
		return o.compareTo(p);
	}

	public static String toCode(String zip) {
		if (validZip(zip)) {
			String zipCheckSum = zip + checkSum(zip);
			String result ="|";
			for (int i = 0; i < zipCheckSum.length(); i++) {
				switch (zipCheckSum.charAt(i)) {
					case '1': result += ":::||";
					break;
					case '2': result += "::|:|";
					break;
					case '3': result += "::||:";
					break;
					case '4': result += ":|::|";
					break;
					case '5': result += ":|:|:";
					break;
					case '6': result += ":||::";
					break;
					case '7': result += "|:::|";
					break;
					case '8': result += "|::|:";
					break;
					case '9': result += "|:|::";
					break;
					case '0': result += "||:::";
					break;
				}
			}
			result += "|";
			return result;
		} else {
			throw new IllegalArgumentException("Your zip must be 5 digits!");
		}
	}

	private static boolean validCode(String code) {
		boolean result = true;
		if (code.length() != 32) {
			throw new IllegalArgumentException("Your barcode's length is not 32!");
		}
		if (code.charAt(0) != '|' || code.charAt(31) != '|') {
			throw new IllegalArgumentException("Your barcode either does not start or end with '|'");
		}
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) != '|' && code.charAt(i) != ':') {
				throw new IllegalArgumentException("Your barcode contains a non-barcode character!");
			}
		}
		return result;
	}

	public static String toZip(String code) {
		if (validCode(code)) {
			String result = "";
			String zip = code.substring(1);
			for (int i = 0; i < code.length(); i += 5) {
				if (zip.length() >= 6) {
					switch (zip.substring(0,5)) {
						case ":::||": result += "1";
						break;
						case "::|:|": result += "2";
						break;
						case "::||:": result += "3";
						break;
						case ":|::|": result += "4";
						break;
						case ":|:|:": result += "5";
						break;
						case ":||::": result += "6";
						break;
						case "|:::|": result += "7";
						break;
						case "|::|:": result += "8";
						break;
						case "|:|::": result += "9";
						break;
						case "||:::": result += "0";
						break;
						default: throw new IllegalArgumentException("Your barcode contains an invalid code!");
					}
					zip = zip.substring(5);
				}
			}
			if (checkSum(result.substring(0,5)) + '0' != result.charAt(5)) {
				throw new IllegalArgumentException("Your checksum is invalid!");
			}
			return result;
		}
		return "";
	}
}