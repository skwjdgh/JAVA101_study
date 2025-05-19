class Sample {
    public int a;
    private int b;
    int c;
}


public class AcessEx {
    public static void main(String[] args) {
        Sample aClass = new Sample();
        aClass.a = 10;
        //aClass.b = 10; private 선언으로 인함
        aClass.c = 10;
    }
}
