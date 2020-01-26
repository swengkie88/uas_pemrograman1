import java.util.Scanner;
class Hotel{
    // Deklarasi Variable
    String kelas[] = {"Deluxe", "Suite Room", "President Room"};
    int hargaKelas[] = {275000, 300000, 370000};

    String nama, alamat, pilihMember;
    int tarif, totalBayar, diskon, lama, pilihKelas, kelasnya;

    // Method yang berfungsi untuk melakukan clear screen konsol atau terminal user 
    // supaya program lebih terlihat rapi
    public void clearScreen(){
        final String os = System.getProperty("os.name");
        try{
            if(os.contains("Linux")){
                // ANSI Escapes code untuk clear screen pada OS yang mendukung ANSI Escapes Code
                // 'H' berguna untuk berpindah ke layar bagian atas
                // '2J' berguna untuk menghapus keseluruhan isi layar 
                System.out.print("\033[H\033[2J");
            }else{
                Runtime.getRuntime().exec("cls");
            }
        }
        catch(final Exception e)
        {
            System.out.println("System errors");
        }
    }

    // Method yang berfungsi untuk mendapatkan nilai akhir dari variable nama
    public String getName(){
        return nama;
    }

    // Method yang berfungsi untuk mengatur nilai variable nama
    public void setName(String nama){
        this.nama = nama;
    }

    // Method yang berfungsi untuk mendapatkan nilai akhir dari variable alamat
    public String getAlamat(){
        return alamat;
    }

    // Method yang berfungsi untuk mengatur nilai variable alamat
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    // Method yang berfungsi untuk mengatur kelas kamar yang akan ditinggali oleh pengunjung
    // terdapat " - 1" dikarenakan display nomor urut kelas yang dilihat pengunjung adalah 1-3
    // bukan 0-2, jadi ketika user menginputkan angka 1, maka akan memanggil array index ke - 0
    public void setKelas(int pilihKelas){
        this.pilihKelas = pilihKelas - 1; 
    }

    // Method yang berfungsi untuk mendapatkan nilai akhir dari variable lama
    // dimana variable lama berisikan berapa hari pengunjung akan menginap
    public int getLamaInap(){
        return lama;
    }

    // Method yang berfungsi untuk mengatur nilai variable lama
    public void setLamaInap(int lama){
        this.lama = lama;
    }
   
    // Method yang berfungsi untuk mendapatkan nilai akhir dari variable pilihMember
    // dimana variable tersebut berisikan status keanggotaan dari pengunjung
    public String getMember(){
        return pilihMember;
    }
    
    // Method yang berfungsi untuk mengatur status keanggotaan pengunjung
    public void setMember(String pilihMember){
        this.pilihMember = pilihMember;
    }
    
    // Method yang berfungsi menghitung berapa banyak tarif yang harus dibayar
    // berdasarkan berapa lama pengunjung menginap dikali tarif/hari
    public int hitungTarif(){
        return tarif = hargaKelas[pilihKelas] * getLamaInap();
    }

    // Method yang berfungsi menghitung berapa banyak diskon yang didapat
    public int hitungDiskon(){
        // Percabangan yang akan mengatur jumlah diskon jika didapati
        // statusnya adalah member
        if(getMember().equals("y") || getMember().equals("Y")){
            // Jika lama menginapnya 3-7 hari maka mendapatkan diskon 20%
            if((getLamaInap() >= 3) && (getLamaInap() <= 7)){
                diskon = hitungTarif() * 20/100;
            }
            // Jika lama menginapnya lebih dari 7 hari maka mendapatkan diskon 35%
            else if(lama > 7){
                diskon = hitungTarif() * 35/100;
            }
            // Jika kurang dari 3 hari maka tidak mendapatkan diskon
            else{
                diskon = 0;
            }   
        }
        // Percabangan yang akan mengatur jumlah diskon jika didapati
        // statusnya bukan member
        else if(getMember().equals("t") || getMember().equals("T")){
            // Jika lama menginapnya 3-7 hari maka mendapatkan diskon 10%
            if((getLamaInap() >= 3) && (getLamaInap() <= 7)){
                diskon = hitungTarif() * 10/100;
            }
            // Jika lama menginapnya lebih dari 7 hari maka mendapatkan diskon 15%
            else if(getLamaInap() > 7){
                diskon = hitungTarif() * 15/100;
            }
            // Jika kurang dari 3 hari maka tidak mendapatkan diskon
            else{
                diskon = 0;
            }
        }
        // Kita kembalikan "return" nilai akhir dari diskon
        return diskon;
    }

