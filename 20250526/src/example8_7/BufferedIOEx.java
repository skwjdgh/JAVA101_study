package example8_7;

import java.io.*;
import java.util.Scanner;

public class BufferedIOEx {
    public static void main(String[] args) {
        try (
                FileReader fin = new FileReader("c:\\Temp\\test2.txt");
                BufferedOutputStream out = new BufferedOutputStream(System.out, 5)
        ) {
            int c;
            while ((c = fin.read()) != -1) {
                out.write(c);
            }
            // 사용자 입력 대기
            new Scanner(System.in).nextLine();
            out.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}