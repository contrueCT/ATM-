package ATM;

public class Account {
    private String id;
    private String username;
    private String password;
    private char gender;
    private double money;
    private double limit;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username +(gender == '男' ? "先生" : "女士");
    }

    public void setUsername(String username) {
        this.username = username ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
