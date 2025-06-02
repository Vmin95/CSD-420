/*
Julia Gonzalez
CSD420
5/29/25
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Gonzalez_mod1write {
    public static void main(String[] args){
        File file = new File("gonzalezdatafile.dat");
        int[] iArray = new int[5];
        double[] dArray = new double[5];

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String bDate = date.format(format);

        //fill the arrays with random numbers
        for(int i = 0; i < iArray.length; i++){
            iArray[i] = (int)(getRandom());
        }

        for(int i = 0; i < dArray.length; i++){
            dArray[i] = getRandom();
        }

        //try with resources to create object output stream to write to the file
        try(RandomAccessFile output =
            new RandomAccessFile(file, "rw")) {

            output.seek(file.length());

            for(int i =0; i < iArray.length; i++){
                output.writeInt(iArray[i]);
            }

            output.writeUTF(bDate);


            for(int i = 0; i < dArray.length; i++){
                output.writeDouble(dArray[i]);
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    static double getRandom(){
        return Math.random() * 100;
    }
}

