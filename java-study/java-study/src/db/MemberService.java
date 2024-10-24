package db;

import java.sql.*;

public class MemberService {

    //회원 조회
    public void dbSelect() {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        //String sql 변수의 쿼리 중 " where member_type = ? ";를 찾는 매개변수
        //email, kakao, facebook 값이 변경 가능하도록 매개변수로 설정
        //sql injection 공격을 방지하기 위해 파라미터를 단순하게 하면 X : email => email' or 1 = 1
        String memberTypeValue = "email";


        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Class.forName()는 예외 처리 set임
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //6. 객체 연결 해제(close)
        Connection connection = null;
        PreparedStatement preparedStatement = null;// Statement를 사용하면 공격당할 수 있다.
//        Statement statement = null;
        ResultSet rs = null;

        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //4. 쿼리 실행
            String sql =
                    " select member_type , user_id, password, name " +
                            " from member " +
                            " where member_type = ? ";

            //3. 스테이트먼트 객체 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);


            //5. 결과 수행
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //6. 객체 연결 해제(close)
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    //회원 수정
    public void dbUpdate() {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";


        String memberTypeValue = "email";
        String userIdValue = "zerobase1@naver.com";
        String passwordValue = "9999";


        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Class.forName()는 예외 처리 set임
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //6. 객체 연결 해제(close)
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        Statement statement = null;
        ResultSet rs = null;

        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //4. 쿼리 실행
            String sql =
                    " update member set " +
                            " password = ? " +
                            " where member_type = ? and user_id  = ? ";

            //3. 스테이트먼트 객체 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);


            //5. 결과 수행
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");

            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {//6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    //회원 등록
    public void register(Member member) {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Class.forName()는 예외 처리 set임
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //6. 객체 연결 해제(close)
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        Statement statement = null;
        ResultSet rs = null;

        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //4. 쿼리 실행
            String sql =
                    " insert into member(member_type, user_id, password, name) " +
                            " values (?, ?, ?, ?); ";

            //3. 스테이트먼트 객체 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getName());


            //5. 결과 수행
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");

            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {//6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    //회원 탈퇴
    public void withdraw(Member member) {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        //1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Class.forName()는 예외 처리 set임
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //6. 객체 연결 해제(close)
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        //2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            //4. 쿼리 실행
            String sql =
                    " delete from member " +
                            " where member_type = ? and user_id = ? ";

            //3. 스테이트먼트 객체 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());


            //5. 결과 수행
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 삭제 성공 ");
            } else {
                System.out.println(" 삭제 실패 ");

            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {//6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}