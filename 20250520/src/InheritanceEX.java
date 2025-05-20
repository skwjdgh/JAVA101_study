class Person1 {
    private int weight; //멤버 필드는 모두 프라이빗 관습적으로
    int age;
    protected int height;
    public String name;

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }
}

class Student2 extends Person1 {
    public void set(){
        age= 30;
        name = "홍길동";
        height = 175;
        //weight =99;
        setWeight(99);
    }
}

public class InheritanceEX {
    public static void main(String[] args) {
        Student2 s = new Student2();
        s.set();

        System.out.println(s.getWeight());
    }
}
