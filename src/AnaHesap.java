public class AnaHesap implements IParaYatir, IParaCek {
    private String isim;
    private int hesapNo;
    private double bakiye;

    public AnaHesap(String isim, int hesapNo) {
        this.isim = isim;
        this.hesapNo = hesapNo;
        this.bakiye = 5000.0; // varsayılan başlangıç bakiyesi 5000 TL
    }

    public void paraYatir(double miktar) {
        bakiye += miktar;
    }

    @Override
    public void paraYatir(double miktar, String paraBirimi) {
        paraBirimi = "₺";
        System.out.println("Yatırılan Para Miktarı:" + miktar+ paraBirimi);
        bakiyeSorgula();
    }

    public void paraCek(double miktar) {
        if (bakiye >= miktar) {
            bakiye -= miktar;
        } else {
            System.out.println("Yetersiz Bakiye");
        }
    }

    public void paraCek(double miktar, String paraBirimi) {
        paraBirimi = "₺";
        System.out.println("Çekilen Para Miktarı: " + miktar + paraBirimi);
        bakiyeSorgula();
    }

    public void bakiyeSorgula() {
        System.out.println("Hesabınızdaki Para Miktarı:" + bakiye);
    }
}