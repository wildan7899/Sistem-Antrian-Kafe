class Customer {
    private String nama;
    private String noHp;
    private String pesanan;
    private int nomorAntrian;

    public Customer(String nama, String noHp, String pesanan, int nomorAntrian) {
        this.nama = nama;
        this.noHp = noHp;
        this.pesanan = pesanan;
        this.nomorAntrian = nomorAntrian;
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

    public int getNomorAntrian() {
        return nomorAntrian;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setPesanan(String pesanan) {
        this.pesanan = pesanan;
    }

    public void setNomorAntrian(int nomorAntrian) {
        this.nomorAntrian = nomorAntrian;
    }

    public String toString() {
        return "Antrian #" + nomorAntrian + " | " + nama + " | " + pesanan;
    }
}
