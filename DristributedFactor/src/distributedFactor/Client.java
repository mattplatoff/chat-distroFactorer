package distributedFactor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	private final static int PORT = 8888;
	private static BigInteger numToFactor;
	private static int numOfClients;
	private static ArrayList<Thread> tList;

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket s = new Socket("127.0.0.1", PORT);
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		Scanner in = new Scanner(is);
		PrintWriter out = new PrintWriter(os);
		// gets the string representation of the BigInt, should change this so
		// it gets an arraylist and then has the start num and the bigInt
		String BIString = in.nextLine();
		String intString = in.nextLine();
		numOfClients = Integer.parseInt(intString);
		System.out.println(BIString);
		numToFactor = new BigInteger(BIString);
		// creates new FactorerService with numToFactor and StartNum provided by
		// the server
		FactorerService fs = new FactorerService(numToFactor, numOfClients);
		// adds four threads to the arraylist
		for (int x = 0; x < 4; x++)
			tList.add(new Thread(fs));
		// starts all threads
		for (Thread t : tList)
			t.start();
		// waits until the factors are found by one of the threads
		while (fs.getFactors() == null) {
		}
		// determines if the factors were found and if they were, prints them to
		// the output stream
		if (fs.getFactors() != null) {
			out.print(fs.getFactors().get(0).toString() + "   "
					+ fs.getFactors().get(1).toString());
			out.flush();
		}
		s.close();
		in.close();
		out.close();
		os.close();
		is.close();

	}

}
