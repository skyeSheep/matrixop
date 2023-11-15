package matrixop;

public class ThreeDMatrixOP2 {
	public static void main(String[] args) {
		double[][] m1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
		double[][] m2 = { { 1, 2, 4 }, { 4, 5, 6 } };
		m1[0][0] = Double.parseDouble(args[0]);
		m1[0][1] = Double.parseDouble(args[1]);
		m1[1][0] = Double.parseDouble(args[2]);
		m1[1][1] = Double.parseDouble(args[3]);
		m1[2][0] = Double.parseDouble(args[4]);
		m1[2][1] = Double.parseDouble(args[5]);
		m2[0][0] = Double.parseDouble(args[6]);
		m2[0][1] = Double.parseDouble(args[7]);
		m2[0][2] = Double.parseDouble(args[8]);
		m2[1][0] = Double.parseDouble(args[9]);
		m2[1][1] = Double.parseDouble(args[10]);
		m2[1][2] = Double.parseDouble(args[11]);
		// 矩阵相乘
		double[][] production = multiply23(m1, m2);
		// 计算伴随矩阵
		double[][] acc = accompany(production);
		// 计算特征值之和
		double eigenSum = trace(acc);
		// 计算特征值之积
		double eigenProduction = eigenPro(acc);
		// 输出特征值积与和的除法
		double res = eigenProduction / eigenSum;
		res = (double) (Math.round(res * 100) / 100);
		res %= 100007;
		System.out.println(res);
	}

	// 计算3*2矩阵与2*3矩阵的乘积，得到三阶矩阵
	public static double[][] multiply23(double[][] a, double[][] b) {
		if (a.length != 3 || a[0].length != 2 || b.length != 2 || b[0].length != 3) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		result[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
		result[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
		result[0][2] = a[0][0] * b[0][2] + a[0][1] * b[1][2];
		result[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
		result[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
		result[1][2] = a[1][0] * b[0][2] + a[1][1] * b[1][2];
		result[2][0] = a[2][0] * b[0][0] + a[2][1] * b[1][0];
		result[2][1] = a[2][0] * b[0][1] + a[2][1] * b[1][1];
		result[2][2] = a[2][0] * b[0][2] + a[2][1] * b[1][2];
		return result;
	}

	// 计算三阶矩阵的伴随矩阵
	public static double[][] accompany(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		result[0][0] = a[1][1] * a[2][2] - a[2][1] * a[1][2];
		result[0][1] = -(a[1][0] * a[2][2] - a[2][0] * a[1][2]);
		result[0][2] = a[1][0] * a[2][1] - a[2][0] * a[1][1];
		result[1][0] = -(a[0][1] * a[2][2] - a[2][1] * a[0][2]);
		result[1][1] = a[0][0] * a[2][2] - a[2][0] * a[0][2];
		result[1][2] = -(a[0][0] * a[2][1] - a[2][0] * a[0][1]);
		result[2][0] = a[0][1] * a[1][2] - a[1][1] * a[0][2];
		result[2][1] = -(a[0][0] * a[1][2] - a[1][0] * a[0][2]);
		result[2][2] = a[0][0] * a[1][1] - a[1][0] * a[0][1];
		return result;
	}

	// 计算三阶矩阵的行列式
	public static double determinant(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		double a1 = a[0][0] * a[1][1] * a[2][2];
		double a2 = a[0][1] * a[1][2] * a[2][0];
		double a3 = a[0][2] * a[1][0] * a[2][1];
		double b1 = a[0][2] * a[1][1] * a[2][0];
		double b2 = a[0][0] * a[1][2] * a[2][1];
		double b3 = a[0][1] * a[1][0] * a[2][2];
		return a1 + a2 + a3 - b1 - b2 - b3;
	}

	// 计算三阶矩阵的trace
	public static double trace(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		return a[0][0] + a[1][1] + a[2][2];
	}

	// 计算三阶矩阵的特征值之积
	public static double eigenPro(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return 0.0;
		}
		return a[0][0] * a[1][1] * a[2][2];
	}

	// 定义新运算：对三阶矩阵的第一、二、三行，用134,97,113除以他们。如果本身值在-1和1之间，则不做任何操作.
	public static double[][] newOP(double[][] a) {
		if (a.length != 3 || a.length != a[0].length) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (i == 0) {
					result[i][j] = (a[i][j] > 1.0 || a[i][j] < -1.0) ? (134.0 / a[i][j]) : a[i][j];
				} else if (i == 1) {
					result[i][j] = (a[i][j] > 1.0 || a[i][j] < -1.0) ? (97.0 / a[i][j]) : a[i][j];
				} else if (i == 2) {
					result[i][j] = (a[i][j] > 1.0 || a[i][j] < -1.0) ? (113.0 / a[i][j]) : a[i][j];
				}
			}
		}
		return result;
	}

	public static void printMatrix(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}