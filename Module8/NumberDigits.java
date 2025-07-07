import java.util.Random;

public class NumberDigits implements Runnable{
    int howMany;

    NumberDigits(){
        this.howMany = 10;
    }

    NumberDigits(int howMany){
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
        
        for (int i = 0; i < this.howMany; i++){
            System.out.print(rand.nextInt(10) + " ");
        }

    }
}