package AkilliCihaz;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {

    private int sicaklik;

    @Override
    public int sicaklikOku() {
        Random random = new Random();
        this.sicaklik = random.nextInt(50);
        return this.sicaklik;
    }
}
