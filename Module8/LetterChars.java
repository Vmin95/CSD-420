import java.util.Random;

public class LetterChars implements Runnable{
    int howMany;

   
    LetterChars(){
        this.howMany = 10;
    }

    LetterChars(int howMany){
        this.howMany = howMany;
    }

    
    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }


    @Override
    public void run() {
        Random rand = new Random();
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' ,'l' ,'m' ,'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        for (int i = 0; i < this.howMany; i++){
            int index = rand.nextInt(26);
            System.out.print(letters[index] + " ");
        }

    }


}