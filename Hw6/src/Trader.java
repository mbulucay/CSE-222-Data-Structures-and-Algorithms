
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;


public class Trader extends User implements TraderInterface{
    
    private Queue<Order> orders;
    
    public Trader(String name,Integer id,String password){
        super(name,id,password);
    }

    /**Displaying order for the trader in the orders file */
    public void displayOrders(){
        try {
            orders = Orders.seeOrders(this);    // Displaying having orders in orders.csv and store orders in queue
            for(Order o : orders)
                System.out.println(o);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    /** Managing order to accept cancel or pass for now */
    public void manageOrders(){

        Scanner scan = new Scanner(System.in);
        int operator = 0;
        try {

            orders = Orders.seeOrders(this);                //Returning orders in a queue<order>
            for(Order o : orders){
                System.out.println(o);
                System.out.println("1-> Accept Order");
                System.out.println("2-> Cancel Order");
                System.out.println("3-> Pass Order");
                operator = Integer.parseInt(scan.nextLine());
                
                switch(operator){
                    case 1: o.makeSell();                               //Adding Customer Shop List
                            Products.removeProduct(o.getProduct());     //Removing from sortedProducts.csv
                            Orders.deleteOrder(o);                      //Deleting order from orders.csv
                        break;
                    case 2: Orders.deleteOrder(o);                      //Deleting order from orders.csv
                        break;
                    case 3: System.out.println("Passed this order for now");    //just passing for now
                        break;
                    default:
                        System.out.println("Undefined operation");
                }
            }
            System.out.println("End of orders");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /** Adding product in to the product file */
    public void addProduct(){
        
        try {
            
            Product product = ObjectCreator.createProduct(this);    //Creating object which want to add
            boolean isAddedFile = Products.addProduct(product);     //Inserting the true position if it is a valid product 
            
            if(isAddedFile == false){               
                System.out.println("Cannot happened adding check product id or valid Trader");
                return;
            }
            System.out.println(product.getProductName() + " has added");
                
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** Removing product in the produts file */
    public void removeProduct() {
        Scanner scan = new Scanner(System.in);

        try {

            System.out.println("Enter the id to remove");
            String pId = scan.nextLine();
            
            Product removeProduct = Products.removeProduct(new Product(pId,null ,null ,null , null, null, this)); 
            //If id and store is match in a product remove it and returning
            if(removeProduct == null)
                System.out.println("Product has not found to remove");
            else
                System.out.println(removeProduct + "\nHas removed");
        
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**Edit product in the products file */
    public void editProduct() {
        
        Scanner scan = new Scanner(System.in);

        try{
            System.out.println("Enter the id to edit product");
            String pId = scan.nextLine();

            Product editedProduct = Products.editProduct(new Product(pId, null, null, null, null, null, this));
            //If id and store is match in a product editing it and returning old

            if(editedProduct == null)
                System.out.println("Product has not found to edit");
            else
                System.out.println(editedProduct + "\nHas edited");

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
