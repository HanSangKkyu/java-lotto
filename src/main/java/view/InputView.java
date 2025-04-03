package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class InputView {
    private InputView() {}

    public static int inputMoney() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWonLottoNumbers() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoStrings(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        final List<String> result = new LinkedList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            final Scanner scanner = new Scanner(System.in);
            result.add(scanner.nextLine());
        }

        return result;
    }
}
