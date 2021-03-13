import java.util.NoSuchElementException;
import java.util.Scanner;
/**<p>Starting class for automation system</p>*/
public class Main {
	
	static Automation Mysytem = new Automation();
	/**<p>Start the execution for drive cod and menu system</p>*/
	public static void main(String[] args) {
		Scanner menuScanner = new Scanner(System.in);
		int operation;
		while(true) {
			try {
			System.out.println("\nWelcome The Funiture Company Automation");
			System.out.println("1-> Start Program Menu");
			System.out.println("2-> Start Driver Code");
			System.out.println("0-> Close the program");
			System.out.println("Enter the operation: ");
			operation = Integer.parseInt(menuScanner.nextLine());
			
			if(operation == 1)
				Mysytem.Runner();
			else if(operation == 0){
				return;			
			}
			else if(operation == 2){
				CompanyDatasLevel1 datas = new CompanyDatasLevel1();
				
				Admin admin = new Admin(datas,"a","a","a","a");
				
				System.out.println("Admin creating : " + admin +" Email: " +admin.getEmail() + " password: " + admin.getPassword());
				
				System.out.println("Create four branch");
				
				Branch br1 = new Branch("br1");
				Branch br2 = new Branch("br2");
				Branch br3 = new Branch("br3");
				Branch br4 = new Branch("br4");
				admin.addBranch(br1);
				admin.addBranch(br2);
				admin.addBranch(br3);
				admin.addBranch(br4);
				
				admin.displayBranchs();
				
				System.out.println("Add three employee for each branch");
				
				Employee emp1 = new Employee(datas,br1, "e1", "e1", "e1", "e1");
				admin.addEmployee(br1, emp1);
				Employee emp2 = new Employee(datas,br1, "e2", "e2", "e2", "e2");
				admin.addEmployee(br1, emp2);
				Employee emp3 = new Employee(datas,br1, "e3", "e3", "e3", "e3");
				admin.addEmployee(br1, emp3);
				Employee emp4 = new Employee(datas,br2, "e4", "e4", "e4", "e4");
				admin.addEmployee(br2, emp4);
				Employee emp5 = new Employee(datas,br2, "e5", "e5", "e5", "e5");
				admin.addEmployee(br2, emp5);
				Employee emp6 = new Employee(datas,br2, "e6", "e6", "e6", "e6");
				admin.addEmployee(br2, emp6);
				Employee emp7 = new Employee(datas,br3, "e7", "e7", "e7", "e7");
				admin.addEmployee(br3, emp7);
				Employee emp8 = new Employee(datas,br3, "e8", "e8", "e8", "e8");
				admin.addEmployee(br3, emp8);
				Employee emp9 = new Employee(datas,br3, "e9", "e9", "e9", "e9");
				admin.addEmployee(br3, emp9);
				Employee emp10 = new Employee(datas,br4, "e10", "e10", "e10", "e10");
				admin.addEmployee(br4, emp10);
				Employee emp11 = new Employee(datas,br4, "e11", "e11", "e11", "e11");
				admin.addEmployee(br4, emp11);
				Employee emp12 = new Employee(datas,br4, "e12", "e12", "e12", "e12");
				admin.addEmployee(br4, emp12);
				
				System.out.println("Display current employees ");
				for(int i = 0; i<admin.getBranchNumber(); ++i) {
					System.out.println("Branch name : " + admin.getBranch(i).getName());
					System.out.println("   Employess:");
					admin.getBranch(i).displayEmployees();
				}
				System.out.println("=====================================");
				System.out.println("Remove e10 and e12 employee");
				admin.removeEmployee(br4, emp10);
				admin.removeEmployee(br4, emp12);
				
				System.out.println("Branch 4");
				br4.displayEmployees();
				
				System.out.println("Remove br2");
				admin.removeBranch(br2);
				admin.displayBranchs();
				
				System.out.println("Admin mail box about out of stock\n");
				
				admin.displayMessages();
				
				System.out.println("We will call it again when the employee send message and query when we add the furnitures");
				
				System.out.println("\n////////////////////////////////////////////////////////////\n");
			
				System.out.println("e1 add some Furniture : ");
				
				emp1.addProduct(new OfficeChair(0,1,br1.getId()));
				emp1.addProduct(new OfficeChair(2,4,br1.getId()));
				emp1.addProduct(new OfficeChair(1,3,br1.getId()));
				emp1.addProduct(new OfficeChair(4,6,br1.getId()));
				
				emp1.addProduct(new OfficeDesk(0,1,br1.getId()));
				emp1.addProduct(new OfficeDesk(2,1,br1.getId()));
				emp1.addProduct(new OfficeDesk(3,3,br1.getId()));
				emp1.addProduct(new OfficeDesk(3,4,br1.getId()));
				
				emp1.addProduct(new MeetingTable(0,1,br1.getId()));
				emp1.addProduct(new MeetingTable(2,6,br1.getId()));
				emp1.addProduct(new MeetingTable(3,8,br1.getId()));
				emp1.addProduct(new MeetingTable(1,4,br1.getId()));
				
				emp1.addProduct(new Bookcases(0,3,br1.getId()));
				emp1.addProduct(new Bookcases(0,6,br1.getId()));
				emp1.addProduct(new Bookcases(0,8,br1.getId()));
				emp1.addProduct(new Bookcases(0,10,br1.getId()));
				
				emp1.addProduct(new OfficeCabinet(0,4,br1.getId()));
				emp1.addProduct(new OfficeCabinet(0,7,br1.getId()));
				emp1.addProduct(new OfficeCabinet(0,3,br1.getId()));
				emp1.addProduct(new OfficeCabinet(0,11,br1.getId()));
				
				System.out.println("e1.displayProducts() : ");
				
				emp1.displayProducts();
				
				Customer c = new Customer(datas,"c","c","c","c");
				datas.addCustomer(c);
				System.out.println("A customer buy some furniture");
				
				c.buyProduct(new OfficeChair(0,1,br1.getId()));
				c.buyProduct(new OfficeChair(1,3,br1.getId()));
				c.buyProduct(new OfficeDesk(3,3,br1.getId()));
				c.buyProduct(new Bookcases(0,6,br1.getId()));
				c.buyProduct(new OfficeCabinet(0,7,br1.getId()));
				c.buyProduct(new OfficeCabinet(0,11,br1.getId()));
				
				System.out.println("Customer buyed these :");
				c.displayShoppingList();
				
				System.out.println("\nemp displayProduct in store");
				emp1.displayProducts();
				
				System.out.println("If customer wants to buy dont exist product:");
				boolean buyed = c.buyProduct(new Bookcases(0, 11, br1.getId()));
				
				if(buyed == false) {
					System.out.println("We dont have that product");
				}
				
				System.out.println("\nEmployee sell some exsiting furniture");
				emp1.sellProduct(new OfficeDesk(3,4,br1.getId()), c);
				emp1.sellProduct(new Bookcases(0,10,br1.getId()), c);
				emp1.sellProduct(new OfficeChair(4,6,br1.getId()), c);
				
				System.out.println("\nemp see shop list of customer");
				emp1.displayCustomerList(c.getId());
				
				System.out.println("\nSee branch product list ");
				emp1.displayProducts();
			
				System.out.println("\nemployee query product");
				System.out.println("emp1.queryProduct(new MeetingTable(0,1,br1.getId())) : " + emp1.queryProduct(new MeetingTable(0,1,br1.getId())));
				System.out.println("emp1.queryProduct(new Bookcases(0,10,br1.getId())) : " + emp1.queryProduct(new Bookcases(0,10,br1.getId())));
				
				System.out.println("\ncustomer query product");
				System.out.println("c.queryProduct(new MeetingTable(0,1,br1.getId())) :" +  c.queryProduct(new MeetingTable(0,1,br1.getId())));
				System.out.println("c.queryProduct(new Bookcases(0,10,br1.getId())) :" +  c.queryProduct(new Bookcases(0,10,br1.getId())));
				
				System.out.println("\nsend message to admin out of stock : new MeetingTable(0,1,br1.getId())");
				emp1.sendMessageToAdmin(new MeetingTable(0,1,br1.getId()) + "out of stock\n");
				System.out.println("message sended");
			
				System.out.println("\nAdmin read message");
				Admin.displayMessages();
				
				System.out.println("\nAdmin and customer can reach all branch furniture n\but employee can reach just own branch");
				System.out.println("Emp branch furniture");
				System.out.println("Branch 1 furnitutures");
				br1.displayProducts();
				br3.addProduct(new Bookcases(0,6,br2.getId()));
				System.out.println("\nBranch 3 furnitures");
				br3.displayProducts();
				
				System.out.println("\nemployyee work branch 1");
				System.out.println( "emp1.queryProduct(new Bookcases(0,6,br2.getId())) :"
				+ emp1.queryProduct(new Bookcases(0,6,br3.getId())));
				
				System.out.println("\nadmin.queryProduct(new Bookcases(0,6,br2.getId())) :" 
				+ admin.queryProduct(new Bookcases(0,6,br3.getId())));
				
				System.out.println("\nc.queryProduct(new Bookcases(0,6,br2.getId())) :" 
				+ (c.queryProduct(new Bookcases(0,6,br3.getId())) == null ? false : true));
			
				System.out.println("\nEmployee remove :");
				System.out.println("Before Remove : ");
				emp1.displayProducts();
				
				emp1.getBranch().removeProduct(new MeetingTable(3,8,br1.getId()));
				emp1.getBranch().removeProduct(new MeetingTable(1,4,br1.getId()));
				emp1.getBranch().removeProduct(new OfficeDesk(2,1,br1.getId()));
				System.out.println("After remove :");
				emp1.displayProducts();
				
				System.out.println("\nEmployee sell :");
				Customer c2 = new Customer(datas, "c2", "c2", "c2", "c2");
				System.out.println("Before sell");
				emp1.displayProducts();
				
				datas.addCustomer(c2);
				emp1.sellProduct(new OfficeDesk(0,1,br1.getId()), c2);
				emp1.sellProduct(new MeetingTable(0,1,br1.getId()), c2);
				emp1.sellProduct(new OfficeCabinet(0, 4, br1.getId()), c2);
				emp1.sellProduct(new Bookcases(0, 3, br1.getId()), c2);
				emp1.sellProduct(new OfficeChair(2, 4, br1.getId()), c2);
			
				System.out.println("After sell");
				emp1.displayProducts();
				System.out.println("see customer list:");
				c2.displayShoppingList();
				
				
				System.out.println("Customer See product in all branch :");
				datas.displayProducts();
				
				System.out.println("\nBranch Functions :");
				br3.addProduct(new OfficeChair(0,1,br1.getId()));
				br3.addProduct(new OfficeChair(2,4,br1.getId()));
				br3.addProduct(new OfficeChair(1,3,br1.getId()));
				br3.addProduct(new OfficeChair(4,6,br1.getId()));
				
				br3.addProduct(new OfficeDesk(0,1,br1.getId()));
				br3.addProduct(new OfficeDesk(2,1,br1.getId()));
				br3.addProduct(new OfficeDesk(3,3,br1.getId()));
				br3.addProduct(new OfficeDesk(3,4,br1.getId()));
				
				br3.addProduct(new MeetingTable(0,1,br1.getId()));
				br3.addProduct(new MeetingTable(2,6,br1.getId()));
				br3.addProduct(new MeetingTable(3,8,br1.getId()));
				br3.addProduct(new MeetingTable(1,4,br1.getId()));
				
				br3.addProduct(new Bookcases(0,3,br1.getId()));
				br3.addProduct(new Bookcases(0,6,br1.getId()));
				br3.addProduct(new Bookcases(0,8,br1.getId()));
				br3.addProduct(new Bookcases(0,10,br1.getId()));
				
				br3.addProduct(new OfficeCabinet(0,4,br1.getId()));
				br3.addProduct(new OfficeCabinet(0,7,br1.getId()));
				br3.addProduct(new OfficeCabinet(0,3,br1.getId()));
				br3.addProduct(new OfficeCabinet(0,11,br1.getId()));
				
				Employee br3emp1 = new Employee(datas, br3,"br3emp1" , "br3emp1", "br3emp1", "br3emp1");
				br3.addEmployee(br3emp1);
				
				System.out.println("Product and br3emp1 added (br3.addEmployee(br3emp1);)  &\n br3.addProduct(new OfficeCabinet(0,4,br1.getId()));");
				
				System.out.println("Branch Name : " + br3.getName());
				br3.displayEmployees();
				br3.displayProducts();
				
				System.out.println("\nQuery product br3.queryProduct(new OfficeCabinet(0,7,br1.getId())); :" 
								+ br3.queryProduct(new OfficeCabinet(0,7,br1.getId())));
				System.out.println("\nAfter remove some furniture and br3emp1: ");
				br3.removeEmployee(br3emp1);
				br3.removeProduct(new OfficeChair(2,4,br1.getId()));
				br3.removeProduct(new OfficeDesk(2,1,br1.getId()));
				br3.removeProduct(new MeetingTable(2,6,br1.getId()));
				br3.removeProduct(new Bookcases(0,6,br1.getId()));
				br3.removeProduct(new OfficeCabinet(0,7,br1.getId()));
				
				System.out.println("After removing : ");
				System.out.println("Branch Name : " + br3.getName());
				br3.displayEmployees();
				br3.displayProducts();
				System.out.println();
				
				System.out.println("\nGet Furniture function return furnitures as array which it has:");
				Furniture[] farr = br3.getFurniture();
				for(Furniture f : farr) {
					if(f == null)
						break;
					System.out.println(f);
				}
				
				System.out.println("\nRemove product using index, 2 ,4 , 6 ,9, 11");
				br3.removeProduct(2);
				br3.removeProduct(4);
				br3.removeProduct(6);
				br3.removeProduct(9);
				br3.removeProduct(11);
				br3.displayProducts();
				
				System.out.println();
				br3.displayEmployees();
				System.out.println("Remove employee using index 0, 2");
				br3.deleteEmployee(0);
				br3.deleteEmployee(2);
				br3.displayEmployees();
				
				System.out.println("\nbr3.getFunitureIndex(new MeetingTable(3,8,br1.getId())) :" + br3.getFurnitureIndex(new MeetingTable(3,8,br1.getId())));
				
				
				System.out.println("\nDatas Functions: ");
				System.out.println("Add admin");
				Admin admin2 = new Admin(datas,"a2","a2","a2","a2");
				datas.addAdmin(admin2);
				
				System.out.println("branch add br5");
				Branch br5 = new Branch("br5");
				datas.addBranch(br5);
				datas.displayBranchs();
		
				System.out.println("datas add employee br5");
				Employee emp = new Employee(datas, br5, "ee", "ee", "ee", "ee");
				datas.addEmployee(br5, emp);
				br5.displayEmployees();
				
				Customer cc = new Customer(datas,"cc","cc","cc","cc");
				System.out.println("add customer cc");
				datas.addCustomer(cc);
				datas.displayCustomers();
				
				System.out.println("\nCheck admin account: datas.checkAdminAccount(admin2); =>");  
				System.out.println(datas.checkAdminAccount(admin2) == null ? false :true);
				
				System.out.println("\nCheck employee account :datas.checkEmployeeAccount(emp) =>");
				System.out.println(datas.checkEmployeeAccount(emp) == null ? false :true);
				
				System.out.println("\nCheck customer account :datas.checkCustomerAccount(cc) =>");
				System.out.println(datas.checkCustomerAccount(cc) == null ? false :true);
				
				System.out.println("Check unknown account :");
				System.out.println("\nCheck admin account: datas.checkAdminAccount(new Admin(datas,\"asasa\",\"asasa\",\"asasa\",\"asasa\")); =>");  
				System.out.println(datas.checkAdminAccount(new Admin(datas,"asasa","asasa","asasa","asasa")) == null ? false :true);
			
				System.out.println("\nCheck employee account: datas.checkEmployeeAccount(new Employee(datas,br5,\"asasa\",\"asasa\",\"asasa\",\"asasa\")); =>");  
				System.out.println(datas.checkEmployeeAccount(new Employee(datas,br5,"asasa","asasa","asasa","asasa")) == null ? false :true);
			
				System.out.println("\nCheck customer account: datas.checkEmployeeAccount(new Customer(datas,\"asasa\",\"asasa\",\"asasa\",\"asasa\")); =>");  
				System.out.println(datas.checkCustomerAccount(new Customer(datas,"asasa","asasa","asasa","asasa")) == null ? false :true);
				
				System.out.println("\nDisplay Customers");
				datas.displayCustomers();
				
				System.out.println("see all product all store - > datas.displayProducts()");
				datas.displayProducts();
			}
			else {
				System.out.println("UNKNOWN OPERATION");
			}
		
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
	}	
}
