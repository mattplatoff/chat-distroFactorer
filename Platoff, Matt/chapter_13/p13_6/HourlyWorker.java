package p13_6;

public class HourlyWorker extends Worker {

	public HourlyWorker(String name, int salary) {
		super(name, salary);
		
	}

	@Override
	public int computePay(int hours) {
		if (hours>40)
			
		return (int) (super.getSalary()*(hours-40)*1.5)+getSalary()*40;
		else 
			return super.getSalary()*hours;
	}

}
