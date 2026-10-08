package model;

public abstract class AntrianKafe {
    protected int totalAntrian;

    public AntrianKafe() {
        this.totalAntrian = 0;
    }

    // TODO: Tim Inheritance - Gunakan method ini untuk memasukkan data ke Linked List
    public abstract void tambahPelanggan(Customer customer);

    // TODO: Tim Inheritance - Implementasikan logika penghapusan elemen pertama (FIFO)
    public abstract void hapusPelanggan();

    // TODO: Tim Inheritance - Implementasikan traversal Linked List untuk cetak data
    public abstract void tampilkanAntrian();

    public abstract boolean isEmpty();

    public int getTotalAntrian() {
        return totalAntrian;
    }
}
