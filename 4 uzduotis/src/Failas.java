import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Failas{

    private String fileName;

    public Failas(String fileName) {
        this.fileName = fileName;
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
        File file = new java.io.File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] record = line.split(",");
            irasas.add(new Irasas(parseDouble(record[0]),record[1],parseInt(record[2]), record[3], record[4]));
        }

        bufferedReader.close();
        fileReader.close();

        return irasas;
    }
}
