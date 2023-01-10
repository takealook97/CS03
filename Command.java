public class Command {
    void commandList (){
        System.out.println("_________________________________________________________________________");
        System.out.println("|          ORDER           |    | MEMORY ADDRESS |   COMMAND SEQUENCE   |");
        System.out.println("| 0x0000b MOV R4, 0x00A0   | -> |     0x0000     | 1011 100 000010000   |");
        System.out.println("| 0x0010b MOV R5, 0x0002   | -> |     0x0010     | 1011 100 000000010   |");
        System.out.println("| 0x0020b LOAD R1, R4, R5  | -> |     0x0020     | 0001 001 100 000 101 |");
        System.out.println("| 0x0030b ADD R2, R1, #4   | -> |     0x0030     | 1000 010 001 1 00010 |");
        System.out.println("| 0x0040b SUB R3, R1, R2   | -> |     0x0040     | 1001 011 001 000 010 |");
        System.out.println("| 0x0050b STORE R3, R4, #4 | -> |     0x0050     | 0100 011 100 1 00100 |");
        System.out.println("|__________________________|____|________________|______________________|");
        System.out.println("INPUT COMMAND (16bit)");
    }
}
