import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> memory = new HashMap<>();//메모리주소 : 메모리값 해시맵
        Method Method = new Method();
        while (true) {
            String[] input = br.readLine().split(" ");
            System.out.println(Arrays.toString(Method.decode(input)));
        }


    }
}