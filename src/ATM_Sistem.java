import java.util.Scanner;

public class ATM_Sistem {
    private AnaHesap anaHesap;
    private ParaCekme paraCekme;
    private ParaYatirma paraYatirma;
    private DovizHesabi dovizHesabi;

    public ATM_Sistem(AnaHesap anaHesap, ParaCekme paraCekme, ParaYatirma paraYatirma, DovizHesabi dovizHesabi) {
        this.anaHesap = anaHesap;
        this.paraCekme = paraCekme;
        this.paraYatirma = paraYatirma;
        this.dovizHesabi = dovizHesabi;
    }

    public void islemSecenekleri() {
        System.out.println("1. Para Çekme");
        System.out.println("2. Para Yatırma");
        System.out.println("3. Döviz Hesabından Ana Hesaba Para Transferi");
        System.out.println("4. Mevcut Bakiye");
        System.out.println("5. Döviz Hesabı");
        System.out.println("6. Çıkış");
        System.out.print("Yapmak İstediğiniz İşlem Numarasını Giriniz : ");
    }

    public void yapilacakIslem(int secenek) {
        Scanner scanner = new Scanner(System.in);

        switch (secenek) {
            case 1:
                System.out.print("Çekmek istediğiniz para miktarını giriniz: ");
                double cekilenParaMiktari = scanner.nextDouble();
                String paraCekBirim = scanner.nextLine();
                paraCekme.cekilenParaMiktari(cekilenParaMiktari, paraCekBirim);
                break;
            case 2:
                System.out.print("Yatırmak istediğiniz para miktarını giriniz: ");
                double yatirilanParaMiktari = scanner.nextDouble();
                String paraYatirBirim = scanner.nextLine();
                paraYatirma.yatirilanParaMiktari(yatirilanParaMiktari, paraYatirBirim);
                break;
            case 3:
                dovizHesabi.anaHesabaTransfer(anaHesap);
                anaHesap.bakiyeSorgula();
                break;
            case 5:
                System.out.println("Döviz Hesabı");
                System.out.println("1. Para Yatırma");
                System.out.println("2. Para Çekme");
                System.out.print("Yapmak İstediğiniz İşlem Numarasını Giriniz : ");
                int dovizSecenekleri = scanner.nextInt();
                switch (dovizSecenekleri) {
                    case 1:
                        System.out.print("Yatıracağınız para miktarını giriniz: ");
                        double yatirilanDovizMiktari = scanner.nextDouble();
                        String paraYatirBirimDolar = scanner.nextLine();
                        dovizHesabi.paraYatir(yatirilanDovizMiktari);
                        dovizHesabi.paraYatir(yatirilanDovizMiktari, paraYatirBirimDolar);
                        break;
                    case 2:
                        System.out.print("Çekeceğiniz para miktarını giriniz: ");
                        double cekilenDovizMiktari = scanner.nextDouble();
                        String paraCekBirimDolar = scanner.nextLine();
                        dovizHesabi.paraCek(cekilenDovizMiktari);
                        dovizHesabi.paraCek(cekilenDovizMiktari, paraCekBirimDolar);
                        break;
                    default:
                        System.out.println("Hatalı Seçim. Tekrar deneyiniz.");
                }
                break;
            case 4:
                anaHesap.bakiyeSorgula();
                break;
            case 6:
                System.out.println("Bankamızı Tercih Ettiğiniz İçin Teşekkür ederiz. İyi Günler!");
                System.exit(0);
            default:
                System.out.println("Geçersiz İşlem Numarası!");
        }
    }
}