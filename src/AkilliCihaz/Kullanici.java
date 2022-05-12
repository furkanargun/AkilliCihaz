package AkilliCihaz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Kullanici implements IObserver {

  private String kullaniciAdi;
  private String parola;

  public Kullanici(String kullaniciAdi, String parola) {
    this.kullaniciAdi = kullaniciAdi;
    this.parola = parola;
  }

  public void KullaniciPaneli(IAgArayuzu agArayuzu, Connection baglanti) throws SQLException {
    while (true) {
      System.out.println("** Yapacaginiz İşlemi Seçiniz...(1/2/3/4) **");
      System.out.println("1-Sicakligi Göster");
      System.out.println("2-Sogutucuyu Ac");
      System.out.println("3-Sogutucuyu Kapat");
      System.out.println("4-Çikis Yap");
      Scanner klavye = new Scanner(System.in);

      int menu = klavye.nextInt();
      switch (menu) {
        case 1:
          System.out.println("Ortamin Sicakligi: " + agArayuzu.sicaklikGonder());
          break;
        case 2:
          agArayuzu.sogutucuyuAc();
          break;
        case 3:
          agArayuzu.sogutucuyuKapat();
          break;
      }
      if (menu == 4) {
        baglanti.close();
        break;
      }
    }
  }

  @Override
  public void durumGüncelle(boolean state) {
    System.out.println("Sogutucu " + (state ? "'ACIK' duruma gecti" : "'KAPALI' konumuna gecti"));
  }
}
