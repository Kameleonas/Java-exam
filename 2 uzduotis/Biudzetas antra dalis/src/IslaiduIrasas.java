import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class IslaiduIrasas{
    public double islaiduSuma;
    private String dateTime;
    private int kategorijosIndeksas;
    private String kortele;
    private String papildomaInfo;
    private String id;

    public IslaiduIrasas(double suma, String dateTime, int kategorijosIndeksas, String kortele, String papildomaInfo, String id) {
        this.islaiduSuma = suma;
        this.dateTime = dateTime;
        this.kategorijosIndeksas = kategorijosIndeksas;
        this.kortele = kortele;
        this.papildomaInfo = papildomaInfo;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static void visiIslaiduIrasai(ArrayList<IslaiduIrasas> islaiduIrasas){
        for (IslaiduIrasas element: islaiduIrasas) {
            if (element != null){
                System.out.printf("Irasas (ID: %s)\n Islaidos - %s\n Kategorijos indeksas - %s\n Iraso data - %s\n Kortelė - %s\n Papildoma informacija - %s\n\n", element.id, element.islaiduSuma, element.kategorijosIndeksas, element.dateTime, element.kortele, element.papildomaInfo);
            }
        }
    }

    @Override
    public String toString() {
        return "Islaidu Irasas:" +
                "suma=" + islaiduSuma +
                ", dateTime='" + dateTime + '\'' +
                ", kategorija=" + kategorijosIndeksas + '\'' +
                ", kortele='" + kortele + '\'' +
                ", papildomaInfo='" + papildomaInfo +
                ", iraso ID:" + id + '\'';
    }
}
