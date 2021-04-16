
public class Bookcases extends Furniture{

	private final int maxModelVariety = 12;
	private final int maxColorVariety = 1;
	
	Bookcases(int _color, int _model,int _brancId) {
		super(_color, _model,_brancId);
	}

	@Override
	public void setModel(int _model) {
		if(_model > maxModelVariety) {
			System.out.println("This is not a valid model for a Bookcases");
			return;
		}
		model = _model;
	}

	@Override
	public void setColor(int _color) {
		if(_color > maxColorVariety) {
			System.out.println("This is not a valid color for a Bookcases");
			return;
		}
		color = _color;
	}
	
	@Override
	public String toString() {
		return "Bookcases >> ModelNo > " + getModel() + "  ColorNo >" + getColor() + " BranchId : " + getBranchId();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof Bookcases))
			return false;
		
		Bookcases obj = (Bookcases) o;
		return (obj.getModel() == this.getModel() && obj.getColor() == this.getColor());
	}
}
