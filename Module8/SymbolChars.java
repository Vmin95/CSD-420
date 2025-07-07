import java.util.Random;

public class SymbolChars implements Runnable {
    int howMany;

    SymbolChars(){
        this.howMany = 10;
    }

    SymbolChars(int howMany){
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
        char[] symbols = {'@', '+', '<', '>', '*', '#', '%', '!', '$', '&', '?'};
        
        for (int i = 0; i < this.howMany; i++){
            int index = rand.nextInt(11);
            System.out.print(symbols[index] + " ");
        }

    }

}