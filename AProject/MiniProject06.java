package AProject;

/*
    강희진

    문제06
    “가상 선거 및 당선 시뮬레이션 프로그램”
    - 수행 목적 : 조건문 및 반복문과 배열(or 컬렉션)을 통한 당선 시뮬레이션 로직 작성
    - 간략 소개 : 민주주의에서 선거를 대단히 중요한 의사 표현입니다. 이런 선거를 미리 시뮬레이
    션을 통해서 진행하는 프로그램을 만들어 보고자 합니다. 전체 투표수와 후보자를 입력받아서
    그 결과를 미리 확인하는 선거 및 당선 시뮬레이션 프로그램을 만들어 보세요.

    필수 준수사항
    1. 총 투표를 진행할 투표수를 입력 받음
    2. 선거를 진행할 후보자 수를 입력 받고, 이에 대한 이름을 입력 받음
    3. 각 입력받은 후보자는 순서대로 기호1, 기호2, 기호3… 형식으로 기호번호 부여함
    4. 각 투표수의 결과는 선거를 진행할 후보자를 동일한 비율로 랜덤하게 발생
    5. 임의번호는 Random함수의 nextInt()함수를 통해서 생성
    6. 1표에 대한 투표한 결과에 대해서 투표자와 이에 대한 결과를 화면 출력해야 함

    아래 내용은 전제조건으로 진행
    - 투표수는 1 ~ 10000 사이의 값을 입력하며, 그외 값 입력에 대한 예외는 없다고 가정함.
    - 후보자 인원은 2 ~ 10 사이의 값을 입력받으면, 그외 값 입력에 대한 예외는 없다고 가정함.
    - 후보자이름은 한글로 입력하며, 10자 미만으로 입력함. (역시, 그외 입력에 대한 예외는 없다고
    가정함.)
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MiniProject06 {
    static Scanner sc = new Scanner(System.in);

    // 후보자 입력 및 리스트 생성
    public static ArrayList<String> candiList(int candiCnt) {

        ArrayList<String> candiList = new ArrayList<>();

        for (int i = 0; i < candiCnt; i++) {
            System.out.printf("%d번째 후보자 이름을 입력해 주세요: ", i + 1);
            String name = sc.nextLine();
            candiList.add(name);
        }
        System.out.println();

        return candiList;
    }

    public static void isVoting(int voteCtn, int candiCnt,ArrayList<String> candiList) {
        Random random = new Random();
        ArrayList<String> cntList = candiList;
        ArrayList list = new ArrayList<>();

        int num = random.nextInt(candiCnt); // 3 中 1 =>2




        for (int i = 0; i < 0; i++) {

            System.out.printf("[기호:%d] %s: %.02f%% \t(투표수: %d)");
        }

    }

    public static void main(String[] args) {

        System.out.print("총 진행할 투표수를 입력해 주세요: ");
        int voteCtn = sc.nextInt();

        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요: ");
        int candiCnt = sc.nextInt();
        sc.nextLine();

        ArrayList<String> candiList = candiList(candiCnt);

        System.out.println("[투표진행률]: ");
        isVoting(voteCtn, candiCnt, candiList);


        System.out.println("[투표결과] 당선인 : ");
    }
}
