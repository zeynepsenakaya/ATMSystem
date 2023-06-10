import java.util.Scanner;

public class DovizHesabi implements IParaYatir, IParaCek {
    private double döviz_bakiye;

    public DovizHesabi() {
        this.döviz_bakiye = 0.0;
    }

    public void paraYatir(double miktar) {
        döviz_bakiye += miktar;
    }

    public void paraYatir(double miktar, String paraBirimi) {
        paraBirimi = "$";
        System.out.println("Yatırılan Para Miktarı:" + miktar + paraBirimi);
        System.out.println("Döviz Hesabındaki Güncel Bakiyeniz: " + döviz_bakiye);
    }

    public void paraCek(double miktar) {
        if (döviz_bakiye >= miktar) {
            döviz_bakiye -= miktar;
        } else {
            System.out.println("Yetersiz Bakiye");
            System.out.println("Döviz Hesabındaki Güncel Bakiyeniz: " + döviz_bakiye);
        }
    }

    public void paraCek(double miktar, String paraBirimi) {
        paraBirimi = "$";
        System.out.println("Çekilen Para Miktarı: " + miktar + paraBirimi);
        System.out.println("Döviz Hesabındaki Güncel Bakiyeniz: " + döviz_bakiye);
    }

    public void anaHesabaTransfer(AnaHesap anaHesap) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Döviz Hesabınızdan Ana Hesabınıza Aktarmak İstediğiniz Para Miktarını Giriniz: ");
        double transferMiktari = scanner.nextDouble();
        double tutar = transferMiktari*21;

        if (döviz_bakiye >= transferMiktari) {
            döviz_bakiye -= transferMiktari;
            anaHesap.paraYatir(tutar);
        } else {
            System.out.println("Yetersiz Bakiye");
            System.out.println("Döviz Hesabındaki Güncel Bakiyeniz: " + döviz_bakiye);
        }
    }

    public void bakiyeSorgula() {
        System.out.println("Döviz Hesabındaki Güncel Bakiyeniz: " + döviz_bakiye);
    }
}