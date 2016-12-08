public class Barcode implements Comparable<Barcode> {
	private String _zip;
	private int _checkDigit;

	public Barcode(String zip) {
		zip = _zip;
		_checkDigit = checkSum();
	}

	public Barcode clone() {
		Barcode barcode = new Barcode(_zip);
		return barcode;
	}

	private int checkSum() {
		int result = 0;
		for (int i = 0; i < _zip.length(); i++) {
			result += (int) _zip.charAt(i);
		}
		result = result % 10;
		return result;
	}

	public String toString() {
		String result = "|";
		for (int i = 0; i < _zip.length(); i++) {
			switch (_zip.charAt(i)) {
				case 1: result += ":::||";
						break;
				case 2: result += "::|:|";
						break;
				case 3: result += "::||:";
						break;
				case 4: result += ":|::|";
						break;
				case 5: result += ":|:|:";
						break;
				case 6: result += ":||::";
						break;
				case 7: result += "|:::|";
						break;
				case 8: result += "|::|:";
						break;
				case 9: result += "|:|::";
						break;
				case 0: result += "||:::";
						break;
			}
		}
		result += "|";
		return result;
	}

	public int compareTo(Barcode other) {
		return 0;
	}

	public static void main(String[] args) {
		Barcode barcode = new Barcode("11111");

		System.out.println(barcode.toString());
	}
}