import java.util.HashMap;

public class Memory {//todo 메모리에 명령어도 다 올라가야 한다
    static int num;
    static HashMap<String, String> memoryMap = new HashMap<>();//메모리주소 : 메모리값 해시맵

    void putCmdOnMemory(String input) {
        if (num == 0) {//메모리에 비트코드 명령 올리기
            memoryMap.put("0x0000", input);
        } else memoryMap.put("0x00" + Integer.toHexString(num), input);

    }

    void putOnMemory(String address, String value) {
        memoryMap.put(address, value);
    }

    String getMemoryMapVal(int input) {
        String Num2HexString = "0x00" + Integer.toHexString(input);
        return memoryMap.get(Num2HexString);
    }

    String getMemoryMapVal(String input) {//fetch 할 때 메모리 맵에서 get
        if (input == null) {
            input = "0x0000";
        }
        return memoryMap.get(input);
    }
}