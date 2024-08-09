package Java_18_1.src;

public class Practice3 {
    public static String solution(char[] str, char[] find, char[] to) {
        int idx = 0;
        String replaceStr = ""; // 최종 변경 데이터를 담음
        char[] replaceBucket = str.clone(); // 임시 사용 공간

        do {
            idx = findIndex(replaceBucket, find);

            if (idx != -1) {
                for (int i = 0; i < idx; i++) {
                    replaceStr += replaceBucket[i];
                }

                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }

                for (int i = idx + find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }

                replaceBucket = replaceStr.toCharArray();
                replaceStr = "";
            }
        } while (idx != -1); //findIndex 함수에서 매칭되는 함수를 찾지 못했을 때 -1이 반환됨
        replaceStr = new String(replaceBucket);
        return replaceStr;
    }

    public static int findIndex(char[] str, char[] find) {
        int idx = -1;
        boolean isMatch = false;

        for (int i = 0; i < str.length; i++) {
            // 인덱스의 첫글자와 같은지 && str 길이가 find 길이보다 짧으면 없는거니까 길이 확인
            if (str[i] == find[0] && str.length - i >= find.length) {
                isMatch = true;

                // 일단 첫 글자는 같은걸 확인했으니 1부터 시작
                for (int j = 1; j < find.length; j++) {
                    if (str[i + j] != find[j]) {
                        isMatch = false;
                        break;
                    }
                }
            }

            if (isMatch) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        // Test code
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 String replace
        System.out.println(str.replace(find, to));

        // 자체 구현 replace
        char[] strExArr = str.toCharArray(); // .toCharArray() : String 문자열을 char형 배열로 바꿔서 반환해주는 메서드
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}
