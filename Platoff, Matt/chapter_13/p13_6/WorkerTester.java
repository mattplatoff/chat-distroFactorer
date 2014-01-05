package p13_6;

public class WorkerTester {

	public static void main(String[] args) {
		Worker mark=new SalariedWorker("mark",9);
		Worker jake = new HourlyWorker("jake",10);
		System.out.println(mark.computePay(30) +"\n"+jake.computePay(50)+"\n"+ jake.computePay(30));
	}

}
