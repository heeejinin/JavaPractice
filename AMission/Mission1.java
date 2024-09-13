/*
강희진

property.html 파일을 만드는 코드를 작성하세요.

[조건]
자바의 시스템 속성과 파일 저장코드는 샘플코드를 참조해 주세요.
출력 결과의 파일은 웹브라우저로 확인해서 정상적으로 표시되어야 합니다.
 html 파일을 작성할 때 테이블에 라인이 표시되도록 head 태그에 style 태그 추가.
*/

package AMission;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Mission1 {

        public static void main(String[] args) {
            // 자바 시스템 속성 가져오기
            Properties properties = System.getProperties();

            // HTML 파일 생성 및 내용 작성
            try {
                File file = new File("property.html");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                // HTML 헤더와 스타일 작성
                writer.write("<html>\n");
                writer.write("<head>\n");
                writer.write("<meta charset=\"UTF-8\" />\n");
                writer.write("<style>\n");
                writer.write("table { border-collapse: collapse; width: 100%; }\n");
                writer.write("th, td { border: solid 1px #000; padding: 8px; text-align: left; }\n");
                writer.write("th:first-child, td:first-child { text-align: center; }\n");
                writer.write("</style>\n");
                writer.write("</head>\n");
                writer.write("<body>\n");
                writer.write("<h1>자바 환경정보</h1>\n");
                writer.write("<table>\n");
                writer.write("<tr><th>키</th><th></th></tr>\n");

                // 자바 시스템 속성값 출력
                for (Object keySet : properties.keySet()) {
                    String key = keySet.toString();
                    String value = System.getProperty(key);

                    writer.write("<tr>");
                    writer.write("<td>" + key + "</td>\n");
                    writer.write("<td>" + value + "</td>\n");
                    writer.write("</tr>");
                }

                // HTML 문서 끝 태그
                writer.write("</table>\n");
                writer.write("</body>\n");
                writer.write("</html>\n");

                // 작성 완료 후 파일 닫기
                writer.close();

                System.out.println("property.html 파일이 생성되었습니다.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
