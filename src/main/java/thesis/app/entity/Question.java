package thesis.app.entity;

import java.util.ArrayList;

public class Question {
	
	private int ID;	
	private String Text;
	private int Qtype;
	private int Position;
	private ArrayList<Option> OptionList;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	
	public int getQtype() {
		return Qtype;
	}
	public void setQtype(int qtype) {
		Qtype = qtype;
	}
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
	public ArrayList<Option> getOptionList() {
		return OptionList;
	}
	public void setOptionList(ArrayList<Option> optionList) {
		OptionList = optionList;
	}
	
	public Question(int iD, String text, int qtype, int position, ArrayList<Option> optionList) {
		super();
		ID = iD;
		Text = text;
		Qtype = qtype;
		Position = position;
		OptionList = optionList;
	}
	public Question() {
		OptionList = new ArrayList<Option>();
	}
	
}
