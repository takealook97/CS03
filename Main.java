import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> memory = new HashMap<>();//메모리주소 : 메모리값 해시맵
        HashMap<String, String> register = new HashMap<>();
        CPU cpu = new CPU();
        while (true) {
            String[] input = br.readLine().split(" ");
            memory.put(input[0], cpu.bitcode(input));

        }


//            switch (input[1]) {//메모리주소 - instruction - reg~
//                case "LOAD":
//                    if(input[4].charAt(0) == 'R'){
//
//                    }
//                    break;
//                case "STORE":
//
//                    break;
//                case "AND":
//
//                    break;
//                case "OR":
//
//                    break;
//                case "ADD":
//
//                    break;
//                case "SUB"://Substraction
//
//                    break;
//                case "MOV"://Move data
//                    input[2]
//                    break;
//                default :
//                    System.out.println("WRONG INSTRUCTION");
//            }
    }
}