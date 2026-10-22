package model;

// Class abstract untuk struktur antrian kafe (menerapkan ADT)
public abstract class AntrianKafe {
    protected int totalAntrian = 0;

    // Method wajib yang nanti dioverride di masing-masing linked list
    public abstract void tambahPelanggan(Pelanggan pelanggan);
    public abstract void hapusPelanggan();
    public abstract void tampilkanAntrian();
    public abstract boolean apakahKosong();

    public int getTotalAntrian() {
        return totalAntrian;
    }
}
