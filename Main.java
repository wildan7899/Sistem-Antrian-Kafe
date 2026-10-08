public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM ANTRIAN KAFE ===\n");

        // Test Antrian Regular (Single Linked List)
        System.out.println("--- ANTRIAN REGULAR (Single Linked List) ---");
        AntrianRegular regular = new AntrianRegular();
        regular.tambahPelanggan(new Customer("Budi", "081234567890", "Kopi Susu", 1));
        regular.tambahPelanggan(new Customer("Ani", "082345678901", "Teh Manis", 2));
        regular.tambahPelanggan(new Customer("Citra", "083456789012", "Nasi Goreng", 3));
        regular.tampilkanAntrian();
        System.out.println("Total: " + regular.getTotalAntrian() + "\n");

        System.out.println("Hapus 1 pelanggan:");
        regular.hapusPelanggan();
        regular.tampilkanAntrian();
        System.out.println("Total: " + regular.getTotalAntrian() + "\n");

        // Test Antrian VIP (Double Linked List)
        System.out.println("--- ANTRIAN VIP (Double Linked List) ---");
        AntrianVIP vip = new AntrianVIP();
        vip.tambahPelanggan(new Customer("Dewi", "084567890123", "Cappuccino", 101));
        vip.tambahPelanggan(new Customer("Eko", "085678901234", "Latte", 102));
        vip.tampilkanAntrian();
        System.out.println("Total: " + vip.getTotalAntrian() + "\n");

        // Test Antrian Takeaway (Circular Linked List)
        System.out.println("--- ANTRIAN TAKEAWAY (Circular Linked List) ---");
        AntrianTakeaway takeaway = new AntrianTakeaway();
        takeaway.tambahPelanggan(new Customer("Fajar", "086789012345", "Sandwich", 201));
        takeaway.tambahPelanggan(new Customer("Gita", "087890123456", "Croissant", 202));
        takeaway.tambahPelanggan(new Customer("Hendra", "088901234567", "Donut", 203));
        takeaway.tampilkanAntrian();
        System.out.println("Total: " + takeaway.getTotalAntrian() + "\n");

        System.out.println("Hapus 1 pelanggan:");
        takeaway.hapusPelanggan();
        takeaway.tampilkanAntrian();
        System.out.println("Total: " + takeaway.getTotalAntrian());
    }
}
