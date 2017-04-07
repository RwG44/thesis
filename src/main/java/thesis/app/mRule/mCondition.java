package thesis.app.mRule;

public class mCondition {
	private int ID;
	private String description;
	private String object;
	private String field;
	private String operator;
	private String value;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public mCondition() {
		super();
	}

	public mCondition(int iD, String description, String object, String field, String operator, String value) {
		super();
		ID = iD;
		this.description = description;
		this.object = object;
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public String toString() {
		if (field != "" && operator != "" && value != "") {
			return field + operator + value;
		} else {
			return "";
		}
	}
}