package thesis.app.entity;

import java.util.ArrayList;


public class Item {
	
	private int ID;	
	private String Text;
	private int Section;
	private int Position;
	
	ArrayList<Question> QuestionList;
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
	public ArrayList<Question> getQuestionList() {
		return QuestionList;
	}
	public void setQuestionList(ArrayList<Question> questionList) {
		QuestionList = questionList;
	}
	public Item(int iD, String text, int section, int position, ArrayList<Question> questionsList) {
		super();
		ID = iD;
		Text = text;
		Section = section;
		Position = position;
		QuestionList = questionsList;
	}
	
	public Item() {
		QuestionList = new ArrayList<Question>();
	}
	public int getSection() {
		return Section;
	}
	public void setSection(int section) {
		Section = section;
	}
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
}
