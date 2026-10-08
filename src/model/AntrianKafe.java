package model;

/**
 * ADT (Abstract Data Type) untuk Antrian Kafe
 * Mendefinisikan operasi dasar yang harus diimplementasikan oleh semua jenis antrian
 */
public abstract class AntrianKafe {
    protected int totalAntrian;

    public AntrianKafe() {
        this.totalAntrian = 0;
    }

    /**
     * Menambahkan pelanggan ke antrian
     * @param c Customer yang akan ditambahkan
     */
    public abstract void tambahPelanggan(Customer c);

    /**
     * Menghapus/memproses pelanggan pertama dari antrian (FIFO)
     */
    public abstract void hapusPelanggan();

    /**
     * Menampilkan semua pelanggan dalam antrian
     */
    public abstract void tampilkanAntrian();

    /**
     * Mengecek apakah antrian kosong
     * @return true jika antrian kosong, false jika tidak
     */
    public abstract boolean isEmpty();

    /**
     * Mendapatkan jumlah total pelanggan dalam antrian
     * @return jumlah pelanggan
     */
    public int getTotalAntrian() {
        return totalAntrian;
    }
}
