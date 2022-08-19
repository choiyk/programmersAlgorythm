package javaCodingInterview.Chapter8;

public class Hanoi {
    public void solution(int n) {
        hanoi(n, 'A', 'B', 'C');
    }

    private void hanoi(int n, char start, char middle, char end) {
        if(n == 1) {
            System.out.println(start + " -> " + end);
            return;
        }

        hanoi(n-1, start, end, middle);
        System.out.println(start + " -> " + end);
        hanoi(n-1, middle, start, end);
    }
}
