import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Functions {
    public static void printDefault() {
        System.out.println("""
                        *Menu*
                [1] - naujas pajamų įrašas;
                [2] - naujas išlaidų įrašas;
                [3] - rasti pajamų ar išlaidų įrašą pagal ID;
                [4] - balansas;
                [5] - atspausdinti visas pajamas;
                [6] - atspausdinti visas išlaidas;
                [7] - pašalinti įrašą;
                [8] - redaguoti įrašą;
                [9] - išsaugoti duomenis į failą;
                [10] - gauti duomenis iš failo;
                [11] - išeiti;""");
    }

    public static void program(Biudzetas biudzetas, Scanner scanner, Failas failas) {
        boolean runProgram = true;
        int userInput = 0;

        while (runProgram) {
            try {
                switch (userInput) {
                    case 0 -> {
                        Functions.printDefault();
                        userInput = scanner.nextInt();
                    }
                    case 1 -> { // Naujas pajamų įrašas
                        System.out.println("Naujas pajamu irasas");
                        String[] irasas = naujasIrasas(scanner, "pajamos").split("/");
                        biudzetas.pridetiIrasa(new PajamuIrasas(parseDouble(irasas[0]), parseInt(irasas[1]), irasas[2], irasas[3], Boolean.parseBoolean(irasas[4])));
//                go to start of the program
                        userInput = 0;
                    }
                    case 2 -> {// naujas išlaidų įrašas
                        String[] irasas = naujasIrasas(scanner, "islaidos").split("/");
                        biudzetas.pridetiIrasa(new IslaiduIrasas(parseDouble(irasas[0]), irasas[1], irasas[2], irasas[3], parseInt(irasas[4])));
//                go to start of the program
                        userInput = 0;
                    }
                    case 3 -> {// pajamų / išlaidų įrašo suradimas
                        rastiRedaguotiIrasa(scanner, biudzetas, "rasti");
//                      go to start of the program
                        userInput = 0;
                    }
                    case 4 -> {
                        System.out.printf("Jūsų biudžetas: %s Eur\n", biudzetas.balansas(biudzetas.irasas));
                        userInput = 0;
                    }
                    case 5 -> {
                        PajamuIrasas.visiPajamuIrasai(biudzetas.gautiPajamuIrasus(biudzetas.irasas));
////                go to start of the program
                        userInput = 0;
                    }
                    case 6 -> {
                        IslaiduIrasas.visiIslaiduIrasai(biudzetas.gautiIslaiduIrasus(biudzetas.irasas));
////                go to start of the program
                        userInput = 0;
                    }
                    case 7 -> {
                        trintiIrasa(biudzetas, scanner);
////                go to start of the program
                        userInput = 0;
                    }
                    case 8 -> {// Įrašo redagavimas
                        rastiRedaguotiIrasa(scanner, biudzetas, "redaguoti");
//                    go to start of the program
                        userInput = 0;
                    }
                    case 9 -> {
                        failas.irasytiIFaila(biudzetas.irasas);
//                    go to start of the program
                        userInput = 0;
                    }
                    case 10 -> {
                        failas.gautiIrasusIsFailo(biudzetas.irasas);
//                        go to start of the program
                        userInput = 0;
                    }
                    case 11 -> runProgram = false;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Klaida! Įveskite skaičių nuo 1 iki 9, pasirinkimams iš pafrindinio meniu: ");
                scanner.nextLine();
                userInput = scanner.nextInt();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String naujasIrasas(Scanner scanner, String pajamosArIslaidos) {
        boolean transferComplete = false;
        int index = 0;
        String stringResult = null;
        CardType card = null;
        double userInSuma;
        int userInputCard = 0;

        switch (pajamosArIslaidos) {
            case "pajamos" -> System.out.println("Įveskite pajamų sumą:");
            case "islaidos" -> System.out.println("Iveskite išleistą sumą:");
            default -> System.out.println("Error");
        }

        while (true) {
            try {
                userInSuma = scanner.nextDouble();
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Įveskite double tipo reikšmę Sumai: ");
                scanner.nextLine();
            }
        }

        System.out.print("""
                [1] - gryni pinigai;
                [2] - bankinis pavedimas;
                """);

        while (true) {
            try {
                index = scanner.nextInt();
                if (index == 1 || index == 2) {
                    break;
                } else {
                    System.out.println("Pasirinkite [1] - grįni pinigai arba [2] - bankinis pavedimas: ");
                    scanner.nextLine();
                }
            } catch (InputMismatchException ime) {
                System.out.println("Pasirinkite [1] arba [2]: ");
                scanner.nextLine();
            }
        }

        if (index == 1) {
            scanner.nextLine();
            transferComplete = true;
        } else if (pajamosArIslaidos.equals("pajamos")) {
            System.out.println("""
                    Ar pavedimas baigtas ir pinigai gauti?
                    [1] - Taip;
                    [2] - Ne;""");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput) {
                case 1 -> transferComplete = true;
                case 2 -> transferComplete = false;
                default -> System.out.println("Error Input value");
            }
        } else if (pajamosArIslaidos.equals("islaidos")) {
            System.out.println("""
                    Kortelė kuria buvo vykdomas mokėjimas:
                    [1] - Maestro;
                    [2] - MasterCard;
                    [3] - Visa;
                    [4] - AMEX;""");

            while (true) {
                try {
                    userInputCard = scanner.nextInt();
                    scanner.nextLine();
                    if (userInputCard == 1 || userInputCard == 2 || userInputCard == 3 || userInputCard == 4) {
                        break;
                    } else {
                        System.out.println("Įveskite pasirinkimą - nuo 1 iki 4: ");
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Įveskite pasirinkimą - nuo 1 iki 4: ");
                    scanner.nextLine();
                }
            }

            switch (userInputCard) {
                case 1 -> card = CardType.MAESTRO;
                case 2 -> card = CardType.MASTERCARD;
                case 3 -> card = CardType.VISA;
                case 4 -> card = CardType.AMEX;
            }
        }

        try{
        switch (pajamosArIslaidos) {
            case "pajamos" -> {
                System.out.println("Papildomas komentaras apie pajamų įrašą:");
                String currentDate = LocalDateTime.now().format(Programa.localDateTime);
                    String comment = scanner.nextLine();
                    stringResult = userInSuma + "/" + index + "/" + currentDate + "/" + comment + "/" + transferComplete;
                return stringResult;
            }
            case "islaidos" -> {
                System.out.println("Papildomas komentaras apie išlaidų įrašą:");
                String currentDateTime = LocalDateTime.now().format(Programa.localDateTime);
                    String comment = scanner.nextLine();
                    stringResult = userInSuma + "/" + currentDateTime + "/" + card + "/" + comment + "/" + index;
                return stringResult;
            }
        }
        }catch (ArrayIndexOutOfBoundsException oob){
            System.out.println("Input Error");
            stringResult = "";
        }
        return stringResult;
    }

    public static void trintiIrasa(Biudzetas biudzetas, Scanner scanner) {
        System.out.println("""
                Pasirinkite kurį įrašą norite ištrinti:
                [1] - pajamų įrašas;
                [2] - išlaidų įrašas;""");

        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1 -> {
                System.out.println("Įveskite įrašo, kurį norite ištrinti ID [formatu IN-0]:");
                String findAndDelete = scanner.next();
                idCheckAndRemove(biudzetas.irasas, findAndDelete);
            }
            case 2 -> {
                System.out.println("Įveskite įrašo, kurį norite ištrinti ID [formatu - OUT-0]:");
                String findAndDelete = scanner.next();
                idCheckAndRemove(biudzetas.irasas, findAndDelete);
            }
            default -> System.out.println("Įvesties klaida.");
        }
    }

    public static void idCheckAndRemove(ArrayList<Irasas> irasas, String pajamosID) {
        for (Irasas element : irasas) {
            if (element.getId().equals(pajamosID)) {
                irasas.remove(element);
                return;
            }
        }
    }

    public static void rastiRedaguotiIrasa(Scanner scanner, Biudzetas biudzetas, String rasti) {
        Irasas toReplace = null;

        if (biudzetas.irasas.size() == 0) {
            System.out.println("Jokių išsaugotų įrašų nėra.");
        } else {
            if (rasti.equals("rasti")) {
                System.out.println("Įveskite įrašo kurį norite rasti ID:");
            } else if (rasti.equals("redaguoti")) {
                System.out.println("Įveskite įrašo kurį norite redaguoti ID:");
            }
            String userInFindByKey = scanner.next();
            for (Irasas element : biudzetas.irasas) {
                if (element.getId().equals(userInFindByKey)) {
                    System.out.printf("Įrašas rastas: \n %s \n", element);
                    toReplace = element;
                }
            }
        }

        if (rasti.equals("redaguoti") && toReplace != null) {
            System.out.println("Suma: " + toReplace.getSuma());
            if (userChoice(scanner)) {
                System.out.println("iveskite sumą: ");
                double sum = scanner.nextDouble();
                toReplace.setSuma(sum);
            }
            toReplace.setDateTime(LocalDateTime.now().format(Programa.localDateTime)); /// reset date
            System.out.println("Kategorijos indeksas: " + toReplace.getKategorijosIndeksas());
            if (userChoice(scanner)) {
                System.out.println("[1] - grįni pinigai [2] - bankinis pavedimas: ");
                int index = scanner.nextInt();
                switch (index) {
                    case 1, 2 -> toReplace.setKategorijosIndeksas(index);
                    default -> {
                        System.out.println("Klaida! Neteisinga įvestis");
                        index = scanner.nextInt();
                    }
                }
                toReplace.setKategorijosIndeksas(index);
            }
            System.out.println("Papildoma informacija: " + toReplace.getPapildomaInfo());
            if (userChoice(scanner)) {
                System.out.println("Įveskite papildomą informaciją: ");
                scanner.nextLine();
                String info = scanner.nextLine();
                toReplace.setPapildomaInfo(info);
            }
            if (toReplace instanceof PajamuIrasas) {
                System.out.println("Sandoris užbaigtas: " + ((PajamuIrasas) toReplace).isTransferComplete());
                if (userChoice(scanner)) {
                    System.out.println("Įveskite ar sandoris užbaigtas [true / false]: ");
                    boolean complete = scanner.nextBoolean();
                    ((PajamuIrasas) toReplace).setTransferComplete(complete);
                }
            }
            if (toReplace instanceof IslaiduIrasas) {
                System.out.println("Kortelė kuria buvo atsiskaityta: " + ((IslaiduIrasas) toReplace).getKortele());
                if (userChoice(scanner)) {
                    System.out.println("Įveskite kokia kortele buvo atsiskaityta: ");
                    String card = scanner.next();
                    ((IslaiduIrasas) toReplace).setKortele(card);
                }
            }
        }
    }

    public static boolean userChoice(Scanner scanner) {
        System.out.println("""
                [1] - keisti;
                [2] - toliau;""");
        boolean replace;
        while (true) {
            try {
                int userInput = scanner.nextInt();
                if (userInput == 1) {
                    replace = true;
                    break;
                } else if (userInput == 2) {
                    replace = false;
                    break;
                } else {
                    System.out.println("Pasirinkite [1] - pakeisti įrašą arba [2] - eiti toliau: ");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Pasirinkite [1] - pakeisti įrašą arba [2] - eiti toliau: ");
                scanner.nextLine();
            }
        }
        return replace;
    }
}
