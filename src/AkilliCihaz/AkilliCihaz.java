package AkilliCihaz;


public class AkilliCihaz {
    private static AkilliCihaz cihaz;
    private static Eyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;

    public AkilliCihaz() {
        eyleyici = new Eyleyici();
        sicaklikAlgilayici = new SicaklikAlgilayici();
    }

    public static AkilliCihaz getInstance(IObserver observer) {
        if(cihaz == null) {
            cihaz = new AkilliCihaz();
            eyleyici.gozlemciEkle(observer);
            return cihaz;
        }
        return cihaz;
    }
    public int sicaklikGonder(){
        return sicaklikAlgilayici.sicaklikOku();
    }

    public void sogutucuyuAc(){
        this.eyleyici.sogutucuAc();
    }

    public void sogutucuyuKapat(){
        this.eyleyici.sogutucuKapat();
    }
}
