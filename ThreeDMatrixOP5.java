package matrixop;

public class ThreeDMatrixOP5 {
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
		int k = Integer.parseInt(args[9]);
		// Calculate the L0 norm
		int l0 = L0(m1);
		// Calculate the L1 norm
		double l1 = L1(m1);
		// Calculate the L2 norm
		double l2 = L2(m1);
		// Calculate the Lk norm
		double lk = LK(m1, k);
		// Calculate the average of the four norms
		double res = average(l0, l1, l2, lk);
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

	// Calculate the LK norm.
	// Here the LK norm is defined as the cubic root of the sum of all elements to
	// the power K.
	// When calculating the sum to the power of K, the form of accumulation is used.
	// Each accumulation takes a surplus of 100000007 to prevent overflow
	public static double LK(double[][] a, int K) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		double result = 0.0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				double tmp = 1.0;
				for (int k = 0; k < K; k++) {
					tmp = (tmp * a[i][j]) % 100000007;
				}
				result = (result + tmp) % 100000007;
			}
		}
		result = Math.cbrt(result);
		return result;
	}

	// Calculate the sum of L0, L1, L2, LK norms, and take the average
	public static double average(int l0, double l1, double l2, double lk) {
		double result = 0.0;
		result = result + (double) l0;
		result = result + l1 + l2 + lk;
		result = result / 4.0;
		return result;
	}
}