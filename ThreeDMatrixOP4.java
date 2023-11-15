package matrixop;

public class ThreeDMatrixOP4 {
	public static void main(String[] args) {
		double[][] m1 = { { 1, 2, 4 }, { 4, 5, 6 }, { 7, 8, 9 } };
		m1[0][0] = Double.parseDouble(args[0]);
		m1[0][1] = Double.parseDouble(args[1]);
		m1[0][2] = Double.parseDouble(args[2]);
		m1[1][0] = Double.parseDouble(args[3]);
		m1[1][1] = Double.parseDouble(args[4]);
		m1[1][2] = Double.parseDouble(args[5]);
		m1[2][0] = Double.parseDouble(args[6]);
		m1[2][1] = Double.parseDouble(args[7]);
		m1[2][2] = Double.parseDouble(args[8]);
		// Calculate the L0 norm
		int l0 = L0(m1);
		// Calculate the L1 norm
		double l1 = L1(m1);
		// Calculate the L2 norm
		double l2 = L2(m1);
		// Calculate the L3 norm
		double l3 = L3(m1);
		// Calculate the average of the four norms
		double res = average(l0, l1, l2, l3);
		res = (double) (Math.round(res * 100) / 100.0);
		System.out.println(res);
	}

	// Calculate the L0 norm.
	// The L0 norm is defined here as the number of elements with an absolute value
	// greater than or equal to 0.75
	public static int L0(double[][] a) {
		if (a.length != 3 || a[0].length != 3) {
			return -1;
		}
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (Math.abs(a[i][j]) >= 0.75) {
					result++;
				}
			}
		}
		return result;
	}

	// Calculate the L1 norm.
	// The L1 norm is the sum of the absolute values of all elements
	public static double L1(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return -1.0;
		}
		double result = 0.0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result = result + Math.abs(a[i][j]);
			}
		}
		return result;

	}

	// Calculate the L2 norm.
	// The L2 norm is the open square of the sum of all elements,
	// i.e., the Euclidean distance
	public static double L2(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		double result = 0.0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result = result + Math.pow(a[i][j], 2);
			}
		}
		result = Math.sqrt(result);
		return result;
	}

	// Calculate the L3 norm.
	// The L3 norm is the cube root of the sum of the cubes of all elements
	public static double L3(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		double result = 0.0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result = result + a[i][j] * a[i][j] * a[i][j];
			}
		}
		result = Math.cbrt(result);
		return result;
	}

	// Calculate the sum of L0, L1, L2, L3 norms, and take the average
	public static double average(int l0, double l1, double l2, double l3) {
		double result = 0.0;
		result = result + (double) l0;
		result = result + l1 + l2 + l3;
		result = result / 4.0;
		return result;
	}
}