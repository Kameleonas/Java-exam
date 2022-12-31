import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static final DateTimeFormatter localDateTime = DateTimeFormatter.ofPattern("yyyy.MM.dd hh.mm");
    public static final String prefixPajamosID = "IN-";
    public static final String prefixIslaidosID = "OUT-";

    public static void main(String[] args) {

        Biudzetas biudzetas = new Biudzetas();

        Failas failas = new Failas("New File", "From file");

        Scanner scanner = new Scanner(System.in);

        Functions.program(biudzetas, scanner, failas);

        scanner.close();

    }
}
