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
		// 计算L0范数
		int l0 = L0(m1);
		// 计算L1范数
		double l1 = L1(m1);
		// 计算L2范数
		double l2 = L2(m1);
		// 计算LK范数
		double lk = LK(m1, k);
		// 计算四范数之平均值，输出结果
		double res = average(l0, l1, l2, lk);
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

	// 计算LK范数。此处定义LK范数为所有元素K次方和的三次根。在计算K次方和时，采用累加的形式。每次累加都会对100000007取余，防止溢出
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

	// 计算L0, L1, L2, LK范数之和，取平均数
	public static double average(int l0, double l1, double l2, double lk) {
		double result = 0.0;
		result = result + (double) l0;
		result = result + l1 + l2 + lk;
		result = result / 4.0;
		return result;
	}
}