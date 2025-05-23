interface PhoneInterface2 {
    final int TIMEOUT = 10000;
    void sendCall();
    void receiveCall();
    default void printLogo() {
        System.out.println("** Phone **");
    }
}

interface MobilePhoneInterface2 extends PhoneInterface2 {
    void sendSMS();
    void receiveSMS();
}

interface MP3Interface {
    public void play();
    public void stop();
}

class PDA {
    public int calculate(int x, int y) {
        return x + y;
    }
}

class SmartPhone2 extends PDA implements MobilePhoneInterface2, MP3Interface {
    @Override
    public void sendCall() {
        System.out.println("따르릉따르릉~~");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화 왔어요.");
    }

    @Override
    public void sendSMS() {
        System.out.println("문자 보냅니다.");
    }

    @Override
    public void receiveSMS() {
        System.out.println("문자 왔어요.");
    }

    @Override
    public void play() {
        System.out.println("음악 연주합니다.");
    }

    @Override
    public void stop() {
        System.out.println("음악 중단합니다.");
    }

    public void schedule() {
        System.out.println("일정 관리합니다.");
    }
}

public class InterfaceEx2 {
    public static void main(String[] args) {
        SmartPhone2 phone = new SmartPhone2();
        phone.printLogo();
        phone.sendCall();
        phone.play();
        System.out.println("3과 5를 더하면 " + phone.calculate(3, 5));
        phone.schedule();
    }
}
