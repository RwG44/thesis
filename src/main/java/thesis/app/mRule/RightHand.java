package thesis.app.mRule;

import java.util.List;

public class RightHand {

	private List<mConsequence> consequences;
	
	public void addConsequences(mConsequence... consequences) {
		for (mConsequence consequence : consequences) {
			this.consequences.add(consequence);
		}
	}
	public RightHand() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RightHand [consequences=" + consequences + "]";
	}
	
}
