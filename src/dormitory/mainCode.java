package dormitory;


public class mainCode {
    public static void main(String[] args) {
        Member[] movies = new Member[4];
        movies[0] = new Member("裴天宝",18);
        movies[1] = new Member("朱祖禾",18);
        movies[2] = new Member("庄凯勋",19);
        movies[3] = new Member("谢俊翔",18);
        System.out.println(movies[0].getAge()+" " +movies[0].getName());
        System.out.println("------------------");
        MemberOperator operator = new MemberOperator(movies);
        operator.display();
    }
}
