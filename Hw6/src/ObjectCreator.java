
import java.util.Scanner;

public class ObjectCreator {

    private static Scanner scan = new Scanner(System.in);
    
    
    /** 
     * @param trader
     * @return Product
     * Creating Product with wanted properties from 0 
     */
    public static Product createProduct(Trader trader){
        
        String id,productName,productCategoryTree,description;
        Double price,discountedPrice;

        System.out.println("Enter the uniqe Id :");
        id = scan.nextLine();
        System.out.println("Enter the Product Name :");
        productName = scan.nextLine();
        System.out.println("Enter the Product Category Tree :");
        productCategoryTree = scan.nextLine();
        System.out.println("Enter the price :");
        price = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the discount price");
        discountedPrice = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the description :");
        description = scan.nextLine();
        
        return new Product(id, productName, productCategoryTree, price, discountedPrice, description,trader );
    }

    
    /** 
     * @param id
     * @param trader
     * @return Product
     * Trader creating product
     */
    public static Product createProduct(String id,Trader trader){
        
        String productName,productCategoryTree,description;
        Double price,discountedPrice;

        System.out.println("Enter the new Product Name :");
        productName = scan.nextLine();
        System.out.println("Enter the new  Product Category Tree :");
        productCategoryTree = scan.nextLine();
        System.out.println("Enter the new  price :");
        price = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the new  discount price");
        discountedPrice = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the new  description :");
        description = scan.nextLine();
        
        return new Product(id, productName, productCategoryTree, price, discountedPrice, description,trader );
    }

    
    /** 
     * @return Customer
     * Creating the customer to saving the system
     */
    public static Customer createCustomer(){
        
        String name,surname,password;
        Integer id;

        System.out.println("Enter the name:");
        name = scan.nextLine();
        System.out.println("Enter the surname:");
        surname = scan.nextLine();
        System.out.println("Enter the id:");
        id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the password");
        password = scan.nextLine();

        return new Customer(name, surname, id, password);
    }

}
