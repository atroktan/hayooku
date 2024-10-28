import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    private String nama;
    private int harga;

    public MenuItem(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}

class Pesanan {
    private ArrayList<ItemPesanan> items = new ArrayList<>();
    private int totalHarga = 0;

    public void tambahItem(MenuItem item, int jumlah) {
        int subtotal = item.getHarga() * jumlah;
        items.add(new ItemPesanan(item, jumlah, subtotal));
        totalHarga += subtotal;
    }

    public void cetakNota() {
        System.out.println("\n========== Nota Pemesanan ==========");
        for (ItemPesanan itemPesanan : items) {
            System.out.printf("%s x %d = Rp%,d%n",
                    itemPesanan.getItem().getNama(),
                    itemPesanan.getJumlah(),
                    itemPesanan.getSubtotal());
        }
        System.out.printf("\nTotal Harga: Rp%,d%n", totalHarga);
        System.out.println("====================================");
    }
}

class ItemPesanan {
    private MenuItem item;
    private int jumlah;
    private int subtotal;

    public ItemPesanan(MenuItem item, int jumlah, int subtotal) {
        this.item = item;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getSubtotal() {
        return subtotal;
    }
}

class NotaPemesanan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar menu
        MenuItem nasiGoreng = new MenuItem("Nasi Goreng", 20000);
        MenuItem mieGoreng = new MenuItem("Mie Goreng", 15000);
        MenuItem esTeh = new MenuItem("Es Teh", 5000);

        Pesanan pesanan = new Pesanan();

        System.out.println("====== Menu Restoran ======");
        System.out.println("1. Nasi Goreng - Rp20,000");
        System.out.println("2. Mie Goreng  - Rp15,000");
        System.out.println("3. Es Teh      - Rp5,000");

        while (true) {
            System.out.print("\nMasukkan nomor menu (atau 'q' untuk selesai): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Masukkan jumlah: ");
            int jumlah = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case "1":
                    pesanan.tambahItem(nasiGoreng, jumlah);
                    break;
                case "2":
                    pesanan.tambahItem(mieGoreng, jumlah);
                    break;
                case "3":
                    pesanan.tambahItem(esTeh, jumlah);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }

        pesanan.cetakNota();
        scanner.close();
    }
}
