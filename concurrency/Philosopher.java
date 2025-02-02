import java.util.Random;

public class Philosopher implements Runnable {

  private static Random random = new Random();

  private final int num;
  private Fork left;
  private Fork right;

  public Philosopher(int num, Fork left, Fork right) {
    this.num = num;
    this.left = left;
    this.right = right;
  }

  @Override
  public void run() {
    try {
      while (true) {
        think();
        synchronized (left) {
          pickUpLeftFork();
          synchronized (right) {
            pickUpRightFork();
            eat();
            putDownRightFork();
          }
          putDownLeftFork();
        }
      }
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      return;
    }
  }

  private void putDownLeftFork() {
    System.out.println("Philosopher " + num + " put down the left fork");
  }

  private void putDownRightFork() {
    System.out.println("Philosopher " + num + " put down the right fork");
  }

  private void think() throws InterruptedException {
    int time = random.nextInt(500, 1001);
    System.out.println("Philosopher " + num + " is now thinking for " + time + " milliseconds");
    Thread.sleep(random.nextInt(time));
  }

  private void pickUpLeftFork() {
    System.out.println("Philosopher " + num + " picked up the left fork");
  }

  private void pickUpRightFork() {
    System.out.println("Philosopher " + num + " picked up the right fork");
  }

  private void eat() throws InterruptedException {
    //int time = (int) (Math.random() * 100);
    int time = random.nextInt(500, 1001);
    System.out.println("Philosopher " + num + " is now eating for " + time + " milliseconds");
    Thread.sleep(random.nextInt(time));
  }
}
