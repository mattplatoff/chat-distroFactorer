package p13_6;

public abstract class Worker {
private String name;
private int salary;

public Worker(String name,int salary){
	this.name=name;
	this.salary=salary;
}
public String getName() {
	return name;
}

public int getSalary() {
	return salary;
}

public abstract int computePay(int hours);
}
