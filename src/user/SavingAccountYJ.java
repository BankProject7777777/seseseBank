package user;

import java.util.Scanner;

import static user.AccountBalanceAccessorYJ.*;
import static user.DayAccountsYJ.*;
import static util.SimpleInput.*;

class SavingAccountYJ {
    private static long transferBalance = getTransferAccountBalance();
    private static long savingBalance = getSavingAccountBalance();
    private static long monthlySaveBalance = getSavingAccountBalance();
    private static double monthlyInterestRate = 0.01; //적금계좌 이자율 : 1% -> 관리자가 바꿀 수 있음

    //적금계좌 이율 계산
    static void userSavingAccount(User user) {

        Scanner s = new Scanner(System.in);

        //하루당 이자율 한번만 계산
        if (checkNextDay()) {
            //1일치 이자 계산 시스템
            double interest = savingBalance * monthlyInterestRate;
            //계좌에 쌓이는 이자
            savingBalance += (long) interest;
            //적금 계좌 업데이트
            updateSavingBalances(user, savingBalance);

            System.out.printf(" ♦︎ 하루가 지남에 따라 적금계좌에 [ %.2f 원 ]의 이자가 쌓였습니다. \n", interest);
            System.out.printf(" ◇ 하루가 지남에 따라 적금계좌 잔고는 [ %d 원 ] 입니다.\n\n", savingBalance);
        }

        //한달주기 자동이체적금
        if ((dayCount != 0) && (dayCount % 3 == 0)) { //3일 (한달)이 지났는가?, 맨 처음엔 하루가 지나지 않았으므로 실행
            if (monthlySaveBalance <= transferBalance) {

                // 입출금계좌에서 적금계좌로 일정금액 송금기능
                savingBalance += monthlySaveBalance;
                // 적금계좌 업데이트
                updateSavingBalances(user, savingBalance);

                transferBalance -= monthlySaveBalance;
                //입출금계좌 업데이트
                updateTransferBalances(user, transferBalance);

                System.out.print("\n              ∙▫︎ ☐ □ ・                \n");
                System.out.printf(" \n ◇ 매달 적금 자동이체 시스템으로 \n입출금계좌에서 적금계좌로 %d 원이 이체되었습니다. \n ", monthlySaveBalance);
                System.out.printf(" ◆ 현재 적금계좌 잔액 [%d 원] \n", savingBalance);
                System.out.printf(" ◆ 현재 입출금계좌 잔액 [%d 원] \n", transferBalance);
                System.out.print("\n              ∙▫︎ ☐ □ ・                \n");

            } else System.out.println(" ⁉️입출금계좌에 잔액이 부족하여 자동이체 적금을 실패하였습니다. \n");
            System.out.println("\n \npress any key ...\n");
            s.nextLine();
        }
    }

        //내 적금에 추가로 입금하는 코드
        static void addSavingAccountBalance (User user) {

            Scanner s = new Scanner(System.in);

            int addSaving = 0;

            while (true) {
                try {
                    addSaving = Integer.parseInt(input(" ◆ 추가로 납입하실 금액을 입력해주세요 ... \n" +
                            " 추가납입 금액 입력 : "));
                    //입출금계좌의 돈 > 입금하려는 돈
                    if (transferBalance >= addSaving) {
                        transferBalance -= addSaving;
                        //입출금계좌 업데이트
                        updateTransferBalances(user,transferBalance);

                        System.out.printf("\n ◇ [ %s 원 ]이 정상적으로 추가납입 되었습니다. \n", addSaving);
                        System.out.printf("\n ◆ 현재 입출금계좌 잔액 [ %d 원 ] \n", transferBalance);
                        System.out.println("\n \npress any key ...\n");
                        s.nextLine();

                        // addSaving 을 적금계좌에 누적
                        savingBalance += addSaving;
                        //적금계좌 업데이트
                        updateSavingBalances(user, savingBalance);

                        System.out.printf(" \n 추가납입 성공 💨 적금계좌 잔액 [ %d 원 ] \n", savingBalance);

                    } else System.out.printf(" ⁉️ 입출금계좌 잔액이 부족합니다. \n      현재 입출금계좌 잔액 [ %d 원] ",transferBalance);
                    System.out.println("\n \npress any key ...\n");
                    s.nextLine();
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("\n 🪬 입금 금액은 정수로 입력해 주세요 🪬 \n" +
                            "press any key ...");
                    s.nextLine();
                }
            }
        }
}





