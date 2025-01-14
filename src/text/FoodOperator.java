package text;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodOperator {
    ArrayList<Food> foodlist =  new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void addFood() {
        Food f = new Food();
        System.out.println("请输入菜品名称：");
        f.setName(sc.next());
        System.out.println("请输入菜品价格：");
        f.setPrice(sc.nextDouble());
        System.out.println("请输入菜品描述：");
        f.setDescription(sc.next());
        foodlist.add(f);
        System.out.println("上架成功");
    }
    public void showAllFood() {
        if (foodlist.isEmpty()) {
            System.out.println("什么菜品都没有");
            return;
        }
        for (int i = 0; i < foodlist.size(); i++) {
            Food f = foodlist.get(i);
            f = foodlist.get(i);
            System.out.println(f.getName() + " " + f.getPrice() + " " + f.getDescription());
        }
    }

    public void start(){
        while (true) {
            System.out.println("请选择功能");
            System.out.println("1.上架菜品");
            System.out.println("2.展示菜品");
            System.out.println("3.推出");
            String choice = sc.next();
            if(choice.equals("1")){
                addFood();
            }
            else if(choice.equals("2")){
                showAllFood();
            }
            else if(choice.equals("3")){
                break;
            }
            else{
                System.out.println("您输入的命令不存在！");
            }
        }
    }
}
