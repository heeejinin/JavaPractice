package AProject;

/*
    강희진

    문제07
    “로또 당첨 프로그램”
    - 수행 목적 : Scanner의 입력함수와 조건문 및 반복문과 배열을 통한 로또 당첨 로직 작성
    - 간략 소개 : 로또는 1-45개의 숫자 사이의 값중 6개를 맞추면 당첨되는 복권입니다. 로또의 개
    수를 구매하고(구매수량 입력), 당첨번호를 생성한다. 이후, 구매한 로또의 당첨번호를 판단하
    는 프로그램을 작성해 보세요.

    필수 준수사항
    1. 로또 구매 수량 입력
    2. 입력한 개수만큼의 로또 개수 생성
    3. 로또 당첨 번호 생성(숫자값은 중복 배제 및 정렬해서 표시)
    4. 당첨 번호와 구매 로또 비교하여 숫자 일치 여부 판단
    5. Collections.shuffle 함수 사용 금지!(shuffle 함수는 과제의 취지와 맞지 않기 때문에, 사용시 0
*/


import java.util.*;

class Lotto {
    private List<Integer> Lotto;

    public Lotto() {
        this.Lotto = LottoNumbers();
    }

    // 로또 번호 생성
    private List<Integer> LottoNumbers() {
        HashSet<Integer> setLotto = new HashSet<>();
        Random random = new Random();

        while (setLotto.size() < 6) {
            int num = random.nextInt(45) + 1;
            setLotto.add(num);
        }

        List<Integer> list = new ArrayList<>(setLotto);
        Collections.sort(list);
        return list;
    }

    // 입력 받은 수 만큼 로또 생성
    public List<List<Integer>> makeLottos(int count) {
        List<List<Integer>> allLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            allLottos.add(LottoNumbers());
        }

        return allLottos;
    }

    // 로또 발표
    public void checkNumbers() {
        System.out.println("[로또 발표]");
        printLottoNum(this.Lotto);
        System.out.println();
    }

    // 로또 번호 출력
    private void printLottoNum(List<Integer> list) {
        System.out.print("\t");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.printf("%02d", list.get(i));
            }
            else { // , 구분
                System.out.printf("%02d, ", list.get(i));
            }
        }
    }

    // 구매 로또 출력
    public void printBuyLottos(List<List<Integer>> buyLottos) {
        for (int i = 0; i < buyLottos.size(); i++) {
            System.out.printf("%c", 'A' + i);
            printLottoNum(buyLottos.get(i));
            System.out.println();
        }
        System.out.println();
    }

    // 당첨 여부 확인
    public void checkResults(List<List<Integer>> buyLottos) {
        System.out.println("[내 로또 결과]");

        for (int i = 0; i < buyLottos.size(); i++) {
            List<Integer> lotto = buyLottos.get(i);
            int matchCount = 0;

            for (int num : lotto) {
                if (Lotto.contains(num)) {
                    matchCount++;
                }
            }

            System.out.printf("%c", 'A' + i);
            printLottoNum(lotto);
            System.out.printf(" => %d개 일치\n", matchCount);
        }
    }
}

public class MiniProject07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int count = sc.nextInt();

        Lotto myLotto = new Lotto();

        // 로또 구매 및 출력
        List<List<Integer>> lottos = myLotto.makeLottos(count);
        myLotto.printBuyLottos(lottos);

        // 로또 발표
        myLotto.checkNumbers();

        // 로또 결과 확인
        myLotto.checkResults(lottos);
    }
}