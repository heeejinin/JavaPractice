package Java_18_1.src;

import java.util.Scanner;

public class Practice2 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        System.out.print("알파벳 입력: ");
        char input = sc.nextLine().charAt(0); //.charAt(0): 0번 인덱스 char 형으로 변환
        int output = 0;

        int step = (int) 'a' - (int) 'A';

        // case1: 소문자 -> 대문자
        if (input >= 'a' && input <= 'z') {
            output = (int) input - step;
            System.out.println("대문자 변환: " + (char)output);
        }
        // case2: 대문자 -> 소문자
        else if (input >= 'A' && input <= 'Z') {
            output = (int) input + step;
            System.out.println("소문자 변환: " + (char) output);
        }
        // case3: 알파벳 X
        else {
            System.out.println("입력하신 값이 알파벳이 아닙니다.");
        }
    }

    public static void reference() {
        int a = (int)'a';
        System.out.println("a = " + a); //97
        int z = (int)'z';
        System.out.println("z = " + z); //122
        int A = (int)'A';
        System.out.println("A = " + A); //65
        int Z = (int)'Z';
        System.out.println("Z = " + Z); //90
        int etc = (int)'%';
        System.out.println("etc = " + etc); //37
    }

    public static void main(String[] args) {
        reference();    // 아스키 코드 참고
        solution();
    }
}
