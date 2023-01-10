import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPU {//todo 메모리에 명령어도 다 올라가야 한다

    public static void main(String[] args) throws IOException {
        Command Command = new Command();
        Command.commandList();
        ALU ALU = new ALU();

        Memory Memory = new Memory();
        for (int i = 0; i <= 162; i++) {
            Memory.memoryMap.put("0x00" + Integer.toHexString(i), null);//메모리틀
        }

        Register Register = new Register();//레지스터 틀
        Register.registerMap.put("001", 0);
        Register.registerMap.put("010", 0);
        Register.registerMap.put("011", 0);
        Register.registerMap.put("100", 0);
        Register.registerMap.put("101", 0);
        Register.registerMap.put("110", 0);
        Register.registerMap.put("111", 0);


        Method Method = new Method();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split(" ");
            if (input.length > 1) {
                Register.onRegister(input);
            } else if (input.length == 1) {
                switch (input[0]) {
                    case "reset" :
                        Method.reset();
                    case "fetch" :
                        Method.fetch();
                    case "execute" :
                        Method.execute();
                    case "dump" :
                        Method.dump();
                }
            }


//            System.out.println("DECODE : " + Arrays.toString(Decoder.decode(input)));
//            register.put(Decoder.regDecode(input[1]),  //todo 임시로 올릴값)

        }
    }
}