package Task1;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Programa {
    public static final DateTimeFormatter localDate = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    public static final DateTimeFormatter localDateTime = DateTimeFormatter.ofPattern("yyyy.MM.dd hh.mm");

    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();

        Scanner scanner = new Scanner(System.in);

        scanner.close();

    }
}