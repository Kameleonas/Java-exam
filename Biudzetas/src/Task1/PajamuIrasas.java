package Task1;

public class PajamuIrasas {
    public int pajamuSuma;
    private int kategorijosIndeksas;
    private String date;
    private boolean transferComplete;
    private String papildomaInfo;

    public PajamuIrasas(int suma, int kategorijosIndeksas, String date, String papildomaInfo, boolean transferComplete) {
        this.pajamuSuma = suma;
        this.kategorijosIndeksas = kategorijosIndeksas;
        this.date = date;
        this.transferComplete = transferComplete;
        this.papildomaInfo = papildomaInfo;
    }
}
