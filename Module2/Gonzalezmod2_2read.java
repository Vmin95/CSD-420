/**
 * Julia Gonzalez 
 * 6.5.25
 * Mod 2.2 Assignment (read program)
**/
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Gonzalezmod2_2read {
    public static void main(String args[]){
        //create file reader object for data.file
        try (FileReader FileRead = new FileReader("C:\\csd\\CSD-420\\module-2\\julia.dat")){
            //Scan the document and print it to the terminal
            try (Scanner reader = new Scanner(FileRead)) {
                while (reader.hasNext()){
                    System.out.print(reader.next() + " ");
                }
            }

        }
        catch (IOException e) {
            System.out.println("oops something went wrong:(");
        }
        
    }
}