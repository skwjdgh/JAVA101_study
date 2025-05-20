class Shape1{
    public Shape1 next;
    public Shape1(){ next = null; }

    public void draw(){
        System.out.println("Shape1");
    }
}

class Line1 extends Shape1{
    public void draw(){
        System.out.println("Line1");
    }
}

class Rect1 extends Shape1{
    public void draw(){
        System.out.println("Rect1");
    }
}

class Circle1 extends Shape1{
    public void draw(){
        System.out.println("Circle1");
    }
}

public class UsingOverride {
    public static void main(String[] args) {
        Shape1 start,last,obj;
        start = new Line1();
        last = start;
        obj = new Rect1();
        last.next = obj;
        last = obj;
        obj = new Line1();
        last.next = obj;
        last = obj;
        obj = new Circle1();
        last.next = obj;
        Shape1 p = start;
        while(p != null){
            p.draw();
            p = p.next;
        }

    }
}
