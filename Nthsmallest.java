
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random; 

public class Nthsmallest
{

    public static void main(String[] args) 
    {
        
        int n=500;
        Random rand = new Random(); 
      int r = (rand.nextInt(10))+1;
        
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1=random(n);
        Collections.sort(list1);
        System.out.println(list1);
        System.out.println("*** "+(r)+" (nd/rd/th) smallest number is "+list1.get(r-1)+" ****");
        
     
     
       
    }
    
    public static ArrayList<Integer> random(int n)  //generate unique 500 random numbers
    {
          ArrayList<Integer> list = new ArrayList<Integer>();
          ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i=1; i<n*100; i++) 
        {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<n; i++) 
        {
            list2.add(list.get(i));
        }    //Collections.sort(list2);
            return list2;
        
    }
    
}
