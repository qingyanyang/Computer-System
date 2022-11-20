//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester:01
// Year:2022
// Practical Exam Number:03
//===================================
public class Hammer extends HandTool{
	//parametric constructor
	public Hammer(float weight, float value){
		super(weight, value, false);
	}
	//implments useTool method in abstract class
	public void useTool(int times){
		for(int i = 0; i < times; i++){
			this.value -= 0.01f;
		}
		if(this.value < 0.0f){
			this.value = 0.0f;
		}
		System.out.println("Bang!");
	}
}