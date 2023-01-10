import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPU {//todo 메모리에 명령어도 다 올라가야 한다

    public static void main(String[] args) throws IOException {
        Command Command = new Command();

        Memory Memory = new Memory();
        for (int i = 0; i <= 162; i++) {
            Memory.memoryMap.put("0x00" + Integer.toHexString(i), "0");//메모리틀
        }

        Register Register = new Register();//레지스터 틀
        Register.registerMap.put("001", 0);
        Register.registerMap.put("010", 0);
        Register.registerMap.put("011", 0);
        Register.registerMap.put("100", 0);
        Register.registerMap.put("101", 0);
        Register.registerMap.put("110", 0);
        Register.registerMap.put("111", 0);

        Command.commandList();//명령어 리스트 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out:
        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split(" ");
            if (input.length > 1) {
                Register.onRegister(input);
            } else if (input.length == 1) {
                switch (input[0]) {
                    case "reset":
                        reset();
                        break;
                    case "fetch":
                        fetch();
                        break;
                    case "execute":
                        execute();
                        break;
                    case "dump":
                        dump();
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
    static Register Register = new Register();//레지스터 틀
    Memory Memory = new Memory();

    static void fetch() {
        System.out.println(Register.PC);//현재 PC 값에 해당하는 메모리에서 프로그램 명령어를 가져와서 리턴
//        execute(Register.PC);//fetch에서 리턴한 명령을 execute에 넘겨준다
        Register.PC += 1;//PC 카운트를 +1 증가
    }

    static void execute() { //어떤 명령인지 분석해서 계산하거나 처리

    }

    static void reset() {//레지스터 값을 모두 지우고, PC 값도 0으로 초기화
        Register.registerMap.put("001", 0);
        Register.registerMap.put("010", 0);
        Register.registerMap.put("011", 0);
        Register.registerMap.put("100", 0);
        Register.registerMap.put("101", 0);
        Register.registerMap.put("110", 0);
        Register.registerMap.put("111", 0);
        Register.PC = Integer.toString(0);
    }

    static void dump() {//레지스터들 값을 배열에 넣어서 리턴한다.
        System.out.println("R1" + ":" + Register.registerMap.get("001"));
        System.out.println("R2" + ":" + Register.registerMap.get("010"));
        System.out.println("R3" + ":" + Register.registerMap.get("011"));
        System.out.println("R4" + ":" + Register.registerMap.get("100"));
        System.out.println("R5" + ":" + Register.registerMap.get("101"));
        System.out.println("R6" + ":" + Register.registerMap.get("110"));
        System.out.println("R7" + ":" + Register.registerMap.get("111"));
    }
}