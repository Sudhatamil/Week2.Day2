package Week2.Day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {

		String text = "Tes12Le79af65";
		int sum = 0;
		String replacechar = text.replaceAll("\\D", "");
		System.out.println(replacechar);

		char[] ch = replacechar.toCharArray();

		for (int i = 0; i < replacechar.length(); i++) {

			sum = sum + Character.getNumericValue(ch[i]);

		}
		System.out.println("Sum:"+sum);
	}
}
