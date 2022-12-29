import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class IslaiduIrasas extends Irasas{
    private String kortele;

    public IslaiduIrasas(double suma, String dateTime, int kategorijosIndeksas, String kortele, String papildomaInfo) {
        super();
        this.suma = suma;
        this.setDateTime(dateTime);
        this.setKategorijosIndeksas(kategorijosIndeksas);
        this.kortele = kortele;
        this.setPapildomaInfo(papildomaInfo);
        this.getId("islaidos");
    }

    public static void visiIslaiduIrasai(ArrayList<IslaiduIrasas> islaiduIrasas){
        for (IslaiduIrasas element: islaiduIrasas) {
            if (element != null){
                System.out.printf("Irasas (ID: %s)\n Islaidos - %s\n Kategorijos indeksas - %s\n Iraso data - %s\n Kortelė - %s\n Papildoma informacija - %s\n\n", element.getId("islaidos"), element.getSuma(), element.getKategorijosIndeksas(), element.getDateTime(), element.kortele, element.getPapildomaInfo());
            }
        }
    }

    @Override
    public String toString() {
        return "Islaidu Irasas:" +
                "suma=" + getSuma() +
                ", dateTime='" + getDateTime() + '\'' +
                ", kategorija=" + getKategorijosIndeksas() + '\'' +
                ", kortele='" + kortele + '\'' +
                ", papildomaInfo='" + getPapildomaInfo() +
                ", iraso ID:" + getId("islaidos") + '\'';
    }
}
