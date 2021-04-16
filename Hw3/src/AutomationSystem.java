import java.util.NoSuchElementException;
import java.util.Scanner;
/**<h2>Automation System Class for the furniture company</h2>*/
public class AutomationSystem {

	DATA data;
	Scanner scan;
	
	public AutomationSystem() {
		data = new DATA();
		scan = new Scanner(System.in);
	}
	
	/**<p>It is fill some before prepared data to check the system</p>*/
	public void DEFAULT_LOAD(){
		
		Admin admin = new Admin(data,"a","a","a","a");
		data.addAdmin(admin);
		
		Branch br1 = new Branch();
		admin.addBranch(br1);
		Employee emp1 = new Employee(data,br1,"e1","e1","e1","e1");
		Employee emp2 = new Employee(data,br1,"e2","e2","e2","e2");
		data.addEmployee(br1, emp1);
		data.addEmployee(br1, emp2);
		
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
		
		br1.addProduct(new OfficeCabinet(0, 0, br1.getId()));
		
		Branch br2 = new Branch();
		admin.addBranch(br2);
		Employee emp3 = new Employee(data,br2,"e3","e3","e3","e3");
		Employee emp4 = new Employee(data,br2,"e4","e4","e4","e4");
		data.addEmployee(br2, emp3);
		data.addEmployee(br2, emp4);
		
		emp3.addProduct(new OfficeChair(0,1,br2.getId()));
		emp3.addProduct(new OfficeChair(2,4,br2.getId()));
		emp3.addProduct(new OfficeChair(1,3,br2.getId()));
		emp3.addProduct(new OfficeChair(4,6,br2.getId()));
		
		emp3.addProduct(new OfficeDesk(0,1,br2.getId()));
		emp3.addProduct(new OfficeDesk(2,1,br2.getId()));
		emp3.addProduct(new OfficeDesk(3,3,br2.getId()));
		emp3.addProduct(new OfficeDesk(3,4,br2.getId()));
		
		emp3.addProduct(new MeetingTable(0,1,br2.getId()));
		emp3.addProduct(new MeetingTable(2,6,br2.getId()));
		emp3.addProduct(new MeetingTable(3,8,br2.getId()));
		emp3.addProduct(new MeetingTable(1,4,br2.getId()));
		
		emp3.addProduct(new Bookcases(0,3,br2.getId()));
		emp3.addProduct(new Bookcases(0,6,br2.getId()));
		emp3.addProduct(new Bookcases(0,8,br2.getId()));
		emp3.addProduct(new Bookcases(0,10,br2.getId()));
		
		emp3.addProduct(new OfficeCabinet(0,4,br2.getId()));
		emp3.addProduct(new OfficeCabinet(0,7,br2.getId()));
		emp3.addProduct(new OfficeCabinet(0,3,br2.getId()));
		emp3.addProduct(new OfficeCabinet(0,11,br2.getId()));
		
		System.out.println("admin : email> a password> a");
		System.out.println("br1 : employee1 > email:e1 password:e1   employee2 > email:e2 password:e2");
		System.out.println("br2 : employee1 > email:e3 password:e3   employee2 > email:e4 password:e4");
	}
	
