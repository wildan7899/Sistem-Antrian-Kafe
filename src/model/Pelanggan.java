package model;

public class Pelanggan {
    private static int penghitungReguler = 1;
    private static int penghitungVIP = 100;
    private static int penghitungTakeaway = 200;

    private int nomorAntrian;
    private String nama;
    private String noHp;
    private String pesanan;
    private String tipeAntrian;

    public Pelanggan(String nama, String noHp, String pesanan, String tipeAntrian) {
        this.nama = nama;
        this.noHp = noHp;
        this.pesanan = pesanan;

        String tipeUpper = tipeAntrian.toUpperCase();
        if (tipeUpper.equals("REGULAR")) {
            this.tipeAntrian = "REGULER";
        } else {
            this.tipeAntrian = tipeUpper;
        }

        this.nomorAntrian = buatNomorAntrian(this.tipeAntrian);
    }

    private int buatNomorAntrian(String tipe) {
        int nomor;
        switch (tipe) {
            case "VIP":
                nomor = penghitungVIP;
                penghitungVIP++;
                break;
            case "TAKEAWAY":
                nomor = penghitungTakeaway;
                penghitungTakeaway++;
                break;
            default:
                nomor = penghitungReguler;
                penghitungReguler++;
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
        String nomorStr = "" + nomorAntrian;
        if (nomorAntrian < 10) {
            nomorStr = "00" + nomorAntrian;
        } else if (nomorAntrian < 100) {
            nomorStr = "0" + nomorAntrian;
        }
        return "[" + tipeAntrian + "-" + nomorStr + "] " + nama + " | HP: " + noHp + " | Pesanan: " + pesanan;
    }
}
