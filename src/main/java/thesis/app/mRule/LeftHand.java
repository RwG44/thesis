package thesis.app.mRule;


import java.util.ArrayList;
import java.util.List;

public class LeftHand {
//	private mCondition areaCondition;
//	private mCondition stypeCondition;
//	private mCondition objectCondition;
//	private mCondition casingCondition;
	private List<mCondition> factorCondition;
	private mCondition itemCondition;
	private mCondition queCondition;
	private mCondition optCondition;

//	public mCondition getAreaCondition() {
//		return areaCondition;
//	}
//
//	public void setAreaCondition(mCondition areaCondition) {
//		this.areaCondition = areaCondition;
//	}
//
//	public mCondition getStypeCondition() {
//		return stypeCondition;
//	}
//
//	public void setStypeCondition(mCondition stypeCondition) {
//		this.stypeCondition = stypeCondition;
//	}
//
//	public mCondition getObjectCondition() {
//		return objectCondition;
//	}
//
//	public void setObjectCondition(mCondition objectCondition) {
//		this.objectCondition = objectCondition;
//	}
//
//	public mCondition getCasingCondition() {
//		return casingCondition;
//	}
//
//	public void setCasingCondition(mCondition casingCondition) {
//		this.casingCondition = casingCondition;
//	}

	public mCondition getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(mCondition itemCondition) {
		this.itemCondition = itemCondition;
	}

	public mCondition getQueCondition() {
		return queCondition;
	}

	public void setQueCondition(mCondition queCondition) {
		this.queCondition = queCondition;
	}

	public mCondition getOptCondition() {
		return optCondition;
	}

	public void setOptCondition(mCondition optCondition) {
		this.optCondition = optCondition;
	}

	public LeftHand() {
		// TODO Auto-generated constructor stub
		factorCondition = new ArrayList<mCondition>();
	}

	public LeftHand(mCondition itemCondition, mCondition queCondition, mCondition optCondition,
			List<mCondition> factorCondition) {
		super();
		this.itemCondition = itemCondition;
		this.queCondition = queCondition;
		this.optCondition = optCondition;
		this.factorCondition = factorCondition;
	}

	@Override
	public String toString() {
		// StringBuilder out = new StringBuilder();
		// Environement conditons
		String out = "";
		out = out + "env: Factor(";

		for (mCondition mCondition : factorCondition) {
			out = out + mCondition.toString() + ", ";		
		}
		//delete the last ","
		if (out.endsWith(", ")) {
			out.substring(0, out.length() - 2);
		}

		out = out + ") /n";


		// Access options
		if (optCondition != null) {
			out = out + " qn: Questionaire(items: ItemList) \n";
			out = out + " item: Item(" + itemCondition != null ? itemCondition.toString() + ", "
					: "" + "questions: QuestionList) from items \n";
			out = out + " question: Question(" + queCondition != null ? queCondition.toString() + ", "
					: "" + "options: OptionList) from questions \n";
			out = out + " option: Option(" + optCondition.toString() + ") from options \n";
		} 
		// Access question
		else if (queCondition != null) {
			out = out + " qn: Questionaire(items: ItemList) \n";
			out = out + " item: Item(" + itemCondition != null ? itemCondition.toString() + ", "
					: "" + "questions: QuestionList) from items \n";
			out = out + " question: Question(" + queCondition.toString() + ", options: OptionList) from questions \n";
		}
		// Access items
		else if (itemCondition != null) {
			out = out + " qn: Questionaire(items: ItemList) \n";
			out = out + " item: Item(" + itemCondition.toString() + ", questions: QuestionList) from items \n";
		}
		// Aceess from top level
		else {
			out = out + " qn: Questionaire(items: ItemList) \n";
		}

		return out.toString();

	}
}
