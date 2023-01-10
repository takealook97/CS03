import java.util.Arrays;
import java.util.HashMap;

public class Memory {
    ALU ALU = new ALU();
    Register Register = new Register();
    static int num;
    static HashMap<String, String> memory = new HashMap<>();//메모리주소 : 메모리값 해시맵
    static void MemoryArrayInput(String[] input) {//넣을수도, 읽어올수도 있어야한다
        for (int i = 0; i <= 162; i++) {
            memory.put("0x00" + Integer.toHexString(i), null);//메모리주소 0~162 생성 후 null (메모리틀)
        }
        memory.put("0x00" + Integer.toHexString(num), Arrays.toString(input));//메모리에 비트코드 명령 올리기

//        num = ALU.ADD(num, 0x0010);
//        Register.PC = "0x00" + Integer.toHexString(num);//PC에 다음 메모리 주소 저장
    }

    void MemoryStringInput(String address, String value){
        memory.put(address,value);
    }

    String MemoryIntegerInput(int input){
        return memory.get(input);
    }
}
