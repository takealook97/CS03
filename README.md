🎯 CS03 CPU
-

## CPU개념
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
![image](https://user-images.githubusercontent.com/118447769/211250689-f4e7f7db-14e4-4250-8f6a-0f1980c5993b.png)
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

---
## 예시
- C = A + B (고급 프로그래밍 언어로 만들어진 코드)
- 컴파일 과정을 거쳐 어셈블리어로 바뀜
  - LOAD [10], ADD [11], STORE [12] 

    ![image](https://user-images.githubusercontent.com/118447769/211250541-c78a483a-d0af-4f70-a511-e9d29139dc99.png)
- 10번지 메모리에 있는 데이터를 읽어와서 11번지의 값과 더한 다음 12번지에 저장
- 어셈블리어는 약속된 규칙에 따라 기계어로 바뀌게 된다.
  - 100110 0000001010, 110011 0000001011, 111010 0000001100
  - 6비트 명령어와 10비트 데이터로 이루어져 있다. -> 한 줄이 16비트인 16비트 언어
  - 기계어는 램에 저장된다. 램은 8비트 씩 저장되기 때문에 각각 두 줄로 저장된다.
  - 두 줄이 프로세서가 한번에 처리할 수 있는 하나의 언어이다.
  - 32비트=4줄, 64비트=8줄
---
### cpu 처리 과정
![image](https://user-images.githubusercontent.com/118447769/211253076-5c8c13d5-3732-4850-b1ac-0f0946500bc5.png)
- 프로그램 카운터 레지스터에 가져와야 할 메모리 주소가 있다. ex) 100
- 주소는 메모리 주소 레지스터로 전달된다.
- 메모리 주소 레지스터는 100번지에 있는 데이터를 가져와 메모리 버퍼 레지스터에 저장
  - = 1. FETCH (인출)
- LOAD [10] = 메모리 10번지에 있는 데이터를 가져오라는 명령
- 명령어 레지스터로 이동
- 프로그램 카운터 +2 = 102
  - 32비트 프로세서는 메모리 4칸 한번에 처리할 수 있기에 +4
- 명령어 레지스터에 저장된 명령은 제어장치로 이동되어 해석된다.
  - = 2. DECODE (해석)
- LOAD [10] = 10번지 주소에 있는 데이터를 읽어오라는 명령
- 메모리 주소 레지스터에 10이 입력되고 10번지의 데이터를 읽어와서 메모리 버퍼 레지스터에 저장
- 10번지에 저장된 값은 명령어가 아닌 데이터 -> 누산기 레지스터에 저장 (2)
  - *--LOAD [10] CLEAR--*
---
- 메모리 주소 레지스터로 프로그램 카운터에 저장된 주소 102 를 가져온다.
- 102 주소에 있는 102,103(8비트 두줄)정보가 메모리 버퍼 레지스터에 들어온다.
  - = ADD [11] = 11번지 주소값을 더하라는 명령
- 명령어 레지스터로 이동, 프로그램 카운터 +2
- 명령어는 제어장치로 이동되어 해석된다.
- 더하기 명령을 실행하기 위해서 누산기 레지스터에 저장된 데이터는 ALU(산술논리장치)로 이동
- 메모리 주소 레지스터에 11번지 주소가 입력되고 11번지에 있는 데이터를 메모리 버퍼 레지스터에 저장(3)
- 3은 명령어가 아닌 데이터 이므로 누산기 레지스터에 입력된다.
- 산술 논리장치 ALU에서 처리되고 결과값 5는 다시 누산기 레지스터에 저장된다.
  - = 3. EXECUTE (실행)
- 이 모든 과정은 제어장치에 의해 컨트롤된다.
  - *--ADD [11] CLEAR--*
---
- 메모리 주소 레지스터에 있는 주소 104,105를 찾아가 데이터를 가져온다.
- 저장하라는 명령 STORE [12] 이기 때문에 명령어 레지스터로 이동
- 프로그램 카운터 +2
- 저장하라는 명령어가 제어장치에서 해석된다.
- 12번지 메모리에 계산된 값을 저장하기 위해서 메모리 주소 레지스터에 12 저장
- 누산기 레지스터에 저장된 값은 메모리 버퍼 레지스터를 통해 12번지 메모리에 저장
  - = 4. STORE (저장)
  - *--STORE [12] CLEAR--*
---
## 정리
- cpu는 데이터를 '**인출-해석-실행-저장**'하는 과정을 거친다.
- 실제로 cpu는 이 단계들 조차 세분화해서 사용한다.
- 이렇게 분리된 각각의 프로세스를 '스레드'라고 한다.
- 코어 하나에 여러개의 스레드가 실행되면 속도가 빨라진다.
- 코어가 많아지면 속도는 더 빨라진다.
- 프로세서의 구조(아키텍쳐)는 회사마다 다르다.
---
## 용어
- dst : destination (목적지)
- src : source
- base : 베이스 레지스터
- offset : 기준 주소에서 얼마큼 떨어진 주소를 가르킬때 쓰는 말
- op : operation
---
# Mission. CPU 시뮬레이터
## 명령 로직
  ![스크린샷 2023-01-11 오전 8 47 14](https://user-images.githubusercontent.com/118447769/211685909-d1773830-6ab0-4195-85d4-7b7e64f165d3.png)
---
## 구현 이미지
  ![스크린샷 2023-01-12 오전 6 29 49](https://user-images.githubusercontent.com/118447769/211922086-1a5781a4-2fd8-4630-95dc-f5579668684d.png)

