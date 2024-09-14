package AMission;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y); // 좌표의 x와 y 값에 기반한 해시코드를 생성
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Mission2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 나의 좌표 입력 받기
        System.out.println("내 좌표 x값을 입력해 주세요.");
        int myX = scanner.nextInt();
        System.out.println("내 좌표 y값을 입력해 주세요.");
        int myY = scanner.nextInt();
        Point myPoint = new Point(myX, myY);

        // 2. 임의의 좌표 10개 입력 받기 (HashSet 사용하여 중복 방지)
        HashSet<Point> points = new HashSet<>();
        while (points.size() < 10) {
            System.out.println((points.size() + 1) + "/10 번째 입력");
            System.out.println("임의의 좌표 x값을 입력해주세요.");
            int x = scanner.nextInt();
            System.out.println("임의의 좌표 y값을 입력해주세요.");
            int y = scanner.nextInt();
            Point newPoint = new Point(x, y);

            // 중복 좌표 확인 (HashSet을 통해 중복 체크)
            if (!points.add(newPoint)) { // 중복인 경우 false 반환
                System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요.");
            }
        }

        // 3. 입력 받은 좌표들의 거리 출력
        System.out.println("입력한 좌표와의 거리:");
        Point closestPoint = null;
        double minDistance = Double.MAX_VALUE;

        for (Point p : points) {
            double distance = myPoint.distanceTo(p);
            System.out.printf("%s => %.6f\n", p, distance);

            // 가장 가까운 좌표 찾기
            if (distance < minDistance) {
                minDistance = distance;
                closestPoint = p;
            }
        }

        // 4. 가장 가까운 좌표 출력
        System.out.printf("\n제일 가까운 좌표: %s => %.6f\n", closestPoint, minDistance);
    }
}
