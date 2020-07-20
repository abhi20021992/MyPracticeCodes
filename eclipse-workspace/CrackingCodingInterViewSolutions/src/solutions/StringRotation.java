package solutions;


public class StringRotation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstString = "waterbottle";
		String secondString = "terbottlewa";
		boolean result = isSubstring(firstString, secondString);
		System.out.println(result);
	}

	private static boolean isSubstring(String firstString, String secondString) {
		if(firstString.length()!= secondString.length()) {
			return false;
		}
		if(firstString.equals(secondString)) {
			return true;
		}
		for(int index = 0 ; index < firstString.length(); index ++) {
			secondString = getNewRotationString(secondString);
			if(firstString.equals(secondString)) {
				return true;
			}
		}
		return false;
	}

	private static String getNewRotationString(String oldString) {
		return oldString.substring(1, oldString.length()) + Character.toString(oldString.charAt(0));
	}
	
}
