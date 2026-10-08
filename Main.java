public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM ANTRIAN KAFE (Optimized) ===\n");

        AntrianKafe regular = new SingleLinkedList();
        AntrianKafe vip = new DoubleLinkedList();
        AntrianKafe takeaway = new CircularLinkedList();

        // Tes Auto Numbering & Centralized Node
        System.out.println("--- REGULAR ---");
        regular.tambahPelanggan(new Customer("Budi", "0812", "Kopi", "REGULAR"));
        regular.tambahPelanggan(new Customer("Ani", "0823", "Teh", "REGULAR"));
        regular.tampilkanAntrian();

        System.out.println("\n--- VIP ---");
        vip.tambahPelanggan(new Customer("Dewi", "0845", "Latte", "VIP"));
        vip.tampilkanAntrian();

        System.out.println("\n--- TAKEAWAY ---");
        takeaway.tambahPelanggan(new Customer("Fajar", "0867", "Sandwich", "TAKEAWAY"));
        takeaway.tampilkanAntrian();
    }
}
