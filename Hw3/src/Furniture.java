/**<p>It is base class for wanted product and 
 * it keeps comman datas like model ,color and 
 * branch id for the product is which store</p>*/
public abstract class Furniture{

	protected int color;
	protected int model;
	protected int branchId;
	
	Furniture(int _color,int _model,int _branchId){
		setColor(_color);
		setModel(_model);
		setBranchId(_branchId);
	}
	/**<p>This is common function for returning model</p>*/
	public int getModel(){
		return model;
	}
	/**<p>Every furniture has unique limit for model that means each furniture has different condition in function</p>*/
	public abstract void setModel(int _model);
	/**<p>This is common function for returning color</p>*/
	public int getColor() {
		return color;
	}
	/**<p>Every furniture has unique limit for color that means each furniture has different condition in function</p>*/
	public abstract void setColor(int _color);
	/**<p>This is common function for setting id</p>*/
	public void setBranchId(int _branchId) {
		branchId = _branchId;
	}
	/**<p>This is common function for getting id</p>*/
	public int getBranchId() {
		return branchId;
	}
}
