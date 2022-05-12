package AkilliCihaz;

import java.util.ArrayList;
import java.util.List;

public class Eyleyici implements IEyleyici, IObservable {
    private boolean sogutucuDurum;
    private List<IObserver> gözlemciListesi = new ArrayList<IObserver>();

    public Eyleyici() {
        sogutucuDurum = false;
    }

    @Override
    public void sogutucuAc() {
        if(!sogutucuDurum) {
            this.sogutucuDurum = true;
            gozlemcilereBildir();
        } else {
            System.out.println("Sogutucunun durumu zaten acik konumda!");
        }
    }

    @Override
    public void sogutucuKapat() {
        if(sogutucuDurum) {
            this.sogutucuDurum = false;
            gozlemcilereBildir();
        } else {
            System.out.println("Sogutucunun durumu zaten kapali konumda!");
        }
    }

    public void gozlemciEkle(IObserver iObserver) {
        this.gözlemciListesi.add(iObserver);
    }

    @Override
    public void gozlemcilereBildir() {
        for (IObserver gozlemci: gözlemciListesi) {
            gozlemci.durumGüncelle(sogutucuDurum);
        }
    }
}
