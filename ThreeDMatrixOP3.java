package matrixop;

public class ThreeDMatrixOP3 {
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
		// 矩阵相乘
		double[][] production = multiply(m1, m1);
		// 矩阵相加
		double[][] acc = add(production, m1);
		// 计算行列式
		double res = determinant(acc);
		System.out.println(res);
	}

	// 计算3*3矩阵与3*3矩阵的乘积，得到三阶矩阵
	public static double[][] multiply(double[][] a, double[][] b) {
		if (a.length != 3 || a[0].length != 3 || b.length != 3 || b[0].length != 3) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		result[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0] + a[0][2] * b[2][0];
		result[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1] + a[0][2] * b[2][1];
		result[0][2] = a[0][0] * b[0][2] + a[0][1] * b[1][2] + a[0][2] * b[2][2];
		result[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0] + a[1][2] * b[2][0];
		result[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1] + a[1][2] * b[2][1];
		result[1][2] = a[1][0] * b[0][2] + a[1][1] * b[1][2] + a[1][2] * b[2][2];
		result[2][0] = a[2][0] * b[0][0] + a[2][1] * b[1][0] + a[2][2] * b[2][0];
		result[2][1] = a[2][0] * b[0][1] + a[2][1] * b[1][1] + a[2][2] * b[2][1];
		result[2][2] = a[2][0] * b[0][2] + a[2][1] * b[1][2] + a[2][2] * b[2][2];
		return result;
	}

	public static double[][] add(double[][] a, double[][] b) {
		if (a.length != 3 || a.length != a[0].length || b.length != 3 || b.length != b[0].length) {
			return null;
		}
		double[][] result = new double[a.length][a.length];
		result[0][0] = a[0][0] + b[0][0];
		result[0][1] = a[0][1] + b[0][1];
		result[0][2] = a[0][2] + b[0][2];
		result[1][0] = a[1][0] + b[1][0];
		result[1][1] = a[1][1] + b[1][1];
		result[1][2] = a[1][2] + b[1][2];
		result[2][0] = a[2][0] + b[2][0];
		result[2][1] = a[2][1] + b[2][1];
		result[2][2] = a[2][2] + b[2][2];
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
}