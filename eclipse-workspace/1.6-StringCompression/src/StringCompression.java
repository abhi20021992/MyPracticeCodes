import java.util.HashMap;
import java.util.Map;

public class StringCompression {

	public static void main(String[] args) {
		String defaultString = "abcdaadtbhheess";
		System.out.println("compressed string :-" + compressedString(defaultString));
	}
	
	public static String compressedString(String stringToBeCompressed) {
		char[] charArray = stringToBeCompressed.toCharArray();
		Map<String, Integer> output = new HashMap<String, Integer>();
		for(int index = 0; index < charArray.length; index ++) {
			if(output.containsKey(Character.toString(charArray[index]))) {
				int currentCount = output.get(Character.toString(charArray[index]));
				output.replace(Character.toString(charArray[index]),++currentCount);
			}else {
				output.put(Character.toString(charArray[index]), 1);
			}
		}
		return output.toString().replace("=", "").replace(", ", "").replace("{", "").replace("}", "");
	}
}
