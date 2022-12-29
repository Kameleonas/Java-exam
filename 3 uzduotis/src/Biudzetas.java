import java.util.ArrayList;

public class Biudzetas {
    ArrayList<Irasas> irasas = new ArrayList<>();

    public double balansas(ArrayList<Irasas> irasas) {
        double suma1 = 0;
        double suma2 = 0;
        for (PajamuIrasas element: gautiPajamuIrasus(irasas)) {
            if (element.getSuma() != 0){
                suma1 += element.getSuma();
            }
        }
        for (IslaiduIrasas element: gautiIslaiduIrasus(irasas)) {
            if (element.getSuma() != 0){
            suma2 += element.getSuma();
            }
        }
        return suma1 - suma2;
    }

    public void pridetiIrasa(Irasas irasas){
        this.irasas.add(irasas);
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasus(ArrayList<Irasas> irasas) {
        ArrayList<PajamuIrasas> pajamuIrasai = new ArrayList<>();
        for (Irasas element: irasas) {
            if (element instanceof PajamuIrasas){
                pajamuIrasai.add((PajamuIrasas) element);
            }
        }
        return pajamuIrasai;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasus(ArrayList<Irasas> irasas) {
        ArrayList<IslaiduIrasas> islaiduIrasai = new ArrayList<>();
        for (Irasas element: irasas) {
            if (element instanceof IslaiduIrasas){
                islaiduIrasai.add((IslaiduIrasas) element);
            }
        }
        return islaiduIrasai;
    }
}
