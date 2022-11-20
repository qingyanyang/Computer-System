/*
*   Foundations of Computer Science
*   2022, Semester 01
*   Practical-Exam-04
*
*   student (id): a1865304
*   student (name): Qingyan Yang
*
* Note: your are required to perform small changes, as accessors and mutators;
*
*/
public class Employee extends Person{
	protected int hoursPerWeek;
	protected float dollarsPerHours;
	protected int workedYears;

	Employee(){
		this.name = "new-employee";
		this.hoursPerWeek = 0;
		this.dollarsPerHours = 0f;
		this.workedYears = 0;
	}
	Employee(String name, int age, int hoursPerWeek, float dollarsPerHours, int workedYears){
		this.name = name;
		this.age = age;
		this.hoursPerWeek = hoursPerWeek;
		this.dollarsPerHours = dollarsPerHours;
		this.workedYears = workedYears;
	}

	public void display(){
		int field = 8;
		String ans = ":: ";
		ans += this.name;
		ans += String.format("% "+ (30 - this.name.length()) + "d", this.age);
		ans += String.format("%8d", this.hoursPerWeek);
		ans += String.format("%10.1f", this.dollarsPerHours);
		ans += String.format("%8d", this.workedYears);
		System.out.println(ans);

	}

	/* implement accessors and mutators */

	public int getHoursPerWeek(){
		return this.hoursPerWeek;
	}

	public float getDollarsPerHours(){
		return this.dollarsPerHours;
	}
	public int getWorkedYears(){
		return this.workedYears;
	}
	public void setHoursPerWeek(int hoursPerWeek){
		this.hoursPerWeek = hoursPerWeek;
	}
	public void setDollarsPerHours(float dollarsPerHours){
		this.dollarsPerHours = dollarsPerHours;
	}

	public void setWorkedYears(int workedYears){
		this.workedYears = workedYears;
	}
}