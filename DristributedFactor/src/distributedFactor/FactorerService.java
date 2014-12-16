package distributedFactor;

import java.math.BigInteger;
import java.util.ArrayList;

public class FactorerService implements Runnable {
	BigInteger num, count, range, number;
	static BigInteger numOfThreads = BigInteger.ZERO;
	static int tNum, tcount = 0, cNum;
	static boolean found = false;
	static ArrayList<BigInteger> factors = null;

	public FactorerService(BigInteger n, int clientNum) {
		num = n;
		count = BigInteger.valueOf(3);
		numOfThreads = numOfThreads.add(BigInteger.ONE);
		cNum = clientNum;
		tcount++;
		// increases the thread count by four for every client already connected
		tcount += (4 * cNum);
		tNum = tcount;
		number = numOfThreads;
		range = BigInteger.valueOf(((tNum * 2) + 3) - 2);

	}

	public void run() {

		while (!num.mod(range).equals(BigInteger.ZERO)
				&& range.doubleValue() < num.doubleValue() / 2 && !found) {
			range = range.add(BigInteger.valueOf(2 * tcount));
		}
		found = true;
		if (num.mod(range).equals(BigInteger.ZERO)) {
			factors.add(range);
			factors.add(num.divide(range));
			System.out.println(range + "  " + num.divide(range).toString());
		}

	}

	public ArrayList<BigInteger> getFactors() {
		return factors;
	}

}
