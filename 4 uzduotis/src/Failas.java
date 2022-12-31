import java.io.*;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Failas{

    private String fileName;
    private String fileNameFrom;

    public Failas(String fileName, String fileNameFrom) {
        this.fileName = fileName;
        this.fileNameFrom = fileNameFrom;
    }

    public void irasytiIFaila(ArrayList<Irasas> irasas) throws IOException {
        File file = new java.io.File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Irasas element : irasas) {
            bufferedWriter.write(String.join(",", element.toString()));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();
    }

    public ArrayList<Irasas> gautiIrasusIsFailo(ArrayList<Irasas> irasas) throws IOException {
        try {
            File file = new java.io.File(fileNameFrom);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] record = line.split(",");
                if (record[0].contains("IN")) {
                    // record = [IN, SUM, DATE TIME, CAT INDEX, INFO, TRX STATUS]
                    irasas.add(new PajamuIrasas(parseDouble(record[1]), parseInt(record[3]), record[2], record[4], parseBoolean(record[5])));
                } else if (record[0].contains("OUT")) {
                    // record = [OUT, SUM, DATE TIME, CAT INDEX, INFO, CARD]
                    irasas.add(new IslaiduIrasas(parseDouble(record[1]), record[2], parseInt(record[3]), record[5], record[4]));
                } else System.out.println("Error");
            }
            bufferedReader.close();
            fileReader.close();
        }catch (FileNotFoundException fnf){
            System.out.println("Failas, pavadinimu " + fileNameFrom + " nerastas");
        }
        return irasas;
    }
}
