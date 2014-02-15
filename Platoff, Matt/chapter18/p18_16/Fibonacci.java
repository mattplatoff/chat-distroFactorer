package p18_16;

public class Fibonacci {
	public static void main(String[] args) {
		int num = 9;
		System.out.println("Fibonacci for " + num + " numbers\n");
		System.out.println("Iterative solution : " + iterative(num) + "\n");
		System.out.println("Recursive Optomized soultion : "
				+ optomizedRecurzive(num) + "\n");
		System.out.println("Recursive soultion : " + recursive(num) + "\n");
	}

	public static double iterative(int num) {
		double time = System.nanoTime();
		int num1 = 0, num2 = 1;
		for (int i = 0; i < num; i++) {
			int temp = num1;
			num1 = num2;
			num2 += temp;
		}

		time = System.nanoTime() - time;
		System.out.println("Computed in: " + time + "ns");
		return num1;
	}

	public static double recursive(int num) {
		double time = System.nanoTime();

		double sol = recursiveHelper(num);

		time = System.nanoTime() - time;
		System.out.println("Computed in: " + time + "ns");
		return sol;
	}

	public static double optomizedRecurzive(int num) {
		double time = System.nanoTime();

		double[] calcNums = new double[num];
		double sol = optomizedRecursiveHelper(num, calcNums);

		time = System.nanoTime() - time;
		System.out.println("Computed in: " + time + "ns");
		return sol;
	}

	public static double optomizedRecursiveHelper(int num, double[] calculated) {
		if (num < 2)
			return num;

		else if (calculated[num - 1] != 0)
			return calculated[num - 1];
		else
			return (calculated[num - 1] = optomizedRecursiveHelper(num - 1,
					calculated) + optomizedRecursiveHelper(num - 2, calculated));
	}

	private static double recursiveHelper(int num) {
		if (num < 2)
			return num;
		else
			return recursiveHelper(num - 1) + recursiveHelper(num - 2);
	}

}