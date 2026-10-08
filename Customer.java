public class Customer {
    private static int counterRegular = 1;
    private static int counterVIP = 100;
    private static int counterTakeaway = 200;

    private int nomorAntrian;
    private String nama;
    private String noHp;
    private String pesanan;
    private String tipeAntrian; // "REGULAR", "VIP", "TAKEAWAY"

    public Customer(String nama, String noHp, String pesanan, String tipeAntrian) {
        this.nama = nama;
        this.noHp = noHp;
        this.pesanan = pesanan;
        this.tipeAntrian = tipeAntrian.toUpperCase();
        
        switch (this.tipeAntrian) {
            case "VIP":
                this.nomorAntrian = counterVIP++;
                break;
            case "TAKEAWAY":
                this.nomorAntrian = counterTakeaway++;
                break;
            default:
                this.nomorAntrian = counterRegular++;
                break;
        }
    }

    public int getNomorAntrian() { return nomorAntrian; }
    public String getNama() { return nama; }
    public String getNoHp() { return noHp; }
    public String getPesanan() { return pesanan; }
    public String getTipeAntrian() { return tipeAntrian; }

    public void setNama(String nama) { this.nama = nama; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    public void setPesanan(String pesanan) { this.pesanan = pesanan; }

    @Override
    public String toString() {
        return String.format("[%s-%03d] %-15s | HP: %-12s | Pesanan: %s", 
            tipeAntrian, nomorAntrian, nama, noHp, pesanan);
    }
}
