package AProject;
/*
    강희진

    문제08
    “연소득 과세금액 계산 프로그램”
    - 수행 목적 : Scanner의 입력함수와 조건문 및 반복문 과 배열, 함수를 통한 과세 로직 작성
    - 간략 소개 : 대한민국 헌법은 국민의 의무와 권리를 규정하고 있습니다. 이중 납세의 의무는 국
    민의 3대 의무중 하나입니다. 모든 국민은 1년 동안 열심히 번 소득에 대해서 세금을 납부하여
    야 합니다. 이런 소득에 대한 소득세율표가 있습니다. 주어진 표를 기준으로 해서 소득에 대한
    세금을 구하는 프로그램을 작성해 보세요

    필수 준수사항
    1. 연소득 금액 입력
    2. 주어진 종합소득세율표를 통한 조건 생성

    설명)
    1,000만원 소득인 경우는 과세표준이 1,200만원 이하 이기 때문에 세율을 6%로 계산한 결과
    인 60만원의 세금이 부과됨
    1,500만원 소득의 경우는 과세표준 구간이 15%세율이기 때문에 15%로 계산하는 게 아니라
    1,200만원까지는 6%의 세율로 계산하고 그 외만 15%로 계산해서 합계를 냄.
    이때, 누진공제 금액을 이용할 수 있는데 1,500만원에 15%세율로 계산한 금액 225만원에 누
    직 공제 금액을 빼면 세금계산과 동일한 금액입니다
 */

import java.util.Scanner;


public class MiniProject08 {

    // 세금 계산 및 출력
    public static int calculateTax1(int income) {
        int[] incomeList = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        double[] taxRates = {0.06, 0.15, 0.24, 0.35, 0.38, 0.4, 0.42, 0.45};

        int tax1 = 0;
        int balance = income;

        for (int i = 0; i < incomeList.length; i++) {

            int calTaxRates = (i == 0) ? incomeList[i] : incomeList[i] - incomeList[i - 1];

            if (income <= incomeList[i]) {
                tax1 += (int) (balance * taxRates[i]);
                System.out.printf("%d * %.0f%% = %d%n", balance, taxRates[i] * 100, (int) (balance * taxRates[i]));
                break;

            } else {
                tax1 += (int) (calTaxRates * taxRates[i]);
                System.out.printf("%d * %.0f%% = %d%n", calTaxRates, taxRates[i] * 100, (int) (calTaxRates * taxRates[i]));
                balance -= calTaxRates;

                // 1000000000 초과인 경우
                if (i == 6 && balance > 0) {
                    tax1 += (int) (balance * taxRates[i+1]);
                    System.out.printf("%d * %.0f%% = %d%n", balance, taxRates[i+1] * 100, (int) (balance * taxRates[i+1]));
                }
            }

        }
        return tax1;
    }


    // 누진공제 계산
    public static int calculateTax2(int income) { //<- 48,000,000 (12,000,000// 46,000,000// 88,000,000
        int[] incomeList = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        double[] taxRates = {0.06, 0.15, 0.24, 0.35, 0.38, 0.4, 0.42, 0.45};
        int[] benefit = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

        int tax2 = 0;

        for (int i = 0; i < incomeList.length; i++) {
            if (income <= incomeList[i]) {
                tax2 = (int) (income * taxRates[i]) - benefit[i];
                break;
            }
        }

        // 마지막 구간 이상인 경우
        if (income > incomeList[incomeList.length - 1]) {
            tax2 = (int) (income * taxRates[taxRates.length - 1]) - benefit[benefit.length - 1];
        }

        return tax2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연소득 금액을 입력하세요: ");
        int income = scanner.nextInt();

        int tax1 = calculateTax1(income);
        System.out.println("[세율에 의한 세금]: " + tax1);

        int tax2 = calculateTax2(income);
        System.out.println("[누진공제 계산에 의한 세금]: " + tax2);
    }


}
