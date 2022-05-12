package AkilliCihaz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static AkilliCihaz.ArayüzTipleri.WEB_AG_ARAYUZU;

public class Giris {
    public void KullaniciGiris(Connection baglanti) throws SQLException {
        Scanner klavye = new Scanner(System.in);

        while(true){
            System.out.println("Kullanici adinizi giriniz: ");
            String kullaniciAdi = klavye.nextLine();

            String sql = "SELECT *  FROM \"User\" WHERE username='" + kullaniciAdi + "'";

            Statement stmt = baglanti.createStatement();
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (rs.next() == false){
                System.out.println("Girdiginiz sekilde kullanici adi kaydi bulunamadi. Tekrar deneyiniz...");
            }else{
                System.out.println("Şifre Giriniz:");
                String sifre = klavye.nextLine();
                String kullaniciSifre = rs.getString("password");
                if (sifre.equals(kullaniciSifre)){
                    System.out.println("Giriş başarılı.");
                    Kullanici kullanici = new Kullanici(kullaniciAdi, kullaniciSifre);
                    IAgArayuzu agArayuzu = Factory.getArayüz(WEB_AG_ARAYUZU, kullanici);
                    kullanici.KullaniciPaneli(agArayuzu, baglanti);
                    break;
                }
                System.out.println("Giriş işlemi başarısız. Lütfen tekrar deneyiniz...");
            }
        }


    }


}
