import java.util.ArrayList;

public class Biudzetas {
    ArrayList<PajamuIrasas> pajamuIrasas = new ArrayList<>();
    ArrayList<IslaiduIrasas> islaiduIrasas = new ArrayList<>();

    public double balansas(ArrayList<PajamuIrasas> pajamuIrasas, ArrayList<IslaiduIrasas> islaiduIrasas) {
        double suma1 = 0;
        double suma2 = 0;
        for (PajamuIrasas element: pajamuIrasas) {
            if (element.pajamuSuma != 0){
                suma1 += element.pajamuSuma;
            }
        }
        for (IslaiduIrasas element: islaiduIrasas) {
            if (element.islaiduSuma != 0){
            suma2 += element.islaiduSuma;
            }
        }
        return suma1 - suma2;
    }
}
