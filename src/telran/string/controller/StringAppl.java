package telran.string.controller;

public class StringAppl {

	public static void main(String[] args) {
		String str = "Hello";
		char[] chars = { ' ', 'w', 'o', 'r', 'l', 'd' };
		String str1 = new String(chars);
		str = str + str1; // str.concat(str1);
		System.out.println(str);
		System.out.println(str.length());
		char c = str.charAt(2);
		System.out.println(c);
		for(int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		String str2 = " World";
		System.out.println(str2.equalsIgnoreCase(str1));
		String strUpper = str.toUpperCase();
		System.out.println(strUpper);
		System.out.println(str);
		int index = str.indexOf('l');
		System.out.println(index);
		index = str.lastIndexOf('l');
		System.out.println(index);
		System.out.println(str.substring(2, 4 ));
		System.out.println(str.replace(Character.toString('o'), "o-o-o"));
	}

}
