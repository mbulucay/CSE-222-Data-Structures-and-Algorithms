
public class OfficeChair extends Furniture{

	private final int maxModelVariety = 7;
	private final int maxColorVariety = 5;
	
	OfficeChair(int _color,int _model,int _branchId) {
		super(_color,_model,_branchId);
	}

	@Override
	public void setModel(int _model) {
		if(_model > maxModelVariety) {
			System.out.println("This is not a valid model number for Office chair");
			return;
		}
		model = _model;
	}
	
	@Override
	public void setColor(int _color) {
		if(_color > maxColorVariety) {
			System.out.println("This is not a valid color number for a Office chair");
			return;
		}
		color = _color;
	}
	
	@Override
	public String toString() {
		return "Office Chair >> ModelNo > " + getModel() + "  ColorNo >" + getColor() + " BranchId : " + getBranchId();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof OfficeChair ))
			return false;
		
		OfficeChair  obj = (OfficeChair ) o;
		return (obj.getModel() == this.getModel() && obj.getColor() == this.getColor());
	}
}