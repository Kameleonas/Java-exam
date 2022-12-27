import java.time.LocalDate;
import java.util.Date;

public class PajamuIrasas {
    int pajamuSuma;
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

    @Override
    public String toString() {
        return "Pajamu Irasas: " +
                "suma=" + pajamuSuma +
                ", kategorijosIndeksas=" + kategorijosIndeksas +
                ", date='" + date + '\'' +
                ", transferComplete=" + transferComplete +
                ", papildomaInfo='" + papildomaInfo + '\'';
    }
}
