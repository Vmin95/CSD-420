/*
*Julia Gonzalez
*Assignment 4.2
*6/15/2025
*/

/* The purpose of this program is to test the time difference between an iterator and the getIndex method when traversing a LinkedList
 * 
 * RESULT: 
 * On average, the iterator took 2-3 milliseconds to traverse the 50,000 integer list while the getIndex method took around 765 milliseconds
 * As for the 500,000 integer list, the iterator results varied, with the lowest time being 2 milliseconds and the highest being 6 milliseconds
 * the getIndex method took from 103103 - 104230 milliseconds majority of the time (up to over a minute and a half!!)
 * Conclusively, using an iterator is a much faster way to traverse a LinkedList
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Gonzalezmod4_2 {
    public static void main(String[] args){

        //create 50,000 integer linked list 
        List<Integer> linkedList50 = new LinkedList();
        for (int i = 0; i < 50000; i++){
            Random random = new Random();
            linkedList50.add(random.nextInt(100));
        }

        //create 500,000 integer linked list 
        List<Integer> linkedList500 = new LinkedList();
        for (int i = 0; i < 500000; i++){
            Random random = new Random();
            linkedList500.add(random.nextInt(100));
        }

        //print results
        System.out.println(" -- ITERATOR RESULTS -- ");
        System.out.println("Traverse time for 50,000 integer iterator: about " + iteratorTimer(linkedList50) + " milliseconds");
        System.out.println("Traverse time for 500,000 integer iterator: about " + iteratorTimer(linkedList500) + " milliseconds");
        System.out.println();
        System.out.println(" -- GETINDEX RESULTS -- ");
        System.out.println("Traverse time for 50,000 integer getIndex: about " + getIndexTimer(linkedList50) + " milliseconds");
        System.out.println("Traverse time for 500,000 integer getIndex: about " + getIndexTimer(linkedList500) + " milliseconds");
        
    }

    //times the iterator method for a given list
    public static long iteratorTimer(List list){
        long start = System.currentTimeMillis();
        iterator(list);
        long end = System.currentTimeMillis();
        long time = (end - start);
        return time;
    }

    //times the getIndex method for a given list 
    public static long getIndexTimer(List list){
        long start = System.currentTimeMillis();
        getIndex(list);
        long end = System.currentTimeMillis();
        long time = (end - start);
        return time;
    }

    //uses iterator to traverse a list
    public static void iterator(List list){
        Iterator<Integer> it = list.iterator();
        int placeholder = 0;
        while(it.hasNext()){
          placeholder = it.next();
        }
    }

    //uses getIndex to traverse a list
    public static void getIndex(List list){
        Object placeholder = 0;
        for (int i = 0; i < list.size(); i++){
            placeholder = list.get(i);
        }
        
    }
}