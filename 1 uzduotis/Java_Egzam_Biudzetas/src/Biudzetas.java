import java.lang.reflect.Array;

public class Biudzetas {
    PajamuIrasas[] pajamuIrasas = new PajamuIrasas[100];
    IslaiduIrasas[] islaiduIrasas = new IslaiduIrasas[100];

    public PajamuIrasas gautiPajamuIrasa(int i) {
        return pajamuIrasas[i];
    }

    public IslaiduIrasas gautiIslaiduIrasa(int i) {
        return islaiduIrasas[i];
    }
}
