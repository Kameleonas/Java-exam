import java.util.ArrayList;

public class IslaiduIrasas extends Irasas{
    protected String kortele;

    public IslaiduIrasas(double suma, String dateTime, String kortele, String papildomaInfo, int kategorijosIndeksas) {
        super(suma, dateTime, kategorijosIndeksas, papildomaInfo, "islaidos");
        this.kortele = kortele;
    }

    public String getKortele() {
        return kortele;
    }

    public void setKortele(String kortele) {
        this.kortele = kortele;
    }

    public static void visiIslaiduIrasai(ArrayList<IslaiduIrasas> islaiduIrasas){
        for (IslaiduIrasas element: islaiduIrasas) {
            if (element != null){
                System.out.printf("Irasas (ID: %s)\n Islaidos - %s\n Kategorijos indeksas - %s\n Iraso data - %s\n Kortelė - %s\n Papildoma informacija - %s\n\n", element.getId(), element.getSuma(), element.getKategorijosIndeksas(), element.getDateTime(), element.kortele, element.getPapildomaInfo());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("""
                Islaidu Irasas, ID: %s,
                suma= %s,
                dateTime= %s,
                kategorija= %s,
                kortele= %s,
                papildomaInfo= %s
                """, getId(), getSuma(), getDateTime(), getKategorijosIndeksas(), kortele, getPapildomaInfo());
    }
}
