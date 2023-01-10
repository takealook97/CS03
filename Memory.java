import java.util.Arrays;
import java.util.HashMap;

public class Memory {
    static int num;
    static HashMap<String, String> memoryMap = new HashMap<>();//메모리주소 : 메모리값 해시맵

    static void MemoryArrayInput(String[] input) {//넣을수도, 읽어올수도 있어야한다
        Register Register = new Register();
        String bitcode = "";
        for (int i = 0; i < input.length; i++) {
            bitcode += input[i];//배열을 합쳐서 16자리 비트코드로 만든다
        }
        String first = "";
        for (int i = 0; i < 8; i++) {//앞 8자리
            first += bitcode.charAt(i);
        }
        String second = "";
        for (int i = 8; i < 16; i++) {//뒤 8자리
            second += bitcode.charAt(i);
        }

        memoryMap.put("0x00" + Integer.toHexString(num), first);//메모리에 비트코드 명령 올리기
        memoryMap.put("0x00" + Integer.toHexString(num++), second);//메모리에 비트코드 명령 올리기
        num++;
        Register.PC = "0x00" + Integer.toHexString(num);//다음에 수행해야 할 명령어 주소 PC에 저장

//        num = ALU.ADD(num, 0x0010);
//        Register.PC = "0x00" + Integer.toHexString(num);//PC에 다음 메모리 주소 저장
    }

    void MemoryStringInput(String address, String value) {
        memoryMap.put(address, value);
    }

    String MemoryIntegerOutput(int input) {
        String Num2HexString = "0x00" + Integer.toHexString(input);
        return memoryMap.get(Num2HexString);
    }
}
