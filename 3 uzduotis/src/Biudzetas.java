import java.util.ArrayList;

public class Biudzetas {

    ArrayList<Irasas> irasas = new ArrayList<>();
    ArrayList<PajamuIrasas> pajamuIrasas = new ArrayList<>();
    ArrayList<IslaiduIrasas> islaiduIrasas = new ArrayList<>();

    public double balansas(ArrayList<PajamuIrasas> pajamuIrasas, ArrayList<IslaiduIrasas> islaiduIrasas) {
        double suma1 = 0;
        double suma2 = 0;
        for (PajamuIrasas element: pajamuIrasas) {
            if (element.suma != 0){
                suma1 += element.suma;
            }
        }
        for (IslaiduIrasas element: islaiduIrasas) {
            if (element.suma != 0){
            suma2 += element.suma;
            }
        }
        return suma1 - suma2;
    }

    public void pridetiIrasa(Irasas irasas){

    }
}
