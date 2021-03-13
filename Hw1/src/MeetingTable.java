
public class MeetingTable extends Furniture{
	
	private final int maxModelVariety = 10;
	private final int maxColorVariety = 4;
	
	MeetingTable(int _color,int _model,int _branchId){
		super(_color,_model,_branchId);
	}
	
	@Override
	public void setColor(int _color) {
		if(_color > maxColorVariety) {
			System.out.println("This is not a valid color for a Meeting Table");
			return;
		}
		color = _color;
	}
	
	@Override
	public void setModel(int _model) {
		if(_model > maxModelVariety) {
			System.out.println("This is not a valid model for a Meeting Table");
			return;
		}
		model = _model;
	}
	
	@Override
	public String toString() {
		return "Meeting Table >> ModelNo > " + getModel() + "  ColorNo >" + getColor() + " BranchId : " + getBranchId();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof MeetingTable))
			return false;
		
		MeetingTable obj = (MeetingTable) o;
		return (obj.getModel() == this.getModel() && obj.getColor() == this.getColor());
	}
}
