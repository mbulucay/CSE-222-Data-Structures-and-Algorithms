
public class OfficeDesk extends Furniture{

	private final int maxModelVariety = 5;
	private final int maxColorVariety = 4;
	
	OfficeDesk(int _color,int _model,int _branchId){
		super(_color,_model,_branchId);
	}
	
	@Override
	public void setColor(int _color) {
		if(_color > maxColorVariety) {
			System.out.println("This is not a valid color number for Office Desk");
			return;
		}
		color = _color;
	}
	
	@Override
	public void setModel(int _model) {
		if(_model > maxModelVariety) {
			System.out.println("This is not a valid model number for Office Desk");
			return;
		}
		model = _model;
	}
	
	@Override
	public String toString() {
		return "Office Desk >> ModelNo > " + getModel() + "  ColorNo >" + getColor()+ " BranchId : " + getBranchId();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof OfficeDesk ))
			return false;
		
		OfficeDesk  obj = (OfficeDesk) o;
		return (obj.getModel() == this.getModel() && obj.getColor() == this.getColor());
	}
}
