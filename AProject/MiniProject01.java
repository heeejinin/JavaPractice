package AProject;
/*
    강희진

    문제01
    1. 다중 반복문을 이용하여 코딩
    2. 콘솔화면에 내용이 맞도록 format함수 이용하여 코딩
    3. 제목 및 1단부터 9단까지 표시(반드시, 예시와 동일한 레이아웃으로 작성)
 */

public class MiniProject01 {

    public static void main(String[] args) {

        System.out.println("[구구단 출력]");

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%02d x %02d = %02d\t", j, i, j * i);
            }
            System.out.println();
        }
    }        
}
