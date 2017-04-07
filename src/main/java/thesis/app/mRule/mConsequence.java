package thesis.app.mRule;

import java.lang.reflect.Field;

public class mConsequence {

	private int ID;
	private String description;
	private String object;
	private String function;
	private String value;

	
	public mConsequence() {
		super();
	}

	@Override
	public String toString() {
		if (function.toLowerCase() == "add") {
			return "addElementToList(" + object.toLowerCase() + "s, " + object + ");";
		} else if (function.toLowerCase() == "edit") {
			return "editElement(" + object.toLowerCase() + ", '" +  + "' " + object + ");";

		}
		return "editElement(" + object.toLowerCase() + ", " + object + ");";
	}
}