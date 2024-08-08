package AProject;

/*
    강희진

    문제02
    주어진 캐시백 적립 조건에 맞게 캐시백 계산
    결제 금액을 입력하면, 이에 대한 캐시백 계산 후 결과 출력

    [캐시백 계산 조건]
    - 결재 금액의 10%를 적립한다.
    - 캐시백포인트 단위는 백원단위이다.(100원, 200원, 300원 등)
    - 한건의 캐시백 포인트는 최대 300원을 넘을 수 없습니다.

*/

import java.util.Scanner;

public class MiniProject02 {

    public static void main(String[] args) {

        System.out.println("[캐시백 계산]");

        Scanner sc = new Scanner(System.in);
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int cash = sc.nextInt();

        // 캐시백 10% 계산
        double cashBack = cash * 0.1;

        // 캐시백포인트 단위는 백원 단위
        // ** Math.floor -> 내림을 수행
        int cashBackPoints = (int) Math.floor(cashBack / 100) * 100;

        // 한건의 캐시백 포인트는 최대 300원
        if (cashBackPoints <= 300) {
            System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", cash, cashBackPoints);
        } else {
            cashBackPoints = 300;
            System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", cash, cashBackPoints);
        }
    }
}