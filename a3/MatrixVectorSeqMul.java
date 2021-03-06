package ca.mcgill.ecse420.a3;

import java.util.stream.IntStream;

public class MatrixVectorSeqMul {

	public static void main(String[] args) throws InterruptedException {

		 int size = 2000; /*
		 * This is for define the size of two matrix for multiplication, in this
		 * question we assume matrix are square matrix and with all 0s
		 */
		 long startTime;
		 long endTime;
		 long totalTime;
		 double[][] a = new double[size][size];
		 double[][] b = new double[size][1];// Two matrix for multiplication
		 double[][] res;

		 startTime = System.currentTimeMillis(); // Save the time stamp before
		 res = sequentialMultiplyMatrix(a, b);
		 endTime = System.currentTimeMillis(); // Save the time stamp when

		 totalTime = endTime - startTime; // Subtract for total runtime
		 System.out.println("Sequential multiplication runtime: " + totalTime);

	}

	public static double[][] sequentialMultiplyMatrix(double[][] a, double[][] b) {
		int aColNum = a[0].length;
		int bRomNum = b.length;
		if (aColNum != bRomNum) // check if matrix multiply condition
			return null;
		int resultRowNum = a.length;
		int resultColNum = b[0].length;
		double[][] result = new double[resultRowNum][resultColNum];
		for (int i = 0; i < resultRowNum; i++) { // rows from m1
			for (int j = 0; j < resultColNum; j++) { // columns from m2
				result[i][j] += multiplyAndSumTwoArrays(a[i], getColumn(b, j));
			}
		}
		return result;
	}

	public static double multiplyAndSumTwoArrays(double[] a, double[] b) {
		double sum = 0.0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i] * b[i];
		}
		return sum;
	}

	public static double[] getColumn(double[][] matrix, int column) {
		return IntStream.range(0, matrix.length).mapToDouble(i -> matrix[i][column]).toArray();
	}

	public static String printArray(double[] m) {
		String result = "";
		for (int i = 0; i < m.length; i++) {
			result += String.format("%11.2f", m[i]);
		}
		return result;
	}

	public static String printMatrix(double[][] m) {
		String result = "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				result += String.format("%11.2f", m[i][j]);
			}
			result += "\n";
		}
		return result;
	}

}
