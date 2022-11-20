//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester:01
// Year:2022
// Practical Exam Number:03
//===================================
public abstract class HandTool extends Tool{
	boolean sharp;
	//parametric constructor
	public HandTool(float weight, float value, boolean sharp){
		super(weight, value);
		this.sharp = sharp;
	}
	//like getter
	public boolean isSharp(){
		return this.sharp;
	}
}