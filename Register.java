import java.util.HashMap;

public class Register {
    static String PC;
    String registerIn;
    int registerOut;
    static HashMap<String, Integer> registerMap = new HashMap<>();//레지스터위치값 : 임시로올릴값 (정수만 올릴수있다)

    void onRegister(String[] input) {//레지스터에는 001과 같은 레지스터의 위치값
        Memory Memory = new Memory();
        ALU ALU = new ALU();
        int memoryAddress;
        switch (input[0]) {
            case "0001"://LOAD_R     0001--dst.Reg--base.Reg--000--offset.Reg
                memoryAddress = ALU.ADD(registerMap.get(input[2]), registerMap.get(input[4]));//base.Reg + offset.Reg
                registerIn = Memory.MemoryIntegerOutput(memoryAddress);//메모리 밸류가 string형
                if (registerIn == null) {//레지스터로 들어오는 값이 string이므로 비었을때 null이 반환되므로
                    registerIn = Integer.toString(0);//정수 0으로 넣어준다 (레지스터는 정수만 받을 수 있다)
                }
                registerMap.put(input[1], Integer.parseInt(registerIn));//dst.Reg에 정수형으로 올림
                break;
            case "0010"://LOAD_V     0010--dst.Reg--base.Reg--1--offset.value(5bit)
                memoryAddress = ALU.ADD(registerMap.get(input[2]), Integer.parseInt(input[4], 2));//base.Reg + offset.Reg
                registerIn = Memory.MemoryIntegerOutput(memoryAddress);
                if (registerIn == null) {
                    registerIn = Integer.toString(0);
                }
                registerMap.put(input[1], Integer.parseInt(registerIn));//dst.Reg에 정수형으로 올림
                break;
            case "0011"://STORE_R
                memoryAddress = ALU.ADD(registerMap.get(input[2]), registerMap.get(input[4]));//base.Reg + offset.Reg
                registerOut = registerMap.get(input[1]);
                Memory.MemoryStringsInput(Integer.toString(memoryAddress), Integer.toString(registerOut));//?????
                break;
            case "0100"://STORE_V
                memoryAddress = ALU.ADD(registerMap.get(input[2]), Integer.parseInt(input[4], 2));//base.Reg + offset.Reg
                registerOut = registerMap.get(input[1]);
                Memory.MemoryStringsInput(Integer.toString(memoryAddress), Integer.toString(registerOut));
                break;
            case "0101"://AND
                registerMap.put(input[1], (ALU.AND(registerMap.get(input[2]), registerMap.get(input[4]))));
                break;
            case "0110"://OR
                registerMap.put(input[1], (ALU.OR(registerMap.get(input[2]), registerMap.get(input[4]))));
                break;
            case "0111"://ADD_R
                registerMap.put(input[1], (ALU.ADD(registerMap.get(input[2]), registerMap.get(input[4]))));
                break;
            case "1000"://ADD_V
                registerMap.put(input[1], (ALU.ADD(registerMap.get(input[2]), Integer.parseInt(input[4], 2))));
                break;
            case "1001"://SUB_R
                registerMap.put(input[1], (ALU.SUB(registerMap.get(input[2]), registerMap.get(input[4]))));
                break;
            case "1010"://SUB_V
                registerMap.put(input[1], (ALU.SUB(registerMap.get(input[2]), Integer.parseInt(input[4], 2))));
                break;
            case "1011"://MOV
                registerMap.put(input[1], Integer.parseInt(input[2], 2));
                break;

        }
    }
}

class ALU {
    int ADD(int a, int b) {
        return a + b;
    }

    int SUB(int a, int b) {
        return a - b;
    }

    int AND(int a, int b) {
        return a & b;
    }

    int OR(int a, int b) {
        return a | b;
    }
}