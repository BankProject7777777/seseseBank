package user;

import java.util.Scanner;

import static user.DayAccountsYJ.*;
import static util.SimpleInput.*;

class DepositViewYJ {
    User testUser = RegisterUserJW.getUsers().get("qwe");


    public static void depositMenu(User testUser) {
        System.out.printf(" ======== 마이 예적금 페이지 ==== sesese-bank와 [ %s일 째 ]==== \n",dayAccount);
        System.out.println(" 1. 나의 적금 ");
        System.out.println(" 2. 나의 예금 ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        System.out.println(" *. 다음날로 ");

        String menuNum = input(" >>🧼 ");

        switch (menuNum) {
            case "1": //나의 적금 현황
                System.out.println("적금 현황으로 접속합니다 ...");
                 viewSavingAccountStatus(testUser);
                break;

            case "2": //나의 예금 현황
                System.out.println("예금 현황으로 접속합니다 ...");
                viewFixedAccountStatus(testUser);
                break;

            case "0": // 뒤로 가기
                System.out.println("이전 메뉴로 돌아갑니다 ...");
                depositMenu(testUser); //이거 이전의 메뉴
                break;

            case "*": // 뒤로 가기
                addDayAccount();
                System.out.println(" 잠 드는 중 ... \n press any key ...");
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
                depositMenu(testUser); //이전의 메뉴 돌아가기
                break;

            default: //이외의 값을 선택했을 때
                System.out.println("1, 2, 0 번중 하나를 선택해주세요 \n press any key ...");
                Scanner s = new Scanner(System.in);
                s.nextLine();
                depositMenu(testUser);
        }

    }


    //나의 적금계좌 보기
    private static void viewSavingAccountStatus(User testUser) {

        //자동넘어감 방지 stop 하기 위한 코드
        Scanner s = new Scanner(System.in);

        //나의 적금 현황
        System.out.printf("🎏 %s 님의 적금계좌 🎏 \n",testUser.getName());
        DepositRepositoryYJ.userDepositAccount(testUser);
        System.out.println(" 1. 적금계좌에 추가입금하기 ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        String menuNum = input(" >>🧼 ");

        switch (menuNum) {
            case "1": //적금계좌에 더 입금하고 싶을 때
                DepositRepositoryYJ.addSavingAccountBalance(testUser);
                //입금하고 나온 뒤 다시 메뉴로
                viewFixedAccountStatus(testUser);

            case "0": //뒤로 가기
                depositMenu(testUser);
                break;

            default: //이외의 값을 선택했을 때
                System.out.println("1, 0 번중 하나를 선택해주세요 \n press any key ...");
                s.nextLine();
            }
    }

    //나의 예금계좌 보기
    private static void viewFixedAccountStatus(User testUser) {

        //자동넘어감 방지 stop 하기 위한 코드
        Scanner s = new Scanner(System.in);

        System.out.println("🎏 %d 님의 예금 현황 🎏");
        //예금가입금액 받아오기
        System.out.printf("나의 현재 예금액 [%d 원] \n", DepositRepositoryYJ.getFixedBalance());
        System.out.println(" 1. 예금계좌 해지하기 (서비스 준비중) ");
        System.out.println(" 0. 뒤로 가기 (나가기) ");
        String menuNum = input(" >>🧼 ");
        try {
            if (menuNum.equals("0")) depositMenu(testUser);
            else if(menuNum.equals("1"))
                System.out.println(" 준비중 입니다. . .");
                System.out.println("press any key ...");
                s.nextLine();
            depositMenu(testUser);

        } catch (Exception e) {
            System.out.println(" .... -_- \n press any key ...");
            s.nextLine();
        }
    }
}


