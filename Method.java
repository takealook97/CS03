public class Method {
    Register Register = new Register();
    Memory Memory = new Memory();

    void fetch() {
        System.out.println(Register.PC);//현재 PC 값에 해당하는 메모리에서 프로그램 명령어를 가져와서 리턴
//        execute(Register.PC);//fetch에서 리턴한 명령을 execute에 넘겨준다
        Register.PC += 1;//PC 카운트를 +1 증가
    }


    void execute() { //어떤 명령인지 분석해서 계산하거나 처리

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
