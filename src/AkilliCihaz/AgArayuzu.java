package AkilliCihaz;

public class AgArayuzu implements IAgArayuzu, IArayüz {

  private AkilliCihaz akilliCihaz;

  public AgArayuzu(Kullanici kullanici) {
    akilliCihaz = AkilliCihaz.getInstance(kullanici);
  }

  @Override
  public void sogutucuyuAc() {
    akilliCihaz.sogutucuyuAc();
  }

  @Override
  public void sogutucuyuKapat() {
    akilliCihaz.sogutucuyuKapat();
  }

  @Override
  public int sicaklikGonder() {
    return akilliCihaz.sicaklikGonder();
  }

  @Override
  public void ArayuzTipi() {
    System.out.println("Web Arayüzüne Hoşgeldiniz.");
  }
}
