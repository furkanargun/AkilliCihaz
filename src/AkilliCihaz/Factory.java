package AkilliCihaz;

public class Factory {
  public static IAgArayuzu getArayüz(ArayüzTipleri tip, Kullanici kullanici) {
    switch (tip) {
      case WEB_AG_ARAYUZU:
        return new AgArayuzu(kullanici);

      default:
        return null;
    }
  }
}