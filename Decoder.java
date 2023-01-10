import java.util.HashMap;

public class Decoder {
//    String[] decode(String[] input) {
//        switch (input[0]) {
//            case "0001", "0011", "0101", "0110", "0111", "1001" -> {
//                String[] decode = {instDecode(input[0]), regDecode(input[1]),
//                        regDecode(input[2]), regDecode(input[4])};
//                return decode;
//            }
//            case "0010", "0100", "1000", "1010" -> {
//                String[] decode = {instDecode(input[0]), regDecode(input[1]),
//                        regDecode(input[2]), valDecode(input[4])};
//                return decode;
//            }
//            case "1011" -> {
//                String[] decode = {instDecode(input[0]), regDecode(input[1]),
//                        valDecode(input[2])};
//                return decode;
//            }
//        }
//        return input;
//    }

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

    int valDecode(String input) {
        return Integer.parseInt(input, 2);
    }

}
