public class Solution {
  public static void main(String[] args) {
    final Philosopher[] philosophers = new Philosopher[5];
    Fork[] forks = new Fork[] {new Fork(),new Fork(),new Fork(),new Fork(),new Fork()};

    for (int i = 0; i < 5; i++) {
      Fork leftFork = forks[i];
      Fork rightFork = forks[(i + 1) % forks.length];

      if (i == philosophers.length - 1) {
        philosophers[i] = new Philosopher(i + 1, rightFork, leftFork);
      } else {
        philosophers[i] = new Philosopher(i + 1, leftFork, rightFork);
      }

      Thread thread = new Thread(philosophers[i]);
      thread.start();
    }
  }
}