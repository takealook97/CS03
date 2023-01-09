🎯 CS03 CPU 시뮬레이터
-

# CPU개념

- cpu에는 수십억개의 트랜지스터가 들어있다
- cpu에는 Mosfet이라는 트랜지스터가 들어가있는데 미세먼지보다도 작다.
- 모스펫들이 모여 많은 논리게이트를 이루고 연산을 수행하고 있다.
- 하드디스크는 너무 느려서 cpu와 소통하지 않는다. cpu는 램과 소통한다.
- 프로그램 실행 -> 램으로 데이터 이동 -> cpu로 데이터 이동
    - 그러나 램도 cpu에 비해 느리기 때문에 캐시메모리를 만들어 데이터 저장
    - 캐시 메모리는 램에 비하면 용량이 작아서 중요한 데이터만 저장하여 사용
- 캐시 메모리는 Level 1 ~ Level 3 3단계로 이루어져 있다
    - L1 캐시 = 속도 빠르고 용량 작음 / L3 캐시 = 속도 느리고 용량 큼
- cpu는 캐시메모리 1,2,3을 순차적으로 데이터를 요청하는데 없으면 램으로 간다.
- 기억장치 : 하드, 램, 캐시메모리, 레지스터
    - 레지스터 : cpu 내부에서 일시적으로 데이터 저장하는 공간으로 속도 가장 빠름
    - SSD - RAM - CACHE - REGISTER 순으로 속도도 빠르고 가격도 비싸다.

## 레지스터의 종류

1. 프로그램 카운터 : 다음에 수행 할 메모리의 주소가 들어있다.
2. 메모리 주소 레지스터 : 프로그램 카운터에서 수행할 주소를 넘겨받은 뒤
   그 주소를 찾아가 데이터를 가져오는 역할
3. 메모리 버퍼 레지스터 : 메모리 주소 레지스터가 가져온 데이터나 명령들을
   일시적으로 저장
   - 위에서 받은 내용 중 명령은 명령어 레지스터로 전송되고
     연산에 사용될 데이터는 누산기 레지스터로 이동
4. 명령어 레지스터 : 명령에 관한 데이터가 저장된다.
5. 누산기 레지스터 : 연산의 결과값이나 중간값을 일시적으로 저장한다.
   - *최종 결과는 메모리 버퍼 레지스터를 통해 메모리로 전송된다.*
6. 제어장치 : 명령어 레지스터에 있는 명령을 받아 해석하고 해석된 명령을 시스템에 지시
7. ALU : 산술 논리 연산 실행

### 예시
- C = A + B (고급 프로그래밍 언어로 만들어진 코드)
- 컴파일 과정을 거쳐 어셈블리어로 바뀜
  - LOAD [10], ADD [11], STORE [12]
- 10번지 메모리에 있는 데이터를 읽어와서 11번지의 값과 더한 다음 12번지에 저장
- 어셈블리어는 약속된 규칙에 따라 기계어로 바뀌게 된다.
  - 100110 0000001010, 110011 0000001011, 111010 0000001100
  - 6비트 명령어와 10비트 데이터로 이루어져 있다. -> 한 줄이 16비트인 16비트 언어
  - 기계어는 램에 저장된다. 램은 8비트 씩 저장되기 때문에 각각 두 줄로 저장된다.
  - 두 줄이 프로세서가 한번에 처리할 수 있는 하나의 언어이다.
  - 32비트=4줄, 64비트=8줄 이다.
### cpu 처리 과정
- 프로그램 카운터 레지스터에 가져와야 할 메모리 주소가 있다. ex) 100
- 주소는 메모리 주소 레지스터로 전달된다.
- 메모리 주소 레지스터는 100번지에 있는 데이터를 가져와 메모리 버퍼 레지스터에 저장
  - = FETCH (인출)
- LOAD [10] = 메모리 10번지에 있는 데이터를 가져오라는 명령
- 명령어 레지스터로 이동
- 프로그램 카운터 +2 = 102
  - 32비트 프로세서는 메모리 4칸 한번에 처리할 수 있기에 +4
- 명령어 레지스터에 저장된 명령은 제어장치로 이동되어 해석된다.
  - = DECODE (해석)
- LOAD [10] = 10번지 주소에 있는 데이터를 읽어오라는 명령
- 메모리 주소 레지스터에 10이 입력되고 10번지의 데이터를 읽어와서 메모리 버퍼 레지스터에 저장
- 10번지에 저장된 값은 명령아가 아닌 데이터 -> 누산기 레지스터에 저장 (2)
- 