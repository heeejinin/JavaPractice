package db;

import java.util.Scanner;

public class DbTestMain {

    public static void main(String[] args) {

        MemberService memberService = new MemberService();

        Scanner scanner = new Scanner(System.in);

        String memberType = "email";

        System.out.println("탈퇴할 회원 아이디 입력>>>");
        String userId = scanner.next();

//        System.out.println("아이디 입력>>>");
//        String userId = scanner.next(); // next는 String을 반환하는 것
//
//        System.out.println("비밀번호 입력>>>");
//        String password = scanner.next();
//
//        System.out.println("이름 입력>>>");
//        String name = scanner.next();

        Member member = new Member();
        member.setMemberType(memberType);
        member.setUserId(userId);
//        member.setPassword(password);
//        member.setName(name);

        memberService.withdraw(member);
    }
}
