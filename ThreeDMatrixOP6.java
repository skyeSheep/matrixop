package matrixop;

public class ThreeDMatrixOP6 {
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
		int i = Integer.parseInt(args[9]);
		if (i < 0 || i > 2) {
			System.out.println("i must be 0-2");
			return;
		}
		int j = Integer.parseInt(args[10]);
		if (j < 0 || j > 2) {
			System.out.println("j must be 0-2");
			return;
		}
		int k = Integer.parseInt(args[11]);
		if (k < -10 || k > 10) {
			System.out.println("k must be -10 - 10");
			return;
		}
		// 交换i和j行
		double[][] afterSwap = swapIJ(m1, i, j);
		// 对矩阵乘上k
		double[][] afterProduction = numProduction(afterSwap, k);
		// 将第j行加到第i行上
		double[][] afterADD = ADD(afterProduction, j, i);
		// 计算特征值之和
		double eigenSum = trace(afterADD);
		// 计算特征值之积
		double eigenProduction = eigenPro(afterADD);
		// 计算特征值之积和之和的比值
		double res = divide(eigenProduction, eigenSum);
		res = (double) (Math.round(res * 100) / 100);
		System.out.println(res);
	}

	// 矩阵数乘。将所有元素与K相乘
	public static double[][] numProduction(double[][] a, double k) {
		if (a.length != 3 || a[0].length != 3) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result[i][j] = a[i][j] * k;
			}
		}
		return result;
	}

	// 将矩阵的第i行加到第j行上。
	public static double[][] ADD(double[][] a, int i, int j) {
		if (a.length != 3 || a.length != a[0].length) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		for (int ii = 0; ii < a.length; ii++) {
			for (int jj = 0; jj < a[0].length; jj++) {
				if (ii == j) {
					result[ii][jj] = a[ii][jj] + a[i][jj];
				} else {
					result[ii][jj] = a[ii][jj];
				}
			}
		}
		return result;
	}

	// 交换第i行和第j行
	public static double[][] swapIJ(double[][] a, int i, int j) {
		if (a.length != 3 || a.length != a[0].length) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		for (int ii = 0; ii < a.length; ii++) {
			for (int jj = 0; jj < a[0].length; jj++) {
				if (ii == i) {
					result[ii][jj] = a[j][jj];
				} else if (ii == j) {
					result[ii][jj] = a[i][jj];
				} else {
					result[ii][jj] = a[ii][jj];
				}
			}
		}
		return result;
	}

	// 计算三阶矩阵的trace，并对100007取余
	public static double trace(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		double trace = a[0][0] % 100007;
		trace = (trace + a[1][1]) % 100007;
		trace = (trace + a[2][2]) % 100007;
		return trace;
	}

	// 计算三阶矩阵的特征值之积，并对100007取余
	public static double eigenPro(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		double trace = a[0][0] % 100007;
		trace = (trace * a[1][1]) % 100007;
		trace = (trace * a[2][2]) % 100007;
		return trace;
	}

	// 计算两数比值
	public static double divide(double a, double b) {
		if (b < 1 && b > -1) {
			return a;
		}
		double divided = a * 1.0 / b;
		return divided;
	}
}