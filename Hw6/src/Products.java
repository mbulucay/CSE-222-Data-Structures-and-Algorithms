
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Products {

    private static String fname = "sortedProducts.csv";
    private static File file = new File(fname);


    
    /** 
     * @param name
     * @return ArrayList<Product>
     * @throws FileNotFoundException
     * Searching products in sortedProducts.csv according to the name in contains in
     * name and description column
     */
    public static ArrayList<Product> searchInCsv(String name) throws FileNotFoundException {
        
        ArrayList<Product> productList = new ArrayList<>();
        Scanner fscan = new Scanner(file);
        fscan.nextLine().split(";");        //column names

        while(fscan.hasNextLine()){        //Read end of the file 
            
            String[] productProperties = fscan.nextLine().split(";");   //split the row wanted piece to reach easily 

            if(productProperties[1].contains(name) || productProperties[5].contains(name)){         //If name or description contains name add to List<Product>
                productList.add(new Product(productProperties[0], productProperties[1], productProperties[2], 
                                Double.parseDouble(productProperties[3]), Double.parseDouble(productProperties[4]), 
                                productProperties[5], DataBase.getTrader(productProperties[6])));

            }
        }
        
        fscan.close();        
        Collections.sort(productList,Product.NameComparator);     //Sort By descending name 
        return productList;
    }
    
    
    /** 
     * @param id
     * @return Product
     * @throws IOException
     * @throws NumberFormatException
     * Finding product file comparing product id matching product
     * and return it
     */
    public static Product findProduct(String id) throws NumberFormatException, IOException{
        
        BufferedReader bReader = new BufferedReader(new FileReader(file));
        
        bReader.readLine().split(";");
        String row;

        while((row = bReader.readLine()) != null){

            String[] productProperties = row.split(";");

            if(productProperties[0].equals(id)){
                bReader.close();
                return new Product(productProperties[0], productProperties[1], productProperties[2], 
                                Double.parseDouble(productProperties[3]), Double.parseDouble(productProperties[4]), 
                                productProperties[5], DataBase.getTrader(productProperties[6]));
            }
        }
        bReader.close();

        return null;
    }

    
    /** 
     * @param name
     * @return ArrayList<Product>
     * @throws FileNotFoundException
     * Searching all product of a trader in the products file
     */
    public static ArrayList<Product> searchAllProductOfTrader(String name) throws FileNotFoundException{

        ArrayList<Product> productList = new ArrayList<>();
        Scanner fscan = new Scanner(file);
        fscan.nextLine().split(";");

        while(fscan.hasNextLine()){
            
            String[] productProperties = fscan.nextLine().split(";");
            if(productProperties[6].equals(name)){
                productList.add(new Product(productProperties[0], productProperties[1], productProperties[2], 
                                Double.parseDouble(productProperties[3]), Double.parseDouble(productProperties[4]), 
                                productProperties[5], DataBase.getTrader(name)));
            }
        }
        Collections.sort(productList,Product.NameComparator);
        fscan.close();
        return productList;
    }


    
    /** 
     * @param product
     * @return boolean
     * @throws IOException
     * Adding products to products file
     */
    public static boolean addProduct(Product product) throws IOException{
        
        boolean isAdded = true;
        String tempFilePath = "tmpSortedProducts.csv";
        File tempFile = new File(tempFilePath);

        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(tempFile));
        
        String row;
        row = csvReader.readLine();
        csvWriter.write(row + "\n");

        while((row = csvReader.readLine()) != null){

            String[] rowProduct = row.split(";");
            if(rowProduct[0].equals(product.getProductId())){
                isAdded = false;
            }    
            if(isAdded && rowProduct[0].compareTo(product.getProductId()) > 0){
                isAdded = false;
                csvWriter.write(product.getProductId() + ";" + product.getProductName() + ";" + product.getProductCategoryTree() + ";" 
                                + product.getPrice() + ";"  + product.getDiscountedPrice() + ";"  + product.getDescription() + ";" + product.getTrader().getName() + "\n");
            }
            csvWriter.write(row + "\n");
        }
        
        csvReader.close();
        csvWriter.close();

        file.delete();
        tempFile.renameTo(file);
        return isAdded;
    }

    
    /** 
     * @param product
     * @return Product
     * @throws IOException
     * Removing products in the products file
     */
    public static Product removeProduct(Product product) throws IOException{
        
        Product removeProduct = null;
        
        String tempFilePath = "tmpSortedProducts.csv";
        File tempFile = new File(tempFilePath);

        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(tempFile));
        
        String row;
        row = csvReader.readLine();
        csvWriter.write(row + "\n");

        while((row = csvReader.readLine()) != null){

            String[] rowProduct = row.split(";");
            if(rowProduct[0].equals(product.getProductId()) && rowProduct[6].equals(product.getTrader().getName())){
                removeProduct = product;
                continue;
            }    
            csvWriter.write(row + "\n");
        }

        csvReader.close();
        csvWriter.close();

        file.delete();
        tempFile.renameTo(file);

        return removeProduct;
    }

    
    /** 
     * @param product
     * @return Product
     * @throws IOException
     * Edit product in the products file if id is matching
     */
    public static Product editProduct(Product product) throws IOException{

        Product editProduct = null;
        String tempFilePath = "tmpSortedProducts.csv";
        File tempFile = new File(tempFilePath);

        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(tempFile));
        
        String row;
        row = csvReader.readLine();
        csvWriter.write(row + "\n");

        while((row = csvReader.readLine()) != null){

            String[] rowProduct = row.split(";");
            
            if(rowProduct[0].equals(product.getProductId()) && rowProduct[6].equals(product.getTrader().getName())){

                editProduct = new Product(rowProduct[0], rowProduct[1], rowProduct[2], Double.parseDouble(rowProduct[3]) 
                                ,Double.parseDouble(rowProduct[4]) , rowProduct[5], product.getTrader());

                product = ObjectCreator.createProduct(product.getProductId(),product.getTrader());
                csvWriter.write(product.getProductId() + ";" + product.getProductName() + ";" + product.getProductCategoryTree() + ";" 
                                + product.getPrice() + ";"  + product.getDiscountedPrice() + ";"  + product.getDescription() + ";" + product.getTrader().getName() + "\n");
                continue;
            }    
            csvWriter.write(row + "\n");
        }

        csvReader.close();
        csvWriter.close();

        file.delete();
        tempFile.renameTo(file);

        return editProduct;
    }

    
    /** 
     * @param pName
     * @return boolean
     * @throws FileNotFoundException
     * Query products in the products file
     */
    public static boolean queryProduct(String pName) throws FileNotFoundException {

        Scanner fscan = new Scanner(file);
        fscan.nextLine().split(";");

        while(fscan.hasNextLine()){
            String[] productProperties = fscan.nextLine().split(";");

            if(productProperties[1].contains(pName)){
                fscan.close();
                return true;
            }    
        }
        fscan.close();
        return false;
    }


}
