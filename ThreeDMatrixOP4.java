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
		// 计算L0范数
		int l0 = L0(m1);
		// 计算L1范数
		double l1 = L1(m1);
		// 计算L2范数
		double l2 = L2(m1);
		// 计算L3范数
		double l3 = L3(m1);
		// 计算四范数之平均值，输出结果
		double res = average(l0, l1, l2, l3);
		System.out.println(res);
	}

	// 计算L0范数。此处定义L0范数为所有元素中绝对值大于等于0.75的个数
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

	// 计算L1范数。L1范数为所有元素绝对值之和
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

	// 计算L2范数。L2范数为所有元素平方和的开平方数，即欧氏距离
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

	// 计算L3范数。L3范数为所有元素立方和的立方根
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

	// 计算L0, L1, L2, L3范数之和，取平均数
	public static double average(int l0, double l1, double l2, double l3) {
		double result = 0.0;
		result = result + (double) l0;
		result = result + l1 + l2 + l3;
		result = result / 4.0;
		return result;
	}
}