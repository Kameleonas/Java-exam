public class Irasas {
    public double suma;
    private String dateTime;
    private int kategorijosIndeksas;
    private String papildomaInfo;
    private String id;


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

    public String getId(String pajamosArIslaidos) {
        if (pajamosArIslaidos.equals("pajamos")) {
            int counter1 = 0;
            counter1++;
            id += Programa.prefixPajamosID + counter1;
            return id;
        }
        if (pajamosArIslaidos.equals("islaidos")) {
            int counter2 = 0;
            counter2++;
            id += Programa.prefixIslaidosID + counter2;
            return id;
        }
        return id;
    }

}
