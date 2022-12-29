import java.util.ArrayList;

public class PajamuIrasas extends Irasas{

    protected boolean transferComplete;

    public PajamuIrasas(double suma, int kategorijosIndeksas, String date, String papildomaInfo, boolean transferComplete) {
        super("pajamos");
        this.setSuma(suma);
        this.setKategorijosIndeksas(kategorijosIndeksas);
        this.setDateTime(date);
        this.setPapildomaInfo(papildomaInfo);
        this.transferComplete = transferComplete;
    }

    public boolean isTransferComplete() {
        return transferComplete;
    }

    public void setTransferComplete(boolean transferComplete) {
        this.transferComplete = transferComplete;
    }

    public static void visiPajamuIrasai(ArrayList<PajamuIrasas> pajamuIrasas){
        for (PajamuIrasas element: pajamuIrasas) {
            if (element != null){
                System.out.printf("Irasas (ID: %s)\n Pajamos - %s\n Kategorijos indeksas - %s\n Iraso data - %s\n Pavedimas / mokėjimas gautas - %s\n Papildoma informacija - %s\n\n", element.getId(), element.getSuma(), element.getKategorijosIndeksas(), element.getDateTime(), element.transferComplete, element.getPapildomaInfo());
            }
        }
    }

    @Override
    public String toString() {
        return "Pajamu Irasas: " +
                "suma=" + getSuma() +
                ", kategorijosIndeksas=" + getKategorijosIndeksas() +
                ", date='" + getDateTime() + '\'' +
                ", transferComplete=" + transferComplete +
                ", papildomaInfo='" + getPapildomaInfo() +
                ", iraso ID:" + getId() + '\'';
    }
}
