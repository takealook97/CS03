import java.util.HashMap;

public class Register {
    static String[] inputArr;
    static String PC = "0x00000";//pc 초기값 = 0
    String registerIn;
    int registerOut;
    static HashMap<String, Integer> registerMap = new HashMap<>();//레지스터위치값 : 임시로올릴값 (정수만 올릴수있다)

    void putOnRegister(String input) {//레지스터에는 001과 같은 레지스터의 위치값
        //문자열로 들어온 input을 다시 문자열 배열로 변환해주어야 한다.
        Memory memory = new Memory();
        ALU alu = new ALU();
        int memoryAddress;
        switch (inputArr[0]) {
            case "0001"://LOAD_R     0001--dst.Reg--base.Reg--000--offset.Reg
                memoryAddress = alu.add(registerMap.get(inputArr[2]), registerMap.get(inputArr[4]));//base.Reg + offset.Reg
                registerIn = memory.getMemoryMapVal(memoryAddress);//메모리 밸류가 string형
                if (registerIn == null) {//레지스터로 들어오는 값이 string이므로 비었을때 null이 반환되므로
                    registerIn = Integer.toString(0);//정수 0으로 넣어준다 (레지스터는 정수만 받을 수 있다)
                }
                registerMap.put(inputArr[1], Integer.parseInt(registerIn));//dst.Reg에 정수형으로 올림
                break;
            case "0010"://LOAD_V     0010--dst.Reg--base.Reg--1--offset.value(5bit)
                memoryAddress = alu.add(registerMap.get(inputArr[2]), Integer.parseInt(inputArr[4], 2));//base.Reg + offset.Reg
                registerIn = memory.getMemoryMapVal(memoryAddress);
                if (registerIn == null) {
                    registerIn = Integer.toString(0);
                }
                registerMap.put(inputArr[1], Integer.parseInt(registerIn));//dst.Reg에 정수형으로 올림
                break;
            case "0011"://STORE_R
                memoryAddress = alu.add(registerMap.get(inputArr[2]), registerMap.get(inputArr[4]));//base.Reg + offset.Reg
                registerOut = registerMap.get(inputArr[1]);
                memory.putOnMemory(Integer.toString(memoryAddress), Integer.toString(registerOut));//?????
                break;
            case "0100"://STORE_V
                memoryAddress = alu.add(registerMap.get(inputArr[2]), Integer.parseInt(inputArr[4], 2));//base.Reg + offset.Reg
                registerOut = registerMap.get(inputArr[1]);
                memory.putOnMemory(Integer.toString(memoryAddress), Integer.toString(registerOut));
                break;
            case "0101"://AND
                registerMap.put(inputArr[1], (alu.and(registerMap.get(inputArr[2]), registerMap.get(inputArr[4]))));
                break;
            case "0110"://OR
                registerMap.put(inputArr[1], (alu.or(registerMap.get(inputArr[2]), registerMap.get(inputArr[4]))));
                break;
            case "0111"://ADD_R
                registerMap.put(inputArr[1], (alu.add(registerMap.get(inputArr[2]), registerMap.get(inputArr[4]))));
                break;
            case "1000"://ADD_V
                registerMap.put(inputArr[1], (alu.add(registerMap.get(inputArr[2]), Integer.parseInt(inputArr[4], 2))));
                break;
            case "1001"://SUB_R
                registerMap.put(inputArr[1], (alu.sub(registerMap.get(inputArr[2]), registerMap.get(inputArr[4]))));
                break;
            case "1010"://SUB_V
                registerMap.put(inputArr[1], (alu.sub(registerMap.get(inputArr[2]), Integer.parseInt(inputArr[4], 2))));
                break;
            case "1011"://MOV
                registerMap.put(inputArr[1], Integer.parseInt(inputArr[2], 2));
                break;

        }
    }
}

class ALU {
    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int and(int a, int b) {
        return a & b;
    }

    int or(int a, int b) {
        return a | b;
    }
}