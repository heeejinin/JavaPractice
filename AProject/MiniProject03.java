package AProject;
/*
    강희진

    문제03
    1. 놀이공원 입장료를 구하는 조건에 맞게 로직 작성
    2. 입력내용은 나이, 입장시간, 국가유공자 여부, 복지카드 여부 순으로 입력

    필수 준수사항
    놀이공원 입장료 할인은 일반 할인과 특별 할인이 있습니다.
    조건은 아래와 같습니다.

    입장료 할인은 중복할인 되지 않으며, 중복될 경우 가장 할인을 많이 받은 금액으로 정해집니다.
    - 3세미만이면 무료 입장
    - 복지카드와 국가유공자의 경우 일반 할인 적용
    - 13세미만이면 특별 할인 적용
    - 17시이후에 입장하면 특별 할인 적용
    기본 입장료 : 10,000원
    특별 할인의 경우 : 4,000원
    일반 할인의 경우 : 8,000

*/

import java.util.Scanner;

public class MiniProject03 {

    // 기본 입장료
    static int fee = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요. (숫자): ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("입장시간을 입력해 주세요. (숫자입력): ");
        int time = sc.nextInt();
        sc.nextLine();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n): ");
        String discount1 = sc.nextLine();

        System.out.print("복지카드 여부를 입력해 주세요.(y/n): ");
        String discount2 = sc.nextLine();

        // 특별 할인
        if (age < 3) {
            fee = 0;
        } else if (age < 13 || time > 17) {
            fee = 4000;
        }

        // 일반 할인
        if (fee == 10000) {
            if (discount1.equals("y") || discount2.equals("y")) {
                fee = 8000;
            }
        }
        System.out.printf("입장료: %d", fee);
    }
}
