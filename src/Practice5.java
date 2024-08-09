package Java_18_1.src;

public class Practice5 {
    public static int solution(int[] height) {
        // 양끝 인덱스 변수 설정
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int x = (right - left);
            int y = height[left] < height[right] ? height[left] : height[right];
            int currArea = x * y;
            maxArea = maxArea > currArea ? maxArea : currArea;

            /*
            //방법 2 -> 삼항 연산자를 대체하는 방법
            // Math.min() 에서 작은 값과 x랑 곱함
            currArea = x * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currArea);
            */

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height)); // 49

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height)); // 26

    }
}
