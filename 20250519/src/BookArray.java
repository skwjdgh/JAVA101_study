

import java.util.Scanner;

class Book3{
    String title,author;
    public Book3(String title, String autor){
        this.title = title;
        this.author = autor;
    }
}
public class BookArray {
    public static void main(String[] args) {
        Book3[] book = new Book3[2];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < book.length; i++) {
            System.out.print("제목 >>");
            String title = scanner.nextLine();
            System.out.print("저자>>");
            String author = scanner.nextLine();
            book[i] = new Book3(title, author);
        }
        for(int i = 0; i < book.length; i++) {
            System.out.print("("+ book[i].title +","+ book[i].author +")");
        }
        scanner.close();
    }
}
