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
        int nomor;
        switch (tipe) {
            case "VIP":
                nomor = counterVIP;
                counterVIP++;
                break;
            case "TAKEAWAY":
                nomor = counterTakeaway;
                counterTakeaway++;
                break;
            default:
                nomor = counterRegular;
                counterRegular++;
                break;
        }
        return nomor;
    }

    public int getNomorAntrian() {
        return nomorAntrian;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getPesanan() {
        return pesanan;
    }

    public String getTipeAntrian() {
        return tipeAntrian;
    }

    @Override
    public String toString() {
        return "[" + tipeAntrian + "-" + nomorAntrian + "] " + nama + " | HP: " + noHp + " | Pesanan: " + pesanan;
    }
}
