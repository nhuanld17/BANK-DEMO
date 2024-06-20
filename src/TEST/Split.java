package TEST;

public class Split {
	public static void main(String[] args) {
		String str = "A__B__C__";
		String[] p = str.split("__");
		System.out.println(p.length);
		for (String string : p) {
			System.out.println(string);
		}
	}
}
