import java.util.ArrayList;

public class PajamuIrasas {
    public double pajamuSuma;
    private int kategorijosIndeksas;
    private String date;
    private boolean transferComplete;
    private String papildomaInfo;
    private String id;

    public PajamuIrasas(double suma, int kategorijosIndeksas, String date, String papildomaInfo, boolean transferComplete, String id) {
        this.pajamuSuma = suma;
        this.kategorijosIndeksas = kategorijosIndeksas;
        this.date = date;
        this.transferComplete = transferComplete;
        this.papildomaInfo = papildomaInfo;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static void visiPajamuIrasai(ArrayList<PajamuIrasas> pajamuIrasas){
        for (PajamuIrasas element: pajamuIrasas) {
            if (element != null){
                System.out.printf("Irasas (ID: %s)\n Pajamos - %s\n Kategorijos indeksas - %s\n Iraso data - %s\n Pavedimas / mokėjimas gautas - %s\n Papildoma informacija - %s\n\n", element.id, element.pajamuSuma, element.kategorijosIndeksas, element.date, element.transferComplete, element.papildomaInfo);
            }
        }
    }

    @Override
    public String toString() {
        return "Pajamu Irasas: " +
                "suma=" + pajamuSuma +
                ", kategorijosIndeksas=" + kategorijosIndeksas +
                ", date='" + date + '\'' +
                ", transferComplete=" + transferComplete +
                ", papildomaInfo='" + papildomaInfo +
                ", iraso ID:" + id + '\'';
    }
}
