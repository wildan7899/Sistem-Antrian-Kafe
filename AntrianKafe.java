abstract class AntrianKafe {
    protected int totalAntrian;

    public AntrianKafe() {
        this.totalAntrian = 0;
    }

    public abstract void tambahPelanggan(Customer c);
    public abstract void hapusPelanggan();
    public abstract void tampilkanAntrian();
    public abstract boolean isEmpty();

    public int getTotalAntrian() {
        return totalAntrian;
    }
}
