package thesis.app.entity;

public class Option {
	private int ID;	
	private String Text;	
	private int Position;
		
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

	public int getPosition() {
		return Position;
	}


	public void setPosition(int position) {
		Position = position;
	}


	public Option(int iD, String text, int position) {
		super();
		ID = iD;
		Text = text;
		Position = position;
	}


	public Option() {
		// TODO Auto-generated constructor stub
	}

}
