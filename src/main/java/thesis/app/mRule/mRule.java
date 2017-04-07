package thesis.app.mRule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mRule {
	private int ID;
	private String name;
	private String description;
	private int salience;
	
	private List<mConsequence> consequences;


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSalience() {
		return salience;
	}

	public void setSalience(int salience) {
		this.salience = salience;
	}

	
	

	public mRule() {
		consequences = new ArrayList<mConsequence>();
		// TODO Auto-generated constructor stub
	}


	public mRule(int iD, String name, String description, int salience) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		this.salience = salience;
	}

	@Override
	public String toString() {
		
		File file = new File("src/main/resources/rules/rule-template.drl");
		FileInputStream fis;
		String str = null;
		try {
			fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			str = new String(data, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		//Replace the condition 
//		for (mCondition condition : conditions) {
//			//System.out.println("@{" + condition.getName() + "}");
//			str = str.replace("@{" + condition.getName() + "}", condition.getContent());
//		}
//
//		for (mConsequence consequence : consequences) {
//			//System.out.println("@{" + consequence.getName() + "}");
//			str = str.replace("@{" + consequence.getName()+ "}", consequence.getContent());
//		}
		str = str.replace("@{ID}", String.valueOf(ID));
		
		return str;
	}
}