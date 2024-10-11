public class TestThread extends Thread{
    public TestThread(String number){
        super(number);
    }

    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.print(this.getName());
        }
    }

    public static void main(String[] args) {
        TestThread one = new TestThread("1-");
        TestThread two = new TestThread("2--");
        TestThread three = new TestThread("3---");
        TestThread four = new TestThread("4----");
        TestThread five = new TestThread("5-----");

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
    }
}
