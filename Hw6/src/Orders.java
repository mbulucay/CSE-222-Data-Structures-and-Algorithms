
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

class Orders{

    private static String fname = "orders.csv";
    private static File file = new File(fname);
    private static TreeSet<Order> orders = new TreeSet<>();

    /** 
     * @param user
     * @return Queue<Order>
     * @throws IOException
     * @throws NumberFormatException
     * Wrapper method
     * Seeing order of any user having an account in the system
     */
    public static Queue<Order> seeOrders(User user) throws NumberFormatException, IOException{
        if(user instanceof Customer)
            return seeOrders(user,0);
        if(user instanceof Trader)
            return seeOrders(user,1);

        return null;
    }

    
    /** 
     * @param user
     * @param index
     * @return Queue<Order>
     * @throws IOException
     * @throws NumberFormatException
     * Seeing order of any user having an account in the system
     */
    private static Queue<Order> seeOrders(User user,int index) throws NumberFormatException, IOException{

        Scanner oscan = new Scanner(file);
        Queue<Order> traderOrders = new LinkedList<>();

        while(oscan.hasNextLine()){

            String[] order = oscan.nextLine().split(",");
            if(order[index].equals(user.getId().toString())){

                Product p = Products.findProduct(order[2]);
                Customer c = (Customer) DataBase.getUser(Integer.parseInt(order[0]));
                Trader t = (Trader) DataBase.getUser(Integer.parseInt(order[1]));

                traderOrders.add(new Order(p,c,t));
            }
        }

        oscan.close();
        return traderOrders;
    }

    
    /** 
     * @param user
     * @param p
     * @throws IOException
     * Adding an order to order file
     */
    public static void addOrder(User user,Product p) throws IOException{

        BufferedWriter fw = new BufferedWriter(new FileWriter(fname,true));
        fw.append(user.getId() + "," + p.getTrader().getId() + "," + p.getProductId() + "\n");
        fw.close();
    }


    
    /** 
     * @param o
     * @throws IOException
     * Deleting order from order.csv 
     */
    public static void deleteOrder(Order o) throws IOException {
       
        File tempFile = new File("myTempOrder.csv");
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        
        String lineToRemove = o.getCustomer().getId() + "," + o.getTrader().getId() + "," + o.getProduct().getProductId();
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            if(currentLine.equals(lineToRemove)) 
                continue;
            writer.write(currentLine+"\n");
        }

        writer.close(); 
        reader.close(); 

        file.delete();
        tempFile.renameTo(file);
    }

}