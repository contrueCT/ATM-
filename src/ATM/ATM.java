package ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private Scanner sc = new Scanner(System.in);
    private Account loginAccount;

    //启动ATM界面
    public void start() {
        boolean flag = true;
        while (flag) {
            System.out.println("===欢迎您进入到了ATM系统===");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.println("3.退出系统");
            System.out.println("请选择：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //用户登录
                    login();
                    
                    break;
                case 2:
                    //用户开户
                    createAccount();
                    break;
                case 3:
                    System.out.println("退出系统！");
                    flag = false;
                    break;
                default:
                    System.out.println("没有该操作~~");

            }
        }
    }

    //登录
    private void login() {
        while (true) {
            System.out.println("==系统登录==");
            if (accounts.isEmpty()) {
                System.out.println("没有账户，请先开户");
                return;
            }

            System.out.println("请输入您的卡号：");
            String cardId = sc.next();
            Account acc = getAccountByCardId(cardId);
            if (acc == null) {
                System.out.println("您输入的登录卡号不存在");
                System.out.println("是否继续登录？Y/N");
                String re = sc.next();

                while (true) {
                    if (re.equals("Y")) {
                        break;
                    } else if (re.equals("N")) {
                        return;
                    } else {
                        System.out.println("请输入Y或N");
                    }
                }

            } else {
                while (true) {
                    System.out.println("请输入密码：");
                    String passWord = sc.next();
                    if (acc.getPassword().equals(passWord)) {
                        System.out.println(acc.getUsername() + "登录成功！卡号" + acc.getId());
                        loginAccount = acc;
                        showUserCommand();
                        return;//跳出登录方法，回到欢迎页
                    } else {
                        System.out.println("您输入的密码不正确，请再次输入");
                    }
                }
            }
        }

    }

    private void showUserCommand() {
        while (true) {
            System.out.println("==" + loginAccount.getUsername() + "您可以办理以下业务==");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出账户");
            System.out.println("7.注销账户");
            String re = sc.next();
            if (re.equals("1")) {
                showAccountInfo();
            } else if (re.equals("2")) {
                //存款
                depositMoney();
            } else if (re.equals("3")) {
                //取款
                withdrawMoney();
            } else if (re.equals("4")) {
                //转帐
                tansfer();
            } else if (re.equals("5")) {
                //修改密码
                changePassword();
            } else if (re.equals("6")) {
                System.out.println(loginAccount.getUsername() + "您退出系统成功！");
                return;
            } else if (re.equals("7")) {
                //注销当前账户
                cancelAccount();
            } else {
                System.out.println("您输入的数字不对，请重新输入");
            }
        }
    }

    private void cancelAccount() {
        showAccountInfo();
        System.out.println("您确定要注销账户吗Y/N");
        while (true) {
            String re = sc.next();
            if (re.equals("Y")) {
                if(loginAccount.getMoney()!=0) {
                    System.out.println("您的账号余额不为零，无法注销");
                    return;
                }
                else{
                    accounts.remove(loginAccount);
                    System.out.println("您的账号已注销");
                }
            }
            else if (re.equals("N")) {
                System.out.println("好的，账号保留");
            }
            else{
                System.out.println("您的输入有误，请重新输入");
            }
        }
    }

    private void changePassword() {
        System.out.println("请输入原密码：");
        while (true) {
            String oldPassword = sc.next();
            if (oldPassword.equals(loginAccount.getPassword())) {
                System.out.println("请输入新密码：");
                String newPassword = sc.next();
                loginAccount.setPassword(newPassword);
                System.out.println("密码修改成功！");
                showAccountInfo();
                return;
            }
            else{
                System.out.println("您输入的密码有误，请重新输入");
                continue;
            }
        }
    }

    private void tansfer() {
        while (true) {
            if (accounts.size() < 2) {
                System.out.println("当前账户数量不足2个，无法转账，请先创建账户");
                return;
            }
            else{
                System.out.println("请输入要转账的目标账户的卡号：");
                String cardId = sc.next();
                Account targetAcc = getAccountByCardId(cardId);
                if (targetAcc == null) {
                    System.out.println("您输入的卡号不存在");
                }
                else {
                    String name = targetAcc.getUsername().substring(1);
                    System.out.println("请输入【"+name+"】的姓氏");
                    String inputName = sc.next();
                    if (!targetAcc.getUsername().startsWith(inputName)) {
                        System.out.println("您输入的姓氏不正确，请重新输入卡号");
                        continue;
                    }
                    else{
                        while (true) {
                            System.out.println("请输入要转账的金额：");
                            Double money = sc.nextDouble();
                            if(money > loginAccount.getMoney()){
                                System.out.println("账户余额不足，是否继续转账？Y/N");
                                String re = sc.next();
                                if(re.equals("Y")){
                                    continue;
                                }
                                else{
                                    return;
                                }
                            }
                            else{
                                loginAccount.setMoney(loginAccount.getMoney() - money);
                                targetAcc.setMoney(targetAcc.getMoney() + money);
                                System.out.println("转账成功！当前账户余额为："+loginAccount.getMoney());
                                System.out.println("是否继续转账？Y/N");
                                String re = sc.next();
                                if (re.equals("Y")) {
                                    break;
                                }
                                else{
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void withdrawMoney() {
        System.out.println("==取款操作==");
        if (loginAccount.getMoney() < 100) {
            System.out.println("余额不足100，无法取款");
            return;
        }
        System.out.println("请您输入取款金额：");
        while (true) {
            Double money = sc.nextDouble();
            if (money > loginAccount.getMoney()) {
                System.out.println("余额不足，取款失败.您的余额为："+loginAccount.getMoney());
                return;
            }
            else{
                if(money > loginAccount.getMoney()){
                    System.out.println("您输入的取款金额超过取款限额,您的取款限额为"+loginAccount.getLimit()+"，请重新输入");
                    continue;
                }
                loginAccount.setMoney(loginAccount.getMoney() - money);
                System.out.println("取款成功，取款"+money+"元,账户余额："+loginAccount.getMoney());
                return;
            }
        }
    }

    private void depositMoney() {
        while (true) {
            System.out.println("==存款操作==");
            System.out.println("请输入您要存款的金额：");
            Double money = sc.nextDouble();
            loginAccount.setMoney(loginAccount.getMoney() + money);
            System.out.println("存款成功，您的余额为" + money);
            System.out.println("是否继续存款？Y/N");
            String re = sc.next();

            if (re.equals("N")) {
                return;
            }
        }
    }

    //创建账户
    private void createAccount() {
        Account acc = new Account();
        System.out.println("请输入您的姓名：");
        acc.setUsername(sc.next());

        while (true) {
            System.out.println("请输入您的性别：");
            char gender = sc.next().charAt(0);
            if (gender == '男' || gender == '女') {
                acc.setGender(gender);
                break;
            } else {
                System.out.println("输入有误，只能为男或女，请重新输入");
            }
        }

        while (true) {
            System.out.println("请输入您的账户密码：");
            String password = sc.next();
            System.out.println("请再次输入您的密码：");
            if (password.equals(sc.next())) {
                acc.setPassword(password);
                break;
            } else {
                System.out.println("您输入的两次密码不一致，请重新设置");
            }
        }

        System.out.println("请输入你的取现额度：");
        acc.setLimit(sc.nextDouble());

        //随机生成卡号
        String newCardId = createCardId();
        acc.setId(newCardId);

        accounts.add(acc);
        System.out.println("恭喜您！" + acc.getUsername() + "开户成功，您的卡号是：" + acc.getId());
    }

    //生成卡号
    private String createCardId() {
        while (true) {
            String cardId = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);
                cardId += data;
            }
            if (getAccountByCardId(cardId) == null) {
                return cardId;
            }

        }
    }

    //根据卡号获取账户对象
    private Account getAccountByCardId(String cardId) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getId().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }

    //展示账号信息
    private void showAccountInfo() {
        System.out.println("您当前的账号信息如下：");
        System.out.println("卡号：" + loginAccount.getId());
        System.out.println("用户：" + loginAccount.getUsername());
        System.out.println("余额:" + loginAccount.getMoney());
        System.out.println("提现额度：:" + loginAccount.getLimit());
    }

}
