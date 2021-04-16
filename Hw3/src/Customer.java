import java.util.Scanner;

/**<p>It is customer class each customer has unique id and 
 * furniture array to store buying product and it use datalevel3 function</p>*/
public class Customer extends Person implements CustomerAuthority{

	private static int nextId = 0;
	private int CustomerId;
	private String adress, phone;
	private HybridList<Furniture> shopList;
	private DATA customerData;
	
	Customer(DATA d,String _name, String _surname, String _email, String _password) {
		super(_name, _surname, _email, _password);
		shopList = new HybridList<>();
		customerData = d;
		setId(nextId++);
	}

	public int getId() {
		return CustomerId;
	}

	public void setId(int id) {
		CustomerId = id;
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
	
    /**<p>Customer using linear search in all branch furniture</p>*/
    public Branch queryProduct(Furniture obj) {
        return customerData.queryProduct(obj);
    }
	
	/**<p>Add product customer shopping list</p>*/
	public boolean buyProduct(Furniture bF) {
		return shopList.add(bF);
	}
	
	/**<p>Printing  all buying products</p>*/
	public void displayShoppingList() {
		System.out.println(getName() + " " + getSurname() + " shopping list :" );
		System.out.println(shopList);
	}
	
	/**<p>Display all product in all store</p>*/
	public void displayProducts() {
		customerData.displayProducts();
	}
	
	/**<p>Customer make online shop entering address and phone</p>*/
	public void onlineShopping() {
		
		Scanner scan = new Scanner(System.in);
		String _adress = new String();
		String _phone = new String();
		
		System.out.println("Enter adress :");
		_adress = scan.nextLine();
		System.out.println("Enter phone :");
		_phone = scan.nextLine();
		
		adress = _adress;
		phone = _phone;
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
		return "Name: " + getName() + " Surname: " + getSurname() + " Customer Id: " + getId();
	}

	
	
}
