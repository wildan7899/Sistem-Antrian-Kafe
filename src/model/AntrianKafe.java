package model;

public abstract class AntrianKafe {
    protected int totalAntrian;

    public AntrianKafe() {
        this.totalAntrian = 0;
    }

    public abstract void tambahPelanggan(Customer c);
    public abstract void hapusPelanggan();
    public abstract void tampilkanAntrian();
    public abstract boolean isEmpty();

    public Customer getPelangganPertama() {
        return null;
    }

    public boolean cariPelanggan(String nama) {
        return false;
    }

    public void resetAntrian() {
        totalAntrian = 0;
    }

    public int getTotalAntrian() {
        return totalAntrian;
    }
}