	public void Runner() {
		
		int choose;
		System.out.println("Do you want to default load some data");
		System.out.println("1->yes");
		System.out.println("2 or else-> no");
		System.out.println("Enter choose:");
		try {
			choose = Integer.parseInt(scan.nextLine());
			if(choose == 1)
				DEFAULT_LOAD();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		int operation;
		while(true) {
			try {
				System.out.println("======================================");
				System.out.println("==Welcome the MBU store==\n");
				System.out.println("Please select the following operation\n");
				System.out.println("1-> Login & create for admin");
				System.out.println("2-> Login & create for employee");
				System.out.println("3-> Login & create for customer");
				System.out.println("0-> Close the program\n");
				System.out.println("Enter the operation : ");
				operation = Integer.parseInt(scan.nextLine());
				switch(operation) {
					case 1:		Admin();
						break;
					case 2:		Employee();
						break;
					case 3:		Customer();
						break;
					case 0:
						scan.close();
						System.out.println("\n====Come Again====");
						System.exit(0);
					default:
						System.out.println(operation + " is not a valid value");
				}
			}catch(NumberFormatException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 69");
			}catch(NoSuchElementException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 71");
			}	
		}
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**<p>Login or creating admin account functions</p>*/
	public void Admin() {
		
		Admin admin;
		int operation;
		while(true) {
			try {
				System.out.println("======================================");
				System.out.println("\nPlease select an operation\n");
				System.out.println("1-> Login system as admin");
				System.out.println("2-> Create an admin account");
				System.out.println("0-> Go top menu");
				System.out.print("\nEnter the operation : ");
				operation = Integer.parseInt(scan.nextLine());
				switch(operation) {
					case 1:	
							loginAsAdmin();
						break;
					case 2:
							admin = data.makeAdmin();
							if(admin != null)
								data.addAdmin(admin);
						break;
					case 0:	
						return;
					default:
						System.out.println(operation +" is not a valid value");
				}
			}catch(NumberFormatException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 104");
			}catch(NoSuchElementException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 106");
			}
		}
		
	}
	
	/**<p>Login admin using email and password</p>*/
	public void loginAsAdmin(){
		Admin admin;
		String email,password;
		try {
			
			System.out.println("\nEntering system as Admin");
			System.out.print("Enter the email :");
			email = scan.nextLine();
			System.out.print("Enter the password :");
			password = scan.nextLine();
			
			admin = data.checkAdminAccount(new Admin(data,"0","0",email, password));
			if(admin == null)
				System.out.println("\nEmail or password is wrong\n");
			else
				adminAuthority(admin);
				
		}catch(NoSuchElementException e) {
			System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 126");
		}catch(NullPointerException e) {
			System.out.println("Be sure that enter valid index");
		}catch(ArrayIndexOutOfBoundsException  e) {
			System.out.println("Out of bound exceprion. You entered unvalid index");
		}
	}
	
	/**<p>Taken as parameter admin authority menu</p>*/
	public void adminAuthority(Admin admin){
	
		Branch branch = null;
		Employee employee = null;
		int operation,index;

		while(true) {
			try {
				System.out.println("======================================");
				System.out.println("\nWelcome Mr/Mrs " + admin.getName()+ " " + admin.getSurname());
				System.out.println("Please select following operation\n");
				System.out.println("1-> Add a new Branch");
				System.out.println("2-> Remove a Branch");
				System.out.println("3-> Add a new Employee");
				System.out.println("4-> Remove an employee");
				System.out.println("5-> Display current Branchs");
				System.out.println("6-> Display current Employess");
				System.out.println("7-> Query Product");
				System.out.println("8-> Display Messages");
				System.out.println("9-> Clear Messages");
				System.out.println("0-> Log out the account");
				System.out.print("\nEnter the operation :");
				operation = Integer.parseInt(scan.nextLine());;
			
				switch(operation){
					
					case 1:		branch = admin.makeBranch();
								if(branch != null) {
									admin.addBranch(branch);
									System.out.println("Branch " + branch.getId() + " has added");
								}	
						break;
					case 2:		admin.displayBranchs();
								System.out.println("Enter the index :");
								index = Integer.parseInt(scan.nextLine());
								if(admin.removeBranch(index) != null) {
									System.out.println(admin.getBranch(index).getId() + " has removed");
								}else
									System.out.println("Branch has not removed check branch index");
						break;
					case 3:		
								
									employee = admin.makeEmployee();
									if(employee != null) {
										admin.addEmployee(branch,employee);
										System.out.println(employee + " has added");
									}else 
										System.out.println("Employee cannot added check valid branch index");
							break;
					case 4:		
								System.out.println("Choose branch for removing employee:");
								admin.displayBranchs();
								System.out.println("Enter the index :");
								index = Integer.parseInt(scan.nextLine());
								
								branch = admin.getBranch(index);
								if(branch != null) {
									branch.displayEmployees();
									System.out.println("Enter the index number of worker to take out :");
									index = Integer.parseInt(scan.nextLine());
									employee = branch.getEmployee(index);
									if(employee != null) {
										admin.removeEmployee(branch, employee);
										System.out.println(employee + " has removed");
									}
									else
										System.out.println("Undefined employee index please enter a valid index");
								}else
									System.out.println("Undefined branch index please enter valid branch");
								
						break;
					case 5:		admin.displayBranchs();
						break;
					case 6:		admin.displayEmployee();
						break;
					case 7:
								Furniture furniture = data.makeProduct();
								if(furniture != null)
									System.out.println(furniture  + ": " + admin.queryProduct(furniture));
								else
									System.out.println("Undefined furniture type");
						break;
					case 8:		Admin.displayMessages();
						break;
					case 9:		Admin.clearMessages();
								System.out.println("Messages are deleted");
						break;
					case 0:		
						return;
					default:
						System.out.println("\nPlease, Enter a valid authority number");
				}
			}catch(NumberFormatException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 172");
			}catch(NoSuchElementException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 174");
			}catch(ArrayIndexOutOfBoundsException  e) {
				System.out.println("Out of bound exceprion. You entered unvalid index");
			}catch(NullPointerException e) {
				System.out.println("Be sure that enter valid index for branch");
			}
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**<p>Login or creating employee account functions</p>*/
	public void Employee() {
		
		Employee employee;
		int operation;
		while(true) {
			try {
				System.out.println("==========================");
				System.out.println("\nPlease select an operation");
				System.out.println("1-> Create and account");
				System.out.println("2-> Login system");
				System.out.println("0-> Top menu");
				operation = Integer.parseInt(scan.nextLine());
				
				switch(operation) {
					case 1:			
							employee = data.makeEmployee();
							data.displayBranchs();
							System.out.println("Enter the index of branch where you work :");
							int index = Integer.parseInt(scan.nextLine());
									
							data.addEmployee(data.getBranch(index),employee);
						break;
					case 2:	
							loginAsEmployee();
						break;
					case 0:
						return;
					default:
						System.out.println("Undefined operation");
				}
			}catch(NumberFormatException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 606");
			}catch(NoSuchElementException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 608");
			}catch(NullPointerException e) {
				System.out.println("Be sure that enter valid index for branch");
			}catch(ArrayIndexOutOfBoundsException  e) {
				System.out.println("Out of bound exception. You entered unvalid index");
			}
		}	
	}
	
	/**<p>Taken as parameter employee authority menu</p>*/
	public void loginAsEmployee() {
		
		String email,password;
		Employee employee = null;
		try {
			System.out.println("\nEmployee Login System \n");
			System.out.println("Please enter the mail :");
			email = scan.nextLine();
			System.out.println("Please enter the password :");
			password = scan.nextLine();
			
			employee = data.checkEmployeeAccount(new Employee(null,null,"0", "0", email, password));
			
			if(employee == null)
				System.out.println("\nEmail or password is wrong");
			else
				employeeAuthority(employee);
		}catch(NoSuchElementException e) {
			System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 521");
		}

		
	}
		
	/**<p>Taken as parameter employee authority menu</p>*/
	public void employeeAuthority(Employee employee) {
		
		Customer customer = null;
		Furniture furniture = null;
		int operation,id,index;
		while(true) {
			try {
				System.out.println("==================================\n");
				System.out.println("\nWelcome Mr/Mrs " + employee.getName() + " " + employee.getSurname());
				System.out.println("1-> Add Product");
				System.out.println("2-> Remove Product");
				System.out.println("3-> Query Product");
				System.out.println("4-> Sell Product");
				System.out.println("5-> Display a customer shopping List");
				System.out.println("6-> Display product in working store");
				System.out.println("7-> Send message to admin out of stock");
				System.out.println("0-> Top menu");
				System.out.println("Enter an operation :");
				operation = Integer.parseInt(scan.nextLine());
				
				switch(operation) {
				
					case 1:
								furniture = data.makeProduct();
								if(employee.addProduct(furniture))
									System.out.println(furniture + " added");
								else
									System.out.println(furniture + " has not added");
						break;
					case 2:
								employee.displayProducts();
								System.out.println("Enter the index :");
								index = Integer.parseInt(scan.nextLine());
								employee.removeProduct(index);
						break;
					case 3:		
								furniture = data.makeProduct();
								if(employee.queryProduct(furniture)) {
									System.out.println("Yes brach has " + furniture);
								}else
									System.out.println("No branch has not " + furniture);
						break;
					case 4:		
								data.displayCustomers();
								System.out.println("Enter the customer id:");
								id = Integer.parseInt(scan.nextLine());
								customer = data.getCustomer(id);
								if(customer == null) {
									System.out.println("Undefined customer id\nYou need to make an account first");
									customer = data.makeCustomer();
									data.addCustomer(customer);
								}
								employee.displayProducts();
								System.out.println("Enter product index: ");
								index = Integer.parseInt(scan.nextLine());
								furniture = employee.getFurniture(index);
								if(furniture != null) {
									employee.sellProduct(furniture, customer);
									System.out.println("Selling process succesfully done");
								}else
									System.out.println("Please enter a valid index number");
						break;
					case 5:		data.displayCustomers();
								System.out.println("Enter the customer id:");
								id = Integer.parseInt(scan.nextLine());
								data.displayCustomerShopList(id);
						break;
					case 6:		employee.getBranch().displayProducts();
						break;
					case 7:		System.out.println("Select out of stock product");
								furniture = data.makeProduct();
								if(furniture != null) {
									employee.sendMessageToAdmin(furniture + "out of stock\n");
									System.out.println("Message sended to the admin");
								}else
									System.out.println("Message has not sended to the admin");
						break;
					case 0:
						return;
					default:
						System.out.println("Undefined operation");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 172");
			}catch(NoSuchElementException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 174");
			}catch(ArrayIndexOutOfBoundsException  e) {
				System.out.println("Out of bound exceprion. You entered unvalid index");
			}
		}	
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**<p>Login or creating customer account functions</p>*/
	public void Customer(){
	
		Customer customer = null;
		int operation;
		while(true) {
			try {
				System.out.println("==========================");
				System.out.println("\nPlease select an operation");
				System.out.println("1-> Create and account");
				System.out.println("2-> Login system");
				System.out.println("0-> Top menu");
				operation = Integer.parseInt(scan.nextLine());
				
				switch(operation) {
					case 1:			customer = data.makeCustomer();
									data.addCustomer(customer);
						break;
					case 2:			loginAsCustomer();
						break;
					case 0:
						return;
					default:
						System.out.println("Undefined operation");
				}
			}catch(NumberFormatException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 606");
			}catch(NoSuchElementException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 608");
			}
		}	
	}

	/**<p>Taken as parameter customer authority menu</p>*/
	public void loginAsCustomer() {
		
		String email,password;
		Customer customer = null;
		
		try {
			System.out.println("Customer Login System \n");
			System.out.println("Please enter the mail :");
			email = scan.nextLine();
			System.out.println("Please enter the password :");
			password = scan.nextLine();
			customer = data.checkCustomerAccount(new Customer(null,"0", "0", email, password));
			if(customer == null)
				System.out.println("\nEmail or password is wrong");
			else
				customerAuthority(customer);
		}catch(NoSuchElementException e) {
			System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type line : 521");
		}
	}
	
	/**<p>Taken as parameter employee authority menu</p>*/
	public void customerAuthority(Customer  customer) {
			
		Furniture furniture = null;
		Branch branch = null;
		int operation;
		while(true) {
			try {
				System.out.println("==================================\n");
				System.out.println("\nWelcome Mr/Mrs " + customer.getName() + " " + customer.getSurname());
				System.out.println("1-> Display specific id");
				System.out.println("2-> Display Shopping List");
				System.out.println("3-> See Broduct all store");
				System.out.println("4-> Query a product");
				System.out.println("5-> Buy a product from store");
				System.out.println("6-> Make online shopping");
				System.out.println("0-> Log out");
				System.out.println("Enter the operation :");
				operation = Integer.parseInt(scan.nextLine());
				
				switch(operation) {
					case 1:			System.out.println("Your id : " + customer.getId());
						break;
					case 2:			customer.displayShoppingList();	
						break;
					case 3:			customer.displayProducts();
						break;
					case 4:
									furniture = data.makeProduct();
									branch = data.queryProduct(furniture);
									if(branch == null)
										System.out.println("We dont have this product");
									else
										System.out.println("Product is in store id " + branch.getId());
						break;
					
					case 5:   		
									furniture = data.makeProduct();
									branch = data.queryProduct(furniture);
									if(branch == null)
										System.out.println("We dont have this product");
									else {
										branch.removeProduct(branch.indexOfFurniture(furniture));
										customer.buyProduct(furniture);
										System.out.println("Buying succesfully done");
									}
						break;
					case 6:					
									furniture = data.makeProduct();
									branch = data.queryProduct(furniture);
									if(branch == null)
										System.out.println("We dont have this product");
									else {
										branch.removeProduct(branch.indexOfFurniture(furniture));
										customer.onlineShopping();
										branch.sellProduct(furniture, customer);
									}
						break;
					case 0:					
						return;
					default :		System.out.println("This is a unvalid operation");
				}
			}catch(NumberFormatException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 582");
			}catch(NoSuchElementException e) {
				System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type : line 584");
			}catch(ArrayIndexOutOfBoundsException  e) {
				System.out.println("Out of bound exceprion. You entered unvalid index");
			}catch(NullPointerException e) {
				System.out.println("Null Pointer Exception . Be sure enter a valid index");
			}
		}
	}
	
}
