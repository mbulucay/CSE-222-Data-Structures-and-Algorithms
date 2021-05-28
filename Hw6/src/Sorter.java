
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sorter {
    
    static String filePath = "sortedProducts.csv";
    static File file = new File(filePath);
    
    static String head;
    static ArrayList<String[]> rows = null;
    

    
    /** 
     * @param list
     */
    private static <Object extends Comparable<Object>> void quickSort(List<Object[]> list){
        sort(list,0,list.size()-1);
    }

    
    /** 
     * @param list
     * @param first
     * @param last
     */
    private static <Object extends Comparable<Object>> void sort(List<Object[]> list,int first,int last){
        if(first < last){
            int pivIndex = partition(list, first, last);
            sort(list,first,pivIndex - 1);
            sort(list,pivIndex + 1,last);
        }
    }

    
    /** 
     * @param list
     * @param first
     * @param last
     * @return int
     */
    private static <Object extends Comparable<Object>> int partition(List<Object[]> list, int first,int last){

        Object pivot = list.get(first)[0];
        int left = first,
            right = last;

        do{
            
            while( (left < last) && (pivot.compareTo(list.get(left)[0]) >= 0) )
                left++;

            while(pivot.compareTo(list.get(right)[0]) < 0)
                right--;

            if(left < right){
                swap(list,left,right);
                // System.out.println(list.get(left)[1] + "   " + list.get(right)[1]);
                // System.out.println("left:" + left + " right:" + right);
            }
            // System.out.println( left + "------------------------" + right);
        }while(left < right);

        swap(list,first,right);
        return right;

    }

    
    /** 
     * @param list
     * @param left
     * @param right
     */
    private static <Object extends Comparable<Object>> void swap(List<Object[]> list,int left, int right){

        Object[] tmp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, tmp);
    }


    
    /** 
     * @param list
     */
    private static <Object extends Comparable<Object>> void insertionSort(List<Object[]> list){
       
        for(int next = 1 ; next<list.size(); next++)
            insert(list,next);
    }

    
    /** 
     * @param list
     * @param nextpos
     */
    private static <Object extends Comparable<Object>> void insert(List<Object[]> list, int nextpos) {

        String[] str = (String[]) list.get(nextpos);

        while((nextpos > 0) 
                && (str[0].compareTo((String) list.get(nextpos - 1)[0]) < 0) ){
                list.set(nextpos, list.get(nextpos-1));
                nextpos--;
        }
        list.set(nextpos, (Object[]) str);
    }


    
    /** 
     * @throws IOException
     */
    public static void sortFileQuick() throws IOException{
        
        String tempFilePath = "tmpSortedProducts.csv";
        File tempFile = new File(tempFilePath);

        rows = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(tempFile));
        String row;

        head = csvReader.readLine();
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(";");
            rows.add(data);
        }
        csvReader.close();

        quickSort(rows);
        
        csvWriter.append(head+ "\n");
        for(String[] r : rows)
            csvWriter.append(r[0] + ";" + r[1] + ";" + r[2] + ";" + r[3] + ";" + r[4] + ";" + r[5] + ";" + r[6] + "\n");

        csvWriter.close(); 
        csvReader.close();

        file.delete();
        tempFile.renameTo(file);
    }
    
    
    /** 
     * @throws IOException
     */
    public static void sortFileInsertion() throws IOException{

        String tempFilePath = "tmpSortedProducts.csv";
        File tempFile = new File(tempFilePath);
        
        rows = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(tempFile));
        String row;
        
        head = csvReader.readLine();
        while ((row = csvReader.readLine()) != null) 
            rows.add(row.split(";"));
        
        insertionSort(rows);
        
        csvWriter.write(head+ "\n");
        for(String[] r : rows)
            csvWriter.write(r[0] + ";" + r[1] + ";" + r[2] + ";" + r[3] + ";" + r[4] + ";" + r[5] + ";" + r[6] + "\n");
        
        csvWriter.close(); 
        csvReader.close(); 

        file.delete();
        tempFile.renameTo(file);   
    }

}
