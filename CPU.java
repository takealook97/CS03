import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPU {//todo 메모리에 명령어도 다 올라가야 한다

    public static void main(String[] args) throws IOException {
        Command Command = new Command();
        Memory Memory = new Memory();
        Command.commandList();

        ALU ALU = new ALU();
        Register Register = new Register();


        Decoder Decoder = new Decoder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split(" ");

//            System.out.println("DECODE : " + Arrays.toString(Decoder.decode(input)));
//            register.put(Decoder.regDecode(input[1]),  //todo 임시로 올릴값)

        }
    }
}