
public class OfficeCabinet extends Furniture{
	
	private final int maxModelVariety = 12;
	private final int maxColorVariety = 1;
	
	OfficeCabinet(int _color,int _model,int _branchId){
		super(_color,_model,_branchId);
	}
	
	@Override
	public void setColor(int _color) {
		if(_color  > maxColorVariety) {
			System.out.println("This is not a valid color for a Office Cabinets");
			return;
		}
		color = _color;
	}
	
	@Override
	public void setModel(int _model) {
		if(_model > maxModelVariety) {
			System.out.println("This is not a valid model for a Office Cabinets");
			return;
		}
		model = _model;
	}
	
	@Override
	public String toString() {
		return "Office Cabinets >> ModelNo > " + getModel() + "  ColorNo >" + getColor() + " BranchId : " + getBranchId();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof OfficeCabinet))
			return false;
		
		OfficeCabinet obj = (OfficeCabinet) o;
		return (obj.getModel() == this.getModel() && obj.getColor() == this.getColor());
	}
}
