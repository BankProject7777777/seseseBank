package user;

import java.util.Scanner;

import static user.AccountBalanceAccessorYJ.*;
import static user.DepositCtrlYJ.depositMenu;
import static util.SimpleInput.*;

public class DepositViewYJ {
    //한달 적금 금액 받아오기
    static final long monthlySavingBalance;

    static {
        // 만약 적금통장을 만들었으면 한달적금금액 초기화
        if (getSavingAccountBalance() != 0) {
            monthlySavingBalance = getSavingAccountBalance();
        } else {
            // 만들지 않았으면 잔액이 0이므로 0으로 초기화
            monthlySavingBalance = 0;
        }
    }

    //나의 적금계좌 보기
    public static void viewSavingAccountStatus(User user) {
        if (getSavingAccountBalance() != 0) {
            //자동넘어감 방지 stop 하기 위한 코드
            Scanner s = new Scanner(System.in);

            //나의 적금 현황
            System.out.printf("\n  ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ ∙ ・ %s 님의 적금계좌 ◻︎ □ ▫︎▫︎▫︎▫︎▫︎▫︎▫︎  \n", user.getName());
            System.out.printf("\n              sesese-bank 와 [ %s일 째 ]🫧\n", user.getDayCount());

            System.out.printf(" ✦ 나의 적금계좌 잔액 [%d]원 \n\n", getSavingAccountBalance());
            System.out.printf(" ♦︎ 매달 [%d 원] 적금하고 있어요 \n\n", monthlySavingBalance);
            System.out.println(" ✧ 나의 적금계좌 이율 [ 1 % ] \n");
            System.out.println("(하루, 삼일이 지날때마다 이율은 중복으로 계산됩니다.)\n");
            System.out.println("press any key ...");
            s.nextLine();

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
                        s.nextLine();
                }
            }
        } else {
            System.out.println("⁉️ 적금 통장이 아직 존재하지 않습니다. ");
        }
    }
    //나의 예금계좌 보기
    public static void viewFixedAccountStatus(User user) {

        //자동넘어감 방지 코드
        Scanner s = new Scanner(System.in);

        System.out.printf("\n  ▫︎▫︎▫︎▫︎▫︎▫︎▫︎▫︎ ∙ ・ %s 님의 예금계좌 ◻︎ □ ▫︎▫︎▫︎▫︎▫︎▫︎▫︎  \n",user.getName());

        System.out.printf(" ♦︎ 나의 예금계좌 잔액 [%d 원] \n", getFixedAccountBalance());
        System.out.println(" ✧ 나의 예금계좌 이율 [ 5 % ] \n");
        System.out.println("(이율은 하루가 지날때마다 계산됩니다.)\n");
        System.out.println("press any key ...");
        s.nextLine();

        d: while (true) {
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
                        break d;

                    default: //이외의 값을 선택했을 때
                        System.out.println("⁉️ 1, 0 번중 하나를 선택해주세요 \n press any key ...");
                        s.nextLine();
                }
            } catch (Exception e) {
                System.out.println(" .... 🪬 \n press any key ...");
                s.nextLine();
            }
        }
    }

}




