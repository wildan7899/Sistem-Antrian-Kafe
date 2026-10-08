package model;

public class Customer {
    private static int counterRegular = 1;
    private static int counterVIP = 100;
    private static int counterTakeaway = 200;

    private int nomorAntrian;
    private String nama;
    private String noHp;
    private String pesanan;
    private String tipeAntrian;

    public Customer(String nama, String noHp, String pesanan, String tipeAntrian) {
        this.nama = nama;
        this.noHp = noHp;
        this.pesanan = pesanan;
        this.tipeAntrian = tipeAntrian.toUpperCase();
        this.nomorAntrian = generateNomorAntrian(this.tipeAntrian);
    }

    private int generateNomorAntrian(String tipe) {
        switch (tipe) {
            case "VIP": return counterVIP++;
            case "TAKEAWAY": return counterTakeaway++;
            default: return counterRegular++;
        }
    }

    public int getNomorAntrian() { return nomorAntrian; }
    public String getNama() { return nama; }
    public String getNoHp() { return noHp; }
    public String getPesanan() { return pesanan; }
    public String getTipeAntrian() { return tipeAntrian; }

    @Override
    public String toString() {
        return String.format("[%s-%03d] %-15s | HP: %-12s | Pesanan: %s", 
            tipeAntrian, nomorAntrian, nama, noHp, pesanan);
    }
}
