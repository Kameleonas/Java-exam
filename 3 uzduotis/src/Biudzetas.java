import java.util.ArrayList;
import java.util.Collection;

public class Biudzetas {
    ArrayList<Irasas> irasas = new ArrayList<>();

    public double balansas(ArrayList<PajamuIrasas> pajamuIrasas, ArrayList<IslaiduIrasas> islaiduIrasas) {
        double suma1 = 0;
        double suma2 = 0;
        for (PajamuIrasas element: pajamuIrasas) {
            if (element.getSuma() != 0){
                suma1 += element.getSuma();
            }
        }
        for (IslaiduIrasas element: islaiduIrasas) {
            if (element.getSuma() != 0){
            suma2 += element.getSuma();
            }
        }
        return suma1 - suma2;
    }

    public void pridetiIrasa(Irasas irasas){
        this.irasas.add(irasas);
    }

//    public ArrayList<PajamuIrasas> gautiPajamuIrasus(ArrayList<Irasas> irasas) {
//        ArrayList<PajamuIrasas> pajamuIrasai = new ArrayList<>();
//        for (Irasas element: irasas) {
//            if (element.getId().contains("IN")){
//                pajamuIrasai.add(new PajamuIrasas(element.getSuma(), element.getKategorijosIndeksas(), element.getDateTime(), element.getPapildomaInfo(), element.));
//            }
//        }
//    }
}
