//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester:01
// Year:2022
// Practical Exam Number:03
//===================================
public class PowerDrill extends PowerTool{
	//parametric constructor
	public PowerDrill(float weight, float value){
		super(weight, value, 800);
	}
	//implments useTool method in abstract class
	public void useTool(int times){
		for(int i = 0; i < times; i++){
			this.value -= 0.03f;
		}
		if(this.value < 0.0f){
			this.value = 0.0f;
		}
		System.out.println("Zssh!");
	}
}