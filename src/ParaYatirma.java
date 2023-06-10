public class ParaYatirma {
    private AnaHesap anaHesap;

    public ParaYatirma(AnaHesap anaHesap) {
        this.anaHesap = anaHesap;
    }

    public void yatirilanParaMiktari(double miktar, String paraBirimi) {
        anaHesap.paraYatir(miktar);
        anaHesap.paraYatir(miktar, paraBirimi);
    }
}