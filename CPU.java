import java.util.Scanner;

public class CPU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 16; i++) {//메모리 틀
            Memory.memoryMap.put("0x000" + Integer.toHexString(i), null);
        }
        for (int i = 16; i <= 162; i++) {
            Memory.memoryMap.put("0x00" + Integer.toHexString(i), null);
        }

        Register.registerMap.put("001", 0);//레지스터 틀
        Register.registerMap.put("010", 0);
        Register.registerMap.put("011", 0);
        Register.registerMap.put("100", 0);
        Register.registerMap.put("101", 0);
        Register.registerMap.put("110", 0);
        Register.registerMap.put("111", 0);

        new Command().commandList();//명령어 리스트 출력

        if (Register.PC == null) {
            Register.PC = "0x00000";
        }
        out:
        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.length() > 16) {
                new Memory().putCmdOnMemory(input);//명령을 메모리에 올려기
            } else if (input.length() < 6) {
                switch (input) {
                    case "reset":
                        new CPU().reset();
                        break;
                    case "fetch":
                        String order = new CPU().fetch(Register.PC);//메모리에서 프로그램 명령어를 가져와서 리턴
                        Memory.num += 16;
                        Register.PC = "0x00" + Integer.toHexString(Memory.num);//PC카운트 1증가
                        new CPU().execute(order);// 리턴 후 execute
                        break;
                    case "dump":
                        new CPU().dump();
                        break;
                    case "close":
                        System.out.println("---end---");
                        break out;
                    default:
                        System.out.println("COMMAND IS WRONG");
                        break;
                }
            } else System.out.println("COMMAND IS WRONG");
        }
    }

    //--------------------------------------------------------------------------------------------
    String fetch(String pc) {
        return new Memory().getMemoryMapVal(pc);
    }

    void execute(String order) { //어떤 명령인지 분석해서 계산하거나 처리
        new Register().putOnRegister(order);
    }

    void reset() {//레지스터 값을 모두 지우고, PC 값도 0으로 초기화
        Register.registerMap.put("001", 0);
        Register.registerMap.put("010", 0);
        Register.registerMap.put("011", 0);
        Register.registerMap.put("100", 0);
        Register.registerMap.put("101", 0);
        Register.registerMap.put("110", 0);
        Register.registerMap.put("111", 0);
        Register.PC = Integer.toString(0);
    }

    void dump() {//레지스터들 값을 배열에 넣어서 리턴한다.
        System.out.println("R1" + ":" + Register.registerMap.get("001"));
        System.out.println("R2" + ":" + Register.registerMap.get("010"));
        System.out.println("R3" + ":" + Register.registerMap.get("011"));
        System.out.println("R4" + ":" + Register.registerMap.get("100"));
        System.out.println("R5" + ":" + Register.registerMap.get("101"));
        System.out.println("R6" + ":" + Register.registerMap.get("110"));
        System.out.println("R7" + ":" + Register.registerMap.get("111"));
    }
}