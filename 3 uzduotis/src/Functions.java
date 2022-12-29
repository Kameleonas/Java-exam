import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Functions {
    public static void printDefault() {
        System.out.println("""
                        *Menu*
                [1] - naujas pajamų įrašas;
                [2] - naujas išlaidų įrašas;
                [3] - rasti pajamų įrašą;
                [4] - rasti išlaidų įrašą;
                [5] - balansas;
                [6] - atspausdinti visas pajamas;
                [7] - atspausdinti visas išlaidas;
                [8] - pašalinti įrašą;
                [9] - išeiti;""");
    }

    public static void program(Biudzetas biudzetas, Scanner scanner, String prefixPajamosID, String prefixIslaidosID) {
        boolean runProgram = true;
        int userInput = 0;
        int idIn = 0;
        int idOut = 0;

        while (runProgram) {
            switch (userInput) {
                case 0 -> {
                    Functions.printDefault();
                    userInput = scanner.nextInt();
                }
                case 1 -> { // Naujas pajamų įrašas
                    System.out.println("Naujas pajamu irasas");
                    String[] irasas = naujasIrasas(scanner, "pajamos").split("/");
                    biudzetas.pajamuIrasas.add(new PajamuIrasas(parseDouble(irasas[0]), parseInt(irasas[1]), irasas[2], irasas[3], Boolean.parseBoolean(irasas[4])));

//                go to start of the program
                    userInput = 0;
                }
                case 2 -> {// naujas išlaidų įrašas
                    String[] irasas = naujasIrasas(scanner, "islaidos").split("/");
                    biudzetas.islaiduIrasas.add(new IslaiduIrasas(parseDouble(irasas[0]), irasas[1], parseInt(irasas[2]), irasas[3], irasas[4]));
//                go to start of the program
                    userInput = 0;
                }
                case 3 -> {// pajamų įrašo suradimas
                    System.out.println("Įveskite pajamų įrašo eilės numerį, įrašo suradimui");
                    int userInFindByKey = scanner.nextInt();
                    if (biudzetas.pajamuIrasas.get(userInFindByKey) == null) {
                        System.out.println("Įrašas su tokiu eilės numeriu nerastas.");
//                go to start of the program
                        userInput = 0;
                    } else {
                        System.out.println(biudzetas.pajamuIrasas.get(userInFindByKey));
//                go to start of the program
                        userInput = 0;
                    }
                }
                case 4 -> {// išlaidų įrašo suradimas
                    System.out.println("Įveskite išlaidų įrašo eilės numerį, įrašo suradimui");
                    int userInFindByKey = scanner.nextInt();
                    if (biudzetas.islaiduIrasas.get(userInFindByKey) == null) {
                        System.out.println("Įrašas su tokiu eilės numeriu nerastas.");
//                go to start of the program
                        userInput = 0;
                    } else {
                        System.out.println(biudzetas.islaiduIrasas.get(userInFindByKey));
//                go to start of the program
                        userInput = 0;
                    }
                }
                case 5 -> {
                    System.out.printf("Jūsų biudžetas: %s Eur\n", biudzetas.balansas(biudzetas.pajamuIrasas, biudzetas.islaiduIrasas));
                    userInput = 0;
                }
                case 6 -> {
                    PajamuIrasas.visiPajamuIrasai(biudzetas.pajamuIrasas);
//                go to start of the program
                    userInput = 0;
                }
                case 7 -> {
                    IslaiduIrasas.visiIslaiduIrasai(biudzetas.islaiduIrasas);
//                go to start of the program
                    userInput = 0;
                }
                case 8 -> {
                    trintiIrasa(biudzetas.pajamuIrasas, biudzetas.islaiduIrasas, scanner);
//                go to start of the program
                    userInput = 0;
                }
                case 9 -> runProgram = false;
            }
        }
    }

    public static String naujasIrasas(Scanner scanner, String pajamosArIslaidos) {
        boolean transferComplete = false;
        int index;
        String stringResult = null;
        CardType card = null;

        switch (pajamosArIslaidos) {
            case "pajamos" -> System.out.println("Įveskite gautų pajamų sumą:");
            case "islaidos" -> System.out.println("Iveskite išleistą sumą:");
            default -> System.out.println("Error");
        }

        double userInSuma = scanner.nextDouble();

        do {
            System.out.print("""
                    [1] - gryni pinigai;
                    [2] - bankinis pavedimas;
                    """);
            index = scanner.nextInt();
        } while (index != 1 && index != 2);

        if (index == 1) {
            transferComplete = true;
        }

        if (pajamosArIslaidos.equals("pajamos") && index == 2) {
            System.out.println("""
                    Ar pavedimas baigtas ir pinigai gauti?
                    [1] - Taip;
                    [2] - Ne;""");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1 -> transferComplete = true;
                case 2 -> transferComplete = false;
                default -> System.out.println("Error Input value");
            }
        }
        if (pajamosArIslaidos.equals("islaidos") && index == 2) {
            System.out.println("""
                    Kortelė kuria buvo vykdomas mokėjimas:
                    [1] - Maestro;
                    [2] - MasterCard;
                    [3] - Visa;
                    [4] - AMEX;""");
            int userInputCard = scanner.nextInt();
            switch (userInputCard) {
                case 1 -> card = CardType.MAESTRO;
                case 2 -> card = CardType.MASTERCARD;
                case 3 -> card = CardType.VISA;
                case 4 -> card = CardType.AMEX;
            }
        }
        switch (pajamosArIslaidos) {
            case "pajamos" -> {
                System.out.println("Papildomas komentaras apie gautą pajamų įrašą:");
                String currentDate = LocalDate.now().format(Programa.localDate);
                String comment = scanner.next();
                stringResult = userInSuma + "/" + index + "/" + currentDate + "/" + comment + "/" + transferComplete;
                return stringResult;
            }
            case "islaidos" -> {
                System.out.println("Papildomas komentaras apie išlaidų įrašą:");
                String currentDateTime = LocalDateTime.now().format(Programa.localDateTime);
                String comment = scanner.next();
                stringResult = userInSuma + "/" + currentDateTime + "/" + index + "/" + card + "/" + comment;

                return stringResult;
            }
        }
        return stringResult;
    }

    public static void trintiIrasa(ArrayList<PajamuIrasas> pajamuIrasas, ArrayList<IslaiduIrasas> islaiduIrasas, Scanner scanner) {
        System.out.println("""
                Pasirinkite kurį įrašą norite ištrinti:
                [1] - pajamų įrašas;
                [2] - išlaidų įrašas;""");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> {
                System.out.println("Įveskite įrašo, kurį norite ištrinti ID [formatu IN-0]:");
                String findAndDelete = scanner.next();
                idCheckAndRemove(pajamuIrasas, findAndDelete);
            }
            case 2 -> {
                System.out.println("Įveskite įrašo, kurį norite ištrinti ID [formatu - OUT-0]:");
                String findAndDelete = scanner.next();
                idCheckAndRemove2(islaiduIrasas, findAndDelete);
            }
            default -> System.out.println("Įvesties klaida.");
        }
    }

    public static void idCheckAndRemove(ArrayList<PajamuIrasas> pajamuIrasas, String pajamosID) {
        for (PajamuIrasas irasas: pajamuIrasas) {
            if (irasas.getId("pajamos").equals(pajamosID)){
                pajamuIrasas.remove(irasas);
                return;
            }
        }
    }

    public static void idCheckAndRemove2(ArrayList<IslaiduIrasas> islaiduIrasas, String islaidosID) {
        for (IslaiduIrasas irasas: islaiduIrasas) {
            if (irasas.getId("islaidos").equals(islaidosID)){
                islaiduIrasas.remove(irasas);
                return;
            }
        }
    }
}
