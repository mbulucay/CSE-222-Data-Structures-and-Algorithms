import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ll{

    public static void main(String[] args) {
        
        Map<Integer,Integer> m = new Map();

        LinkedList<Integer> ll = new LinkedList<>();

        ArrayList<Integer> a1 = new ArrayList<>(List.of(1,3,5,7,9,11,13,15));
        ArrayList<Integer> a2 = new ArrayList<>(List.of(2,4,6,8,10,12,14,16));

        Iterator ll_iter = ll.iterator();

        int i,j;
        for(i = 0, j = 0; i< a1.size() && j<a2.size();){

            if(a1.get(i) < a2.get(j)){
                ll_iter.add(a1.get(i));
                i++;
            }else{
                ll_iter.add(a2.get(j));
                j++;
            }
        }

        while(i < a1.size()) ll_iter.add(a1.get(i++));
        while(j < a2.size()) ll_iter.add(a2.get(j++));

        System.out.println(ll_iter);

    }

}