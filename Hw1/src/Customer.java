import java.util.Scanner;
/**<p>It is customer class each customer has unique id and 
 * furniture array to store buying product and it use datalevel3 function</p>*/
public class Customer extends Person implements CustomerAuthority{

	private int maxShopNumber = 20;
	private static int nextId = 0;
	private int CustomerId;
	private int shoppingCounter = 0;
	private String adress, phone;
	
	private CompanyDatasLevel3 DataSetForCustomer;
	
	Furniture[] shopList = null;
	
	Customer(CompanyDatasLevel3 datas,String _name, String _surname, String _email, String _password) {
		super(_name, _surname, _email, _password);
		shopList = new Furniture[maxShopNumber];
		DataSetForCustomer = datas;
		setId(nextId++);
	}

	public static void setNextId(int nextId) {
		Customer.nextId = nextId;
	}

	public int getId() {
		return CustomerId;
	}

	public void setId(int id) {
		CustomerId = id;
	}

	public int getShoppingCounter() {
		return shoppingCounter;
	}
	
	public void setAdress(String _adress) {
		adress = _adress;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setPhone(String _phone) {
		phone = _phone;
	}
	
	public String getPhone() {
		return phone;
	}
	/**<p>Add product customer shopping list</p>*/
	public boolean buyProduct(Furniture boughtFurniture) {
		
		if(shoppingCounter >= maxShopNumber) 
			enlargeFurniture();
		
		for(int i=0; i<DataSetForCustomer.currentBranchNumber; ++i) {
			if(DataSetForCustomer.branchs[i].queryProduct(boughtFurniture)) {
				DataSetForCustomer.branchs[i].removeProduct(boughtFurniture);
				shopList[shoppingCounter++] = boughtFurniture;
				
				return true;
			}	
		}
		return false;
	}
	
	/**<p>Furniture array size if full multiplication by 2</p>*/
	public void enlargeFurniture() {
		
		Furniture[] tmpF = new Furniture[maxShopNumber*2];
		for(int i=0; i<shoppingCounter; ++i)
			tmpF[i] = shopList[i];

		shopList = tmpF;		
		maxShopNumber *= 2;
	}
	/**<p>Customer making online </p>*/
	public void onlineShopping(Furniture f) {
		
		Scanner scan = new Scanner(System.in);
		String str;

		System.out.println("Enter the adress :");
		str = scan.nextLine();
		setAdress(str);
		System.out.println("Enter the phone number");
		str = scan.nextLine();
		setPhone(str);
		buyProduct(f);
	}
	/**<p>Customer using linear search in all branch furniture</p>*/
	public Branch queryProduct(Furniture obj) {
		return DataSetForCustomer.queryProduct(obj);
	}
	/**<p>Printing  all buying products</p>*/
	public void displayShoppingList() {
		
		System.out.println(getName() + " " + getSurname() + " shopping list :" );
		for(int i=0;i <shoppingCounter; ++i) 
			System.out.println(i +". "+ shopList[i]);
	}
	
	@Override
	/**<p>If customer id is equal that means they are equal</p>*/
	public boolean equals(Object o) {
	
		if(!(o instanceof Customer))
			return false;
		
		Customer  obj = (Customer) o;
		return obj.getId() == this.getId();
	}
	
	@Override 
	public String toString() {
		return getName() + " " + getSurname() + " Customer Id: " + getId();
	}
	
}
