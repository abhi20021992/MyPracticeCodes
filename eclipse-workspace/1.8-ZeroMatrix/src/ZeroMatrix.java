import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String[] args) {
		int [][] matrix = {{1,2,3}, {4,5,6}, {7,8,1}};
		boolean result = isZeroMatrix(matrix); 
		if(result) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}

	private static boolean isZeroMatrix(int[][] matrix) {
		for(int index = 0; index < matrix.length; index ++) {
			if(Arrays.toString(matrix[index]).contains("0")) {
				return true;
			}
		}
		return false;
	}

}
