import java.util.HashMap;

public class Register {
    String PC;
    int memoryAddress;
    String registerIn;
    int registerOut;

    void onRegister(String[] input) {//레지스터에는 001과 같은 레지스터의 위치값
        Memory Memory = new Memory();
        ALU ALU = new ALU();
        Decoder Decoder = new Decoder();
        HashMap<String, Integer> register = new HashMap<>();//레지스터위치값 : 임시로올릴값 (정수만 올릴수있다)
        register.put("001", 0);
        register.put("010", 0);
        register.put("011", 0);
        register.put("100", 0);
        register.put("101", 0);
        register.put("110", 0);
        register.put("111", 0);
        switch (input[0]) {
            case "0001"://LOAD_R
                memoryAddress = ALU.ADD(register.get(input[2]), register.get(input[4]));//base.Reg + offset.Reg
                registerIn = Memory.MemoryIntegerInput(memoryAddress);
                register.put(input[1], Integer.parseInt(registerIn));//dst.Reg에 정수형으로 올림
                break;
            case "0010"://LOAD_V
                memoryAddress = ALU.ADD(register.get(input[2]), Decoder.valDecode(input[4]));//base.Reg + offset.Reg
                registerIn = Memory.MemoryIntegerInput(memoryAddress);
                register.put(input[1], Integer.parseInt(registerIn));//dst.Reg에 정수형으로 올림
                break;
            case "0011"://STORE_R
                memoryAddress = ALU.ADD(register.get(input[2]), register.get(input[4]));//base.Reg + offset.Reg
                registerOut = register.get(input[1]);
                Memory.MemoryStringInput(Integer.toString(memoryAddress), Integer.toString(registerOut));
                break;
            case "0100"://STORE_V

                break;
            case "1011"://MOV
                register.put(input[1], Decoder.valDecode(input[2]));
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