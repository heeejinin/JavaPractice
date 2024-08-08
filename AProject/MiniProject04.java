package AProject;

/*
    강희진

    문제04
    “주민등록번호 생성 프로그램”
    - 간략 소개 : 주민번호는 출생년도와 출생월과 성별에 대한 내용을 포함하여 만들어지는 숫자
    로 된 체계입니다. 이에 2020년도 부터 생성 조건이 변경되었습니다. 이를 조건에 맞게 생성하
    는 프로그램을 작성해 보세요.
    - 입력값은 2020년도 이후로 입력한다는 전제로 작성해 주세요.

    필수 준수사항
    1. 주민등록번호 생성 로직에 맞게 주민등록번호 생성
    2. 입력값은 생년, 월, 일, 성별과 임의의 번호를 통해서 생성
    3. 임의번호는 Random함수의 nextInt()함수를 통해서 생성
    (임의 번호 범위는 1 ~ 999999사이의 값으로 설정)
*/


import java.util.Random;
import java.util.Scanner;


public class MiniProject04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 성별 번호
        int genNum;

        //임의 번호 1 ~ 999999사이의 값
        Random random = new Random();
        int randNum = random.nextInt(999999)+1;


        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("출생월을 입력해 주세요.(MM):");
        int month = sc.nextInt();
        sc.nextLine();

        System.out.print("출생년일을 입력해 주세요.(dd):");
        int day = sc.nextInt();
        sc.nextLine();

        System.out.print("성별을 입력해 주세요.(m/f):");
        String gender = sc.nextLine();

        // 연도의 마지막 두 자리 추출
        int yy = year % 100;

        // 성별에 따른 번호
        // .equalsIgnoreCase(): 대소문자 구분 x
        if (gender.equalsIgnoreCase("m")) {
            genNum = 3;
        } else if (gender.equalsIgnoreCase("f")) {
            genNum = 4;
        }else {
            System.out.println("m 또는 f를 입력해 주세요.");
            return;
        }


        System.out.printf("%02d%02d%02d-%d%06d\n",yy,month,day,genNum,randNum);
    }
}
