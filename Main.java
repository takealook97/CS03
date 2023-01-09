import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> memory = new HashMap<>();//해시맵에 Register 3bit R1~R7 넣어준다
        memory.put("R1","001");
        for(int i = 2; i <= 3; i++){
            memory.put("R"+i, "0"+ Integer.toBinaryString(i));
        }
        for(int i = 4; i <= 7; i++){
            memory.put("R"+i, Integer.toBinaryString(i));
        }
        System.out.println(memory.toString());




        String[] input = br.readLine().split(" ");
        while (true) {
            switch (input[1]) {
                case "LOAD":

                    break;
                case "STORE":

                    break;
                case "AND":

                    break;
                case "OR":

                    break;
                case "ADD":

                    break;
                case "SUB"://Substraction

                    break;
                case "MOV"://Move data =

                    break;
                default :
                    System.out.println("WRONG INSTRUCTION");
            }

        }
    }
}
