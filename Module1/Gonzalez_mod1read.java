/*
Julia Gonzalez
CSD420
5/39/25
*/


/*
The purpose of this program is to store:
    *An array of five random integers
    *A Data objective instance using the current date
    *An array of five random double values
Then append the data in a file titled <yourname>datafile.dat
*/

import java.io.*;
import java.lang.Math;

public class Gonzalez_mod1read {
    public static void main(String[] args){
        File file = new File("gonzalezdatafile.dat");
        int control = 0;

        //try with resources to create object output stream to write to the file
        try(RandomAccessFile input =
            new RandomAccessFile(file, "r")) {

            do{
                control++;
                System.out.println("\nEntry: " + control);
                System.out.println("Ints: ");

                for(int i =0; i < 5; i++){
                    System.out.print(input.readInt() + " ");
                }

                System.out.println("\nDate: ");
                System.out.println(input.readUTF());

                System.out.println("Doubles: ");
                for(int i = 0; i < 5; i++){
                    System.out.print(input.readDouble() + " ");
                }
                System.out.println("\n");

            }while(control * 81 < file.length());

            }catch(IOException ex){
            ex.printStackTrace();
        }



    }
}
