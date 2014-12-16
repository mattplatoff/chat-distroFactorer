package distributedFactor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Scanner;

public class ClientManager {
	private Socket s;
	private int startNum;
	private InputStream is;
	private OutputStream os;
	private Scanner in;
	private PrintWriter out;
	private BigInteger toFactor;
	private static int clientNum = 0;
	private int cnum;

	public ClientManager(Socket s, BigInteger toFactor) throws IOException {
		clientNum++;
		// sets the client number for this client
		cnum = clientNum;
		this.s = s;
		this.toFactor = toFactor;
		is = s.getInputStream();
		os = s.getOutputStream();
		in = new Scanner(is);
		out = new PrintWriter(os);
	}

	public void service() {
		// sends the number to be factored and the client number
		out.print(toFactor.toString() + "\n" + cnum);
		out.flush();
		// waits for one of the clients to return the factors and then closes
		// the socket
		while (true) {
			if (in.hasNext()) {
				System.out.println("the factors are " + in.nextLine());
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
