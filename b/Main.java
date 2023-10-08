package lab5_b;

import java.util.concurrent.CyclicBarrier;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_THREADS);
        Checker swapper = new Checker(NUMBER_OF_THREADS);

        Thread firstChanger = new Thread(new Swapper("ACDCADCACDC", barrier, swapper, 1));
        Thread secondChanger = new Thread(new Swapper("AAACAACBBAC", barrier, swapper, 2));
        Thread thirdChanger = new Thread(new Swapper("ABCDCDAABCD", barrier, swapper, 3));
        Thread fourthChanger = new Thread(new Swapper("CDABBABCDAB", barrier, swapper, 4));

        firstChanger.start();
        secondChanger.start();
        thirdChanger.start();
        fourthChanger.start();
    }
}