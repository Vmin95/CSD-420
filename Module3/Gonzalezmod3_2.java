/*
*Julia Gonazalez
*Assignment3.2
*6/15/2025
*The purpose of this assignment is to remove duplicate elements from an ArrayList
*/

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class Gonzalezmod3_2 {
    public static void main(String[] args){

        //create random instance for RNG
        Random random = new Random();
        //create list to hold random numbers
        ArrayList<Integer> randlist = new ArrayList<>();

        //fill ArrayList with random numbers
        for(int i = 1; i < 50; i++){
            Integer randomint = random.nextInt(1, 21);
            randlist.add(randomint);
        }
        
        //print randlist without any duplicates
        System.out.println(removeDuplicates(randlist));

    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        //create a set
        Set<E> set = new HashSet<E>();

        /*Populate set with items from the given list 
         * this automatically removes the duplicates because sets cannot contain duplicates
        */
        for(int i = 0; i < list.size(); i++){
            set.add(list.get(i));
        }
        
        //turn the set into an ArrayList
        ArrayList<E> newList = new ArrayList(set);
        
        //return the new list
        return newList;
    }
}
