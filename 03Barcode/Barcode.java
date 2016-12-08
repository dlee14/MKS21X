public class Barcode implements Comparable<Barcode> {
	private String _zip;
	private int _checkDigit;

	public Barcode(String zip) {
		if (zip.length() == 5) {
			_zip = zip;
			_checkDigit = checkSum();
		} else {
			throw new IllegalArgumentException("Your zip must be 5 digits!");
		}
	}

	public Barcode clone() {
		Barcode barcode = new Barcode(_zip);
		return barcode;
	}

	private int checkSum() {
		int result = 0;
		for (int i = 0; i < _zip.length(); i++) {
			result += (int)_zip.charAt(i);
		}
		result = result % 10;
		return result;
	}

	public String toString() {
		String result = "|";
		for (int i = 0; i < _zip.length(); i++) {
			switch (_zip.charAt(i)) {
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
	}

	public int compareTo(Barcode other) {
		String o = _zip + checkSum() ;
		String p = other._zip + other.checkSum();
		return o.compareTo(p);
	}

	public static void main(String[] args) {
		Barcode barcode1 = new Barcode("12342");
		Barcode barcode2 = new Barcode("26343");

		System.out.println(barcode1);
		System.out.println(barcode1.clone());
		System.out.println(barcode1.compareTo(barcode2));
	}
}