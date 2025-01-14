package dormitory;

public class MemberOperator {
    Member[] members;
    public MemberOperator() {

    }
    public MemberOperator(Member[] members) {
        this.members = members;
    }
    public void display() {
        System.out.println("-----------以下是所有舍友信息--------------");
        for (int i = 0; i < members.length; i++) {
            Member member = members[i];
            System.out.println(member.getName()+" "+member.getAge());
        }
    }
}
