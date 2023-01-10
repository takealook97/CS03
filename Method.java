import java.util.HashMap;

public class Method {

    int fetch() {//현재 PC 값에 해당하는 메모리에서 프로그램 명령어를 가져와서 리턴, PC카운트 1증가

        return 0;
    }


    void decode() {

    }

    void execute() { //어떤 명령인지 분석해서 계산하거나 처리

    }

    void reset() {//레지스터 값을 모두 지우고, PC 값도 0으로 초기화

    }

    void dump() {//레지스터들 값을 배열에 넣어서 리턴한다.

        System.out.println(register.toString());
    }
}
