package AProject;

/*
    강희진

    문제05
    “달력 출력 프로그램”
    - 수행 목적 : Scanner의 입력함수와 조건문 및 반복문을 통한 달력 계산 로직 작성
    - 간략 소개 : 달력은 일반적인 전산시스템에서 많이 사용하는 컴포넌트입니다. 입력받은 년도
    와 월을 통해 달력을 출력하는 프로그램을 작성해 보세요.

    필수 준수사항
    입력받은 년도와 월을 통한 달력 생성
    1. 입력값은 년도, 월을 입력
    2. 날짜는 LocalDate클래스를 이용(Calendar와 Date클래스도 이용 가능)
    3. 출력은 입력한 달을 기준으로 이전달, 입력달, 현재달 출력(3달 출력)

    -> calendar 함수 사용 참고:
        https://moonong.tistory.com/10
        https://12716.tistory.com/entry/Java-Calendar-클래스를-이용한-달력calendar
 */


import java.util.Calendar;
import java.util.Scanner;

class PrintCalendar {

    public void printCal(int year, int month) {

        Calendar cal = Calendar.getInstance();

        System.out.printf("[%d년 %d월]\n",year, month);
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

        cal.set(year, month - 1, 1);

        int start = cal.get(Calendar.DAY_OF_WEEK);

        for (int i = 1; i < start; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
            System.out.printf("%d\t", i);
            if(start % 7 == 0) {
                System.out.println();
            }
            start++;
        }
        System.out.println();
        System.out.println();
    }
}


public class MiniProject05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        int year = sc.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int month = sc.nextInt();

        PrintCalendar preMonth= new PrintCalendar();
        preMonth.printCal(year, month - 1);

        PrintCalendar curMonth = new PrintCalendar();
        curMonth.printCal(year,month);

        PrintCalendar nextMonth = new PrintCalendar();
        nextMonth.printCal(year, month + 1);

    }
}
