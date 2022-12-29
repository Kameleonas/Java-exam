public class Irasas {
    private double suma;
    private String dateTime;
    private int kategorijosIndeksas;
    private String papildomaInfo;
    private String id = "";

    private static int counter1 = 0;
    private static int counter2 = 0;

    public Irasas(double suma, String dateTime, int kategorijosIndeksas, String papildomaInfo) {
        this.suma = suma;
        this.dateTime = dateTime;
        this.kategorijosIndeksas = kategorijosIndeksas;
        this.papildomaInfo = papildomaInfo;
    }

    public Irasas(String pajamosArIslaidos) {
        if (pajamosArIslaidos.equals("pajamos")) {
            id += Programa.prefixPajamosID + counter1;
            counter1++;
        }
        if (pajamosArIslaidos.equals("islaidos")) {
            id += Programa.prefixIslaidosID + counter2;
            counter2++;
        }
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getKategorijosIndeksas() {
        return kategorijosIndeksas;
    }

    public void setKategorijosIndeksas(int kategorijosIndeksas) {
        this.kategorijosIndeksas = kategorijosIndeksas;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    public String getId() {
       return id;
    }

}
