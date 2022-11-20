//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester:01
// Year:2022
// Practical Exam Number:03
//===================================
public abstract class PowerTool extends Tool{
	int power;
	//parametric constructor
	public PowerTool(float weight, float value, int power){
		super(weight, value);
		this.power = power;
	}
	//getter
	public int getPower(){
		return this.power;
	}
}