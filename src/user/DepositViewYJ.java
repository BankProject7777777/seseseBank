package user;

import java.util.HashMap;
import java.util.Map;

import static user.AccountBalanceAccessorYJ.*;
import static user.DepositCtrlYJ.depositMenu;
import static util.SimpleInput.*;

public class DepositViewYJ {

    //나의 적금계좌 보기
    public static void viewSavingAccountStatus(User user) throws InterruptedException {
            //나의 적금 현황
            System.out.printf("\n  ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ ∙ ・ %s 님의 적금계좌 ◻︎ □ ▫︎▫︎▫︎▫︎▫︎▫︎▫︎  \n", user.getName());
            System.out.printf("\n              sesese-bank 와 [ %s일 째 ]🫧\n", user.getDayCount());

            System.out.printf(" ✦ 나의 적금계좌 잔액 [%d]원 \n\n", getInstance().getSavingAccountBalance(user));

        MySavingCreationCallback callback = new MySavingCreationCallback();

        CreateAccountLJH.createSaving(user, callback);

        long initialSavingBalance = callback.getInitialSavingBalance();

        System.out.printf(" ♦︎ 매달 [%d 원] 적금하고 있어요 \n\n", initialSavingBalance);

            //user 값이 만들어졌을때 변수 선언해서 그거 걍 매달 더하셈 어우 귀차나
            System.out.println(" ✧ 나의 적금계좌 이율 [ 1 % ] \n");
            System.out.println("(하루, 삼일이 지날때마다 이율은 중복으로 계산됩니다.)\n");
            input("press any key . . . ");

            d:
            while (true) {
                System.out.println(" 1. 적금계좌에 추가입금하기 ");
                System.out.println(" 0. 뒤로 가기 (나가기) ");
                String menuNum = input(" □▫∙︎ ︎");

                switch (menuNum) {
                    case "1": //적금계좌에 더 입금하고 싶을 때
                        SavingAccountYJ.addSavingAccountBalance(user);

                    case "0": //뒤로 가기
                        depositMenu(user);
                        break d;

                    default: //이외의 값을 선택했을 때
                        System.out.println(" ⁉️ 1, 0 번중 하나를 선택해주세요 \n press any key ...");
                        input(" press any key . . . ");
                }
            }
    }

    //나의 예금계좌 보기
    public static void viewFixedAccountStatus(User user) {
            System.out.printf("\n  ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ ∙ ・ %s 님의 예금계좌 ◻︎ □ ▫︎▫︎▫︎▫︎▫︎▫︎▫︎  \n", user.getName());

            System.out.printf(" ♦︎ 나의 예금계좌 잔액 [%d 원] \n", getInstance().getFixedAccountBalance(user));
            System.out.println(" ✧ 나의 예금계좌 이율 [ 5 % ] \n");
            System.out.println("(이율은 하루가 지날때마다 계산됩니다.)\n");
            input("press any key . . . ");


            c:
            while (true) {
                System.out.println(" 1. 예금계좌 해지하기 (서비스 준비중) ");
                System.out.println(" 0. 뒤로 가기 (나가기) ");
                String menuNum = input(" □▫∙︎ ︎");
                try {
                    switch (menuNum) {
                        case "1":
                            System.out.println(" 🪬 준비중 입니다. . . 🪬");
                            break;

                        case "0": //뒤로 가기
                            depositMenu(user);
                            break c;

                        default: //이외의 값을 선택했을 때
                            System.out.println("⁉️ 1, 0 번중 하나를 선택해주세요 ");
                            input("press any key . . . ");
                    }
                } catch (Exception e) {
                    input("press any key . . . ");
                }
            }
    }
}





