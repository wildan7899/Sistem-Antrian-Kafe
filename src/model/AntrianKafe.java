package model;

public abstract class AntrianKafe {
    protected int totalAntrian;

    public AntrianKafe() {
        this.totalAntrian = 0;
    }

    public abstract void tambahPelanggan(Pelanggan pelanggan);

    public abstract void hapusPelanggan();

    public abstract void tampilkanAntrian();

    public abstract boolean apakahKosong();

    public boolean isEmpty() {
        return apakahKosong();
    }

    public int getTotalAntrian() {
        return totalAntrian;
    }
}
