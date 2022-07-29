import java.util.Arrays;

public class Sizer {

    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= 'A' && arr[i] <= 'Z') {
                int temp = arr[i] + n;
                if(temp / ('Z'+1) > 0) arr[i] = (char)('A' + (temp % ('Z'+1)));
                else arr[i] = (char)temp;
            }
            else if(arr[i] >= 'a' && arr[i] <= 'z') {
                int temp = arr[i] + n;
                if(temp / ('z'+1) > 0) arr[i] = (char)('a' + (temp % ('z'+1)));
                else arr[i] = (char)temp;
            }
        }
        return String.valueOf(arr);
    }

    public String solution2(String s, int n) {
        n = n % 26;
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(Character.isLowerCase(arr[i]))
                arr[i] = (char)((arr[i] - 'a' + n) % 26 + 'a');
            else if(Character.isUpperCase(arr[i]))
                arr[i] = (char)((arr[i] - 'A' + n) % 26 + 'A');
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args){
        String s = "a B z";
        int n = 4;
        Sizer o = new Sizer();
        System.out.println(o.solution2(s, n));
    }
}
