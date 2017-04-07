package thesis.app.entity;

public class Factor {

	int Area;
	int Stype;
	int Object;
	int Casing;
	
	public int getArea() {
		return Area;
	}

	public void setArea(int area) {
		Area = area;
	}

	public int getStype() {
		return Stype;
	}

	public void setStype(int stype) {
		Stype = stype;
	}

	public int getObject() {
		return Object;
	}

	public void setObject(int object) {
		Object = object;
	}

	public int getCasing() {
		return Casing;
	}

	public void setCasing(int casing) {
		Casing = casing;
	}

	public Factor() {
		// TODO Auto-generated constructor stub		
	}

	public Factor(int area, int stype, int object, int casing) {
		super();
		Area = area;
		Stype = stype;
		Object = object;
		Casing = casing;
	}
	

}
