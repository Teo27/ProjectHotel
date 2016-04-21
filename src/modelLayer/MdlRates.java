package modelLayer;

public class MdlRates {

	private String name;
	private boolean breakfast;
	private boolean lunch;
	private boolean dinner;
	
	public MdlRates(){
		
	}
	
	public MdlRates(String name, boolean  breakfast, boolean lunch, boolean dinner){
		
		this.name = name;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}

	public String getName() {
		return name;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public boolean isLunch() {
		return lunch;
	}

	public boolean isDinner() {
		return dinner;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public void setLunch(boolean lunch) {
		this.lunch = lunch;
	}

	public void setDinner(boolean dinner) {
		this.dinner = dinner;
	}
	
	
}
