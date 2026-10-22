package model;

public class Pelanggan {
    // Counter nomor antrian otomatis per kategori
    private static int counterReguler = 1;
    private static int counterVIP = 100;
    private static int counterTakeaway = 200;

    private String kodeAntrian;
    private String nama;
    private String noHp;
    private String pesanan;
    private String tipeAntrian;

    public Pelanggan(String nama, String noHp, String pesanan, String tipeAntrian) {
        this.nama = (nama == null || nama.trim().isEmpty()) ? "-" : nama;
        this.noHp = (noHp == null || noHp.trim().isEmpty()) ? "-" : noHp;
        this.pesanan = (pesanan == null || pesanan.trim().isEmpty()) ? "-" : pesanan;

        // Generate kode antrian sesuai jenisnya
        if (tipeAntrian != null && tipeAntrian.equalsIgnoreCase("VIP")) {
            this.tipeAntrian = "VIP";
            this.kodeAntrian = "VIP-" + (counterVIP++);
        } else if (tipeAntrian != null && tipeAntrian.equalsIgnoreCase("TAKEAWAY")) {
            this.tipeAntrian = "TAKEAWAY";
            this.kodeAntrian = "TAKEAWAY-" + (counterTakeaway++);
        } else {
            this.tipeAntrian = "REGULER";
            this.kodeAntrian = String.format("REGULER-%03d", counterReguler++);
        }
    }

    // Reset counter kalau mau ulang dari awal
    public static void resetPenghitung() {
        counterReguler = 1;
        counterVIP = 100;
        counterTakeaway = 200;
    }

    public String getKodeAntrian() { return kodeAntrian; }
    public String getNama() { return nama; }
    public String getNoHp() { return noHp; }
    public String getPesanan() { return pesanan; }
    public String getTipeAntrian() { return tipeAntrian; }

    @Override
    public String toString() {
        return "[" + kodeAntrian + "] " + nama + " | HP: " + noHp + " | Pesanan: " + pesanan;
    }
}
