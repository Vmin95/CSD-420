public class JuliaThreeThreads {
    public static void main(String[] args) throws Exception {
        
        //create 
        Runnable printNumbers = new NumberDigits(10000);
        Runnable printLetters = new LetterChars(10000);
        Runnable printSymbols = new SymbolChars(10000);

        Thread thread1 = new Thread(printLetters);
        Thread thread2 = new Thread(printNumbers);
        Thread thread3 = new Thread(printSymbols);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}