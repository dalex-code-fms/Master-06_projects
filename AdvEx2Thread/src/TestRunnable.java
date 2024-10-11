import java.util.Collections;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int nb = 33 + i;
            System.out.println((char)nb + String.join("",Collections.nCopies(i + 1, "*")) + (char)nb);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TestRunnable());
        thread.start();

    }
}
