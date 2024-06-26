package user;
import java.util.Random;
import java.util.Scanner;
import static util.SimpleInput.*;

public class CreateAccountLJH extends Account  {

    public static Scanner sc;
    private AccountType accountType;
    private static Account accountNum;

    public CreateAccountLJH(long balance, User user, int accountPassword, AccountType type, String accountNum, long initialDepositBalance) {
        super(balance, user, accountPassword, type, String.valueOf(accountNum),initialDepositBalance);
        Scanner sc;
    }

    public void Account(AccountType accountType) {
        this.accountType = accountType;
    }

    static {
        sc = new Scanner(System.in);

    }

    // 메뉴 창 함수
    public static void createView() {
        System.out.println("\n 🧼 ---------------- 계좌 개설 ---------------- 🧼 \n");
        System.out.println(" □ ▫ 계좌를 개설합니다 ▫ ∙ \n   사용하실 계좌의 종류를 선택해주세요.\n 1. 예금\n 2. 적금\n 3. 입출금\n 4. 뒤로가기\n");
        System.out.println(" 🧼 ------------------------------------------- 🧼 ");
    }




    // 입출금 계좌 생성하는 함수
    public static void createTransfer(User user) throws InterruptedException {
        while (true) {
            try {

                // 입출금 계좌가 있는지 확인
                if (userHasAccountOfType(user, AccountType.TRANSFER)) {
                    System.out.println("\n⁉️ 이미 생성된 입출금 계좌가 있습니다");
                    Thread.sleep(1000);
                    createView();
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("처리중 입니다 . . . . .");
            }

            while (true) {
                // 입출금 계좌 생성
                long balance = 0;
                int transferPassword;
                while (true) {
                    try {

                        // 비밀번호 4자리 확인
                        transferPassword = Integer.parseInt(input("\n사용하실 비밀번호를 입력해주세요.\n □▫∙").replace(" ",""));
                        if (String.valueOf(transferPassword).matches("\\d{4}")) {
                            break; // 4자리 숫자인 경우에만 반복문 탈출
                        } else {
                            System.out.println("⁉️ 비밀번호는 숫자로 4자리만 입력이 가능합니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⁉️ 숫자로만 입력해주세요.");
                    }
                }

                // 비밀번호가 올바른 경우 계좌 생성
                String accountNum = generateAccountNumber();
                Account transferAccount = new Account(balance, user, transferPassword, AccountType.TRANSFER, accountNum, 0);

                // 초기 입금 설정

                long firstDepositSav;
                try {
                    System.out.println("\n초기 납입 금액을 설정합니다.");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("처리중 입니다 . . . ");
                }
                while (true) {
                    try {
                        while (true) {
                            firstDepositSav = Long.parseLong(input("\r금액을 입력해주세요.\n□▫∙︎ ").replace(" ", ""));
                            if (firstDepositSav == 0){
                                createView();
                                break;
                            }
                            String doubleCheck = input(firstDepositSav + "원을 입금하시려면 [y]를 뒤로가기는 [n]을 입력해주세요.\n□▫∙︎ ");
                            if (doubleCheck.equals("y")){
                                // 입출금 계좌에 입금
                                long finalBalance = transferAccount.getBalance() + firstDepositSav;
                                transferAccount.setBalance(finalBalance);

                                try {
                                    // 사용자에게 알림
                                    System.out.println(".");
                                    Thread.sleep(500);
                                    System.out.println("..");
                                    Thread.sleep(700);
                                    System.out.println("...");
                                    Thread.sleep(1200);
                                    System.out.println("∙ ☐ 요청하신 입출금 계좌가 생성되었습니다 □ ▫︎\n      ♦︎  ✡︎ Thank you ✦ ・\n");
                                    Thread.sleep(1800);
                                    System.out.println(" 🧼 ------------------------------- 🧼 ");
                                } catch (InterruptedException e) {
                                    System.out.println("처리중 입니다 . . . ");
                                }


                                // 사용자 정보는 로그인한 해당 회원으로 지정
                                try {
                                    user.getMyAccount().add(transferAccount);
                                    System.out.println("     계좌번호 : " + transferAccount.getAccountNum());
                                    System.out.println("     현재잔액 : " + transferAccount.getBalance() + "원");
                                    System.out.println(" 🧼 ---------------------------------- 🧼 ");
                                    Thread.sleep(1000);
                                    createView();
                                    break;
                                } catch (InterruptedException e) {
                                    System.out.println("처리중 입니다 . . . ");
                                }

                            } else if (doubleCheck.equals("n") ) {
                            } else {
                                System.out.println("⁉️ 잘못 입력하셨습니다.");

                            }
                        } break;
                    } catch (NumberFormatException e) {
                        System.out.println("⁉️ 숫자를 입력해주세요");
                        createTransfer(user);
                    }
                } break;
            } break;
        }
    }

    public static void createSaving(User user) throws InterruptedException {
        try { // 적금계좌를 보유한지 확인
            if (userHasAccountOfType(user, AccountType.SAVING)) {
                System.out.println("\n⁉️ 이미 생성된 적금 계좌가 있습니다.");
                Thread.sleep(1000);
                createView();
                return;
            }

            // 다른 클래스에서 생성한 타입을 받아 입출금 계좌를 보유하고 있는지 확인
            if (!userHasAccountOfType(user, AccountType.TRANSFER)) {
                System.out.println("\n⁉️ 입출금 계좌가 필요합니다.\n\n");
                Thread.sleep(1200);
                createView();
                return;
            }

            // 초기 납입 금액 설정하는 기능
            System.out.println("초기 납입 금액은 10만원부터 자유롭게 가능합니다.\n");
            Thread.sleep(1000);
            System.out.println("\n초기 납입 금액을 설정합니다. 뒤로가기는 0번을 눌러주세요.");

            long transferBalance = getTransferBalance(user);
            long firstDepositSav;

            while (true) {
                // 초기 납입 금액을 사용자로 부터 설정받아 변수에 입력
                firstDepositSav = Long.parseLong(input("\r금액을 입력해주세요.\n □▫∙︎ ︎ ").replace(" ", "")); // 공백입력을 삭제시키기
                if (firstDepositSav == 0) { // 나가기
                    createView();
                    return;
                }

                String doubleCheck = input(firstDepositSav + "원을 입금하시려면 [y]를 뒤로가기는 [n]을 입력해주세요.\n □▫∙︎ ︎ ");
                if (doubleCheck.equals("y")) {  // y를 눌러 계속 진행 할 경우
                    if (firstDepositSav < 100000 || firstDepositSav > transferBalance) {
                        System.out.println("⁉️ 잔고가 부족하거나 10만원 미만의 금액입니다. 취소는 숫자 0을 눌러주세요.");
                        continue;
                    }

                    int savingPassword = askForPassword(); // 비밀번호 숫자로만 4자리 입력받아 변수에 입
                    String accountNum = generateAccountNumber(); // 랜덤한 계좌번호 숫자를 생성하여 변수에 입력

                    // 계좌 객체 생성
                    Account savingAccount = new Account(0, user, savingPassword, AccountType.SAVING, accountNum, firstDepositSav);

                    savingAccount.setBalance(firstDepositSav);
                    // 초기납입금액 설정
                    savingAccount.setInitialDepositBalance(firstDepositSav);

                    try {
                        System.out.println(".");
                        Thread.sleep(500);
                        System.out.println("..");
                        Thread.sleep(700);
                        System.out.println("...");
                        Thread.sleep(1200);
                        System.out.println(" ☐ □ 요청하신 적금 계좌가 생성되었습니다 ▫︎ ☐ \n        ♦︎  ✡︎ Thank you ✦ ・\n");
                        Thread.sleep(1300);
                        System.out.println(" 🧼 ------------------------------- 🧼 ");
                    } catch (InterruptedException e) {
                        System.out.println("처리중 입니다 . . . . .");
                    }

                    // 회원의 계정에 생성된 적금 객체를 추가
                    // 현재 생성된 계좌에 대한 정보를 보여줌
                    user.getMyAccount().add(savingAccount);
                    System.out.println("     계좌번호 : " + savingAccount.getAccountNum());
                    System.out.println("     현재잔액 : " + savingAccount.getBalance() + "원");
                    System.out.println(" 🧼 ------------------------------- 🧼 ");

                    Thread.sleep(1000);
                    createView();
                    return;
                } else if (doubleCheck.equals("n")) {
                    System.out.println("입력을 취소합니다. 초기 납입 금액을 다시 입력해주세요.");
                } else {
                    System.out.println("⁉️ 잘못 입력하셨습니다.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("⁉️ 숫자를 입력해주세요");
            createSaving(user);  // 다시 돌아가는 기능
        } catch (InterruptedException e) {
            System.out.println("처리중 입니다 . . . . .");
        }
    }




    public static void createFixed(User user) throws InterruptedException {
        try {
            if (userHasAccountOfType(user, AccountType.FIXED)) {
                System.out.println("\n⁉️ 이미 생성된 예금 계좌가 있습니다.");
                Thread.sleep(1000);
                createView();
                return;
            }

            if (!userHasAccountOfType(user, AccountType.TRANSFER)) {
                System.out.println("\n⁉️ 입출금 계좌가 필요합니다.\n\n");
                Thread.sleep(1200);
                createView();
                return;
            }

            System.out.println("초기 납입 금액은 10만원부터 자유롭게 가능합니다.\n");
            Thread.sleep(1000);
            System.out.println("\n초기 납입 금액을 설정합니다. 뒤로가기는 0번을 눌러주세요.");

            long transferBalance = getTransferBalance(user);
            long firstDepositSav;

            while (true) {
                firstDepositSav = Long.parseLong(input("\r금액을 입력해주세요.\n □▫∙").replace(" ", ""));
                if (firstDepositSav == 0) {
                    createView();
                    return;
                }

                String doubleCheck = input(firstDepositSav + "원을 입금하시려면 [y]를 뒤로가기는 [n]을 입력해주세요.\n□▫∙ ");
                if (doubleCheck.equals("y")) {
                    if (firstDepositSav < 100000 || firstDepositSav > transferBalance) {
                        System.out.println("⁉️ 잔고가 부족하거나 10만원 미만의 금액입니다. 취소는 숫자 0을 눌러주세요.");
                        continue;
                    }

                    int fixedPassword = askForPassword();
                    String accountNum = generateAccountNumber();
                    Account fixedAccount = new Account(0, user, fixedPassword, AccountType.FIXED, accountNum, firstDepositSav);

                    withdrawFromTransfer(user, firstDepositSav);
                    fixedAccount.setBalance(firstDepositSav);

                    //예금 초기납입금액 설정
                    fixedAccount.setInitialDepositBalance(firstDepositSav);

                    try {
                        System.out.println(".");
                        Thread.sleep(500);
                        System.out.println("..");
                        Thread.sleep(700);
                        System.out.println("...");
                        Thread.sleep(1200);
                        System.out.println(" □ ∙ 요청하신 예금 계좌가 생성되었습니다. ☐ ◻︎\n        ♦︎  ✡︎ Thank you ✦ ・\n");
                        Thread.sleep(1300);
                        System.out.println(" 🧼 ------------------------------- 🧼 ");
                    } catch (InterruptedException e) {
                        System.out.println("처리중 입니다 . . . . .");
                    }

                    user.getMyAccount().add(fixedAccount);
                    System.out.println("     계좌번호 : " + fixedAccount.getAccountNum());
                    System.out.println("     현재잔액 : " + fixedAccount.getBalance() + "원");
                    System.out.println(" 🧼 ------------------------------- 🧼 ");

                    Thread.sleep(1000);
                    createView();
                    return;
                } else if (doubleCheck.equals("n")) {
                    System.out.println("입력을 취소합니다. 초기 납입 금액을 다시 입력해주세요.");
                } else {
                    System.out.println("⁉️ 잘못 입력하셨습니다.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("⁉️ 숫자를 입력해주세요");
            createFixed(user);
        } catch (InterruptedException e) {
            System.out.println("처리중 입니다 . . . . .");
        }
    }




    // 계좌번호를 생성하는 함수
    static String generateAccountNumber() {
        Random random = new Random();
        String accountNum = String.format("%03d-%06d-%03d", random.nextInt(1000), random.nextInt(1000000), random.nextInt(1000));
        return accountNum;
    }


    // 사용자가 이미 해당 타입의 계좌를 가지고 있는지 확인
    private static boolean userHasAccountOfType(User user, AccountType type) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType() == type) {
                return true;
            }
        }
        return false;
    }

    // 입출금 계좌의 잔액을 반환하는 함수
    private static long getTransferBalance(User user) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType() == AccountType.TRANSFER) {
                return account.getBalance();
            }
        }
        return 0; // 입출금 계좌가 없는 경우
    }

    // 입출금 계좌에서 출금하는 메서드
    private static void withdrawFromTransfer(User user, long amount) {
        for (Account account : user.getMyAccount()) {
            if (account.getAccountType() == AccountType.TRANSFER) {
                long balance = account.getBalance();
                balance -= amount; // 출금
                account.setBalance(balance);
                break; // 출금이 완료되면 반복문 종료
            }
        }
    }

    // 비밀번호 4글자만 하기
    private static int askForPassword() {
        while (true) {
            try {
                int password = Integer.parseInt(input("\n사용하실 비밀번호를 입력해주세요.\n □▫∙︎ ").replace(" ", ""));
                if (String.valueOf(password).matches("\\d{4}")) {
                    return password;
                } else {
                    System.out.println("⁉️ 비밀번호는 숫자로 4자리만 입력이 가능합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⁉️ 숫자로만 입력해주세요.");
            }
        }
    }
}
