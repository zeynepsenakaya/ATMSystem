import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bankada Kayıtlı İsim-Soyisiminizi giriniz: ");
        String isim = scanner.nextLine();

        System.out.print("Hesap Numaranızı Giriniz: ");
        int hesapNo = scanner.nextInt();

        AnaHesap anaHesap = new AnaHesap(isim, hesapNo);
        ParaCekme paraCekme = new ParaCekme(anaHesap);
        ParaYatirma paraYatırma = new ParaYatirma(anaHesap);
        DovizHesabi dovizHesabi = new DovizHesabi();
        ATM_Sistem ATMSistem = new ATM_Sistem(anaHesap, paraCekme, paraYatırma, dovizHesabi);

        while (true){
            ATMSistem.islemSecenekleri();

            int secenek = scanner.nextInt();
            ATMSistem.yapilacakIslem(secenek);
        }
    }
}