    // Method yang berfungsi menghitung jumlah total pembayaran
    public int hitungTotal(){
        // Mengembalikan nilai totalBayar 
        // dimana didapat dari (tarif*lamainap) - diskon
        return totalBayar = hitungTarif() - hitungDiskon(); 
    }

}

// Main class nya
public class ReservasiHotel{
    // Main method yang bertugas menjalankan fungsi utama program
    public static void main(String[] args){
        // Menginstansiasi class Hotel kedalam objek "hotel" supaya dapat memanggil variable2 dan method2 
        // yang terdapat didalamnya
        Hotel hotel = new Hotel();
        // Menginstansiasi class Scanner kedalam objek "scan" supaya dapat
        // menerima inputan dari pengunjung
        Scanner scan = new Scanner(System.in);

        // Variable tambahan yang mendukung proses error handling
        String konfirmasi, loop;
        konfirmasi = "";
        boolean x, y;
        x = true;
        y = true;

        // Fungsi do while untuk melakukan looping pada program secara keseluruhan
        do{
            // Memanggil method clear screen dari class Hotel untuk menghapus isi dari program
            // yang sudah ditampilkan di konsol/terminal 
            hotel.clearScreen();
            System.out.println("================= HOTEL UNY =================");
            System.out.println("Komplek Kampus Universitas Negeri Yogyakarta");
            System.out.println("\tJl. Colombo Karangmalang 55281");
            System.out.println("======Isi Data Diri Anda======");
            // Input nama dari pengunjung dihandle oleh method setName dari class Hotel
            System.out.print("Nama \t: ");
            hotel.setName(scan.next());
            // Input nama dari pengunjung dihandle oleh method setAlamat dari class Hotel
            System.out.print("Alamat \t: ");
            hotel.setAlamat(scan.next());

            // Memanggil method clear screen dari class Hotel untuk menghapus isi dari program
            // yang sudah ditampilkan di konsol/terminal 
            hotel.clearScreen();

            // Section isi data reservasi
            System.out.println("======Isi Data Reservasi======");
            System.out.println("Pilihan kelas kamar");
            // Looping untuk menampilkan pilihan kelas kamar
            for(int i = 0; i <=2; i++){
                // Variable num untuk memanipulasi index array yang aslinya 0,1,2 akan ditampilkan kepada user menjadi 1,2,3
                int num = i + 1;
                System.out.println(num + ".Kelas " + hotel.kelas[i] + " Rp." +hotel.hargaKelas[i] + "/hari");
            }
            // Looping yang bertugas melakukan error handling
            // yang akan mengulangi inputan pilihan kelas bimana
            // pengunjung memasukan angka selain 1,2,3
            do{
                System.out.print("\nMasukkan pilihan kelas(1/2/3)...");
                hotel.setKelas(scan.nextInt());
                // akan tetapi yang menjadi parameter disini bukanlah angka 1 dan 3
                // melainkan angka 0 dan 2 sebagai batas bawah dan batas atas
                // dikarenakan adanya pengurangan dari inputan yang diberikan pengunjung
                // jadi ketika ada inputan 3 maka sistem akan membacanya 2
                if((hotel.pilihKelas < 0) || (hotel.pilihKelas > 2)){
                    // akan menampilkan pesan kesalahan jika inputan yang diberikan bukan 1-3
                    System.out.println("Kelas yang anda pilih tidak terdaftar");
                    // dan akan mengubah nilai variable y menjadi "false"
                    y = false;
                }else if((hotel.pilihKelas >= 0) && (hotel.pilihKelas <= 2)){
                    // mengubah nilai variable y menjadi "true"
                    y = true;
                }
                // Syarat yang dipakai adalah x != y
                // jadi ketika y bernilai false maka inputan pilihan kelas akan diulangi
                // karena nilai x adalah "true"
                // dan bila y juga true maka program akan meneruskan ke inputan selanjutnya
            }while(x != y);

            System.out.print("Masukan lama menginap(hari)...");
            hotel.setLamaInap(scan.nextInt());

            // Looping yang bertugas melakukan error handling
            // Jadi ketika inputan selain "y/Y" dan "t/T" maka akan ada perulangan dari
            // statement apakah anda member atau tidak?
            do{
                System.out.print("Apakah anda member atau tidak(y/t)?...");
                hotel.setMember(scan.next());
                if(hotel.getMember().equals("y") || hotel.getMember().equals("Y")){
                    y = true;
                }else if(hotel.getMember().equals("t") || hotel.getMember().equals("T")){
                    y = true;
                }else{
                    System.out.println("\nPerintah tidak dikenali, silakan diulangi");
                    y = false;
                }
            }while(x != y);
            System.out.println(" ");

            // Memanggil method clear screen dari class Hotel untuk menghapus isi dari program
            // yang sudah ditampilkan di konsol/terminal 
            hotel.clearScreen();

            // Data Reservasi Pengunjung
            // berisikan nilai atau data yang diterima dari inputan user
            // yang telah diolah oleh program
            System.out.println("======Data Reservasi Anda======");
            System.out.println("Nama \t\t: " + hotel.getName());
            System.out.println("Alamat \t\t: " + hotel.getAlamat());
            System.out.println("Jenis Kamar \t: " + hotel.kelas[hotel.pilihKelas]);
            System.out.println("Lama Menginap \t: " + hotel.getLamaInap() + " Hari");
            
            if(hotel.getMember().equals("y") || hotel.getMember().equals("Y")){
                System.out.println("Status \t\t: " + "Member");
            }else if(hotel.getMember().equals("t") || hotel.getMember().equals("T")){
                System.out.println("Status \t\t: " + "Non Member");
            }

            System.out.println("Tarif/hari \t: Rp." + hotel.hargaKelas[hotel.pilihKelas] + "/Hari");
            System.out.println("Tarif \t\t: Rp." + hotel.hitungTarif());
            System.out.println("Diskon \t\t: Rp." + hotel.hitungDiskon());
            System.out.println("Total Bayar \t: Rp." + hotel.hitungTotal());            
            System.out.println("===============================");
            
            // Looping yang bertugas melakukan error handling
            // Jadi ketika inputan selain "y/Y" dan "t/T" maka akan ada perulangan dari
            // statement apakah anda ingin melanjutkan reservasi?
            do{
                System.out.print("Apakah ingin melanjutkan reservasi? (y/t)...");
                konfirmasi = scan.next();
                if(konfirmasi.equals("y") || konfirmasi.equals("Y")){
                    System.out.println("Reservasi berhasil dilakukan");
                    System.out.println("Silakan lakukan pembayaran");
                    y = true;
                }else if(konfirmasi.equals("t") || konfirmasi.equals("T")){
                    System.out.println("Reservasi dibatalkan");
                    y = true;
                }else{
                    System.out.println("\nPerintah tidak dikenali, silakan diulangi");
                    y = false;
                }
            }while(x != y);

            System.out.println("===============================");
            
            // Looping yang bertugas melakukan error handling
            // Jadi ketika inputan selain "y/Y" dan "t/T" maka akan ada perulangan dari
            // statement apakah anda ingin keluar?
            do{
                System.out.print("Apakah anda ingin keluar? (y/t)...");            
                loop = scan.next();
    
                if(loop.equals("y") || loop.equals("Y")){
                    // Ketika user menginputkan "y/Y" maka nilai variable y = true
                    y = true;
                }else if(loop.equals("t") || loop.equals("T")){
                    // Ketika user menginputkan "t/T" maka nilai variable y = true
                    y = true;
                }else{
                    System.out.println("\nPerintah tidak dikenali, silakan diulangi");
                    // Ketika user menginputkan "y/Y" dan "t/T" maka nilai variable y = false
                    y = false;
                }
            }while(x != y); 

            // Percabangan yang untuk mengatur nilai variable y
            // yang berguna untuk menentukan kondisi perulangan program secara keseluruhan
            if(loop.equals("y") || loop.equals("Y")){
                // Ketika user menginputkan "y/Y" maka nilai variable y = false
                y = false;
                System.out.println("===============================");
                System.out.println("Terimakasih Telah Berkunjung :) ");
            }else if(loop.equals("t") || loop.equals("T")){
                // Ketika user menginputkan "t/T" maka nilai variable y = true
                y = true;
            }

        // Jadi program akan diulangi secara keseluruhan saat user menginputkan t/T
        // karena variable x dan y akan bernilai sama, true = true
        // dan program tidak akan diulangi saat user menginputkan y/Y
        // karena nilai variable x dan y akan menjadi tidak sama, true != false
        }while(x == y);
        
    }
}