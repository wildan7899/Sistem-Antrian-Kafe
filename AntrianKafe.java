public abstract class AntrianKafe {
    protected int totalAntrian;

    public AntrianKafe() {
        this.totalAntrian = 0;
    }

    public abstract void tambahPelanggan(Customer c);
    public abstract void hapusPelanggan();
    public abstract void tampilkanAntrian();
    public abstract boolean isEmpty();

    // Method baru untuk efisiensi manajemen
    public Customer getPelangganPertama() {
        System.out.println("Implementasi getPelangganPertama bergantung pada subclass.");
        return null;
    }

    public boolean cariPelanggan(String nama) {
        System.out.println("Implementasi pencarian bergantung pada subclass.");
        return false;
    }

    public void resetAntrian() {
        totalAntrian = 0;
    }

    public int getTotalAntrian() {
        return totalAntrian;
    }
}
