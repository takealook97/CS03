import java.util.ArrayList;
import java.util.HashMap;

public class Method {

    int fetch() {//현재 PC 값에 해당하는 메모리에서 프로그램 명령어를 가져와서 리턴, PC카운트 1증가

        return 0;
    }

    String[] decode(String[] input) {
        switch (input[0]) {
            case "0001", "0011", "0101", "0110", "0111", "1001" -> {
                String[] decode = {instDecode(input[0]), regDecode(input[1]),
                        regDecode(input[2]), regDecode(input[4])};
                return decode;
            }
            case "0010", "0100", "1000", "1010" -> {
                String[] decode = {instDecode(input[0]), regDecode(input[1]),
                        regDecode(input[2]), valDecode(input[4])};
                return decode;
            }
            case "1011" -> {
                String[] decode = {instDecode(input[0]), regDecode(input[1]),
                        regDecode(input[2])};
                return decode;
            }
        }
        return input;
    }

    String instDecode(String input) {
        HashMap<String, String> instruction = new HashMap<>();
        instruction.put("0001", "LOAD");
        instruction.put("0010", "LOAD");
        instruction.put("0011", "STORE");
        instruction.put("0100", "STORE");
        instruction.put("0101", "AND");
        instruction.put("0110", "OR");
        instruction.put("0111", "ADD");
        instruction.put("1000", "ADD");
        instruction.put("1001", "SUB");
        instruction.put("1010", "SUB");
        instruction.put("1011", "MOV");
        return instruction.get(input);
    }

    String regDecode(String input) {
        HashMap<String, String> registry = new HashMap<>();
        registry.put("001", "R1");
        registry.put("010", "R2");
        registry.put("011", "R3");
        registry.put("100", "R4");
        registry.put("101", "R5");
        registry.put("110", "R6");
        registry.put("111", "R7");
        return registry.get(input);
    }

    String valDecode(String input) {
        HashMap<String, String> registry = new HashMap<>();
        String binary = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                int startPoint = i;
                for (int j = startPoint; j < input.length(); j++) {
                    binary += input.charAt(i);
                }
                break;
            }
        }
        int num = Integer.parseInt(binary, 2);
        return Integer.toString(num);
    }

    void execute() { //어떤 명령인지 분석해서 계산하거나 처리

    }

    void reset() {//레지스터 값을 모두 지우고, PC 값도 0으로 초기화

    }

    void dump() {//레지스터들 값을 배열에 넣어서 리턴한다.

//        System.out.println(register.toString());
    }
}
