/*
*Julia Gonzalez
*6/21/25
*Assignment 5.2
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Gonzalezmod5_2 {
    public static void main(String[] args){

        //create a filereader object for reading the collection
        try (FileReader FileRead = new FileReader("collection_of_words.txt")){
            /*create a TreeSet to store the words from the text document 
             * this will automatically sort the words in ascending order and remove the duplicates
            */
            TreeSet<String> collectionOfWords = new TreeSet<>();
            try (Scanner reader = new Scanner(FileRead)) {
                while (reader.hasNext()){
                    collectionOfWords.add(reader.next());
                }
            }

            //print the collection to the terminal
            System.out.println("-- COLLECTION OF WORDS ASCENDING -- ");
            Iterator<String> it = collectionOfWords.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }

            //print the collection in descending order
            System.out.println("-- COLLECTION OF WORDS DESCENDING --");
            int size = collectionOfWords.size();
            for(int i = 0; i < size; i++){
                System.out.println(collectionOfWords.pollLast());
            }
            

        }
        catch (IOException e) {
            System.out.println("oh no something went wrong:(");
        }
        
    }
}