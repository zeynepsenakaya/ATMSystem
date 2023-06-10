public class ParaCekme {
    private AnaHesap anaHesap;

    public ParaCekme(AnaHesap anaHesap) {
        this.anaHesap = anaHesap;
    }

    public void cekilenParaMiktari(double miktar, String paraBirimi) {
        anaHesap.paraCek(miktar);
        anaHesap.paraCek(miktar, paraBirimi);
    }
}