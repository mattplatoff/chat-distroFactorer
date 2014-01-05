package p13_6;

public class SalariedWorker extends Worker {

	
	public SalariedWorker(String name, int salary) {
		super(name, salary);
	}

	public int computePay(int hours) {
		
		return getSalary()*40;
	}

}
