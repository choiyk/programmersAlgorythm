package javaCodingInterview.Chapter9;

public class GetBitValue {
    public int solution(int n, int k) {
        return (n >> k) & 1;
    }
}
