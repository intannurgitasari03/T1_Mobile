// Nama: Intan Nurgitasari
// NIM: F1D02310060
// PEMBER B

// class untuk menyimpan data mahasiswa
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

// fungsi untuk menentukan grade dari nilai
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
}

fun main() {

    // daftar mahasiswa beserta nilai mereka
    val daftarMahasiswa = listOf(
        NilaiMahasiswa("F1D02310060","Intan Nurgitasari","Pemrograman",100),
        NilaiMahasiswa("F1D02310005","Bagus Esa Wijaya Kusuma","Pemrograman",55),
        NilaiMahasiswa("F1D02310009","Hilya Fitri","Pemrograman",86),
        NilaiMahasiswa("F1D02310019","Nabila Zahirani","Pemrograman",85),
        NilaiMahasiswa("F1D02310023","Robi'atul Izzati","Pemrograman",75),
        NilaiMahasiswa("F1D02310027","Valerine Jesika Dewi","Pemrograman",81),
        NilaiMahasiswa("F1D02310030","Aditia Rahmat Mualana","Pemrograman",60),
        NilaiMahasiswa("F1D02310040","Ayu Diana","Pemrograman",90),
        NilaiMahasiswa("F1D02310043","Baiq Kustina Amriana","Pemrograman",92),
        NilaiMahasiswa("F1D02310046","Didy Ariyanto","Pemrograman",70)
    )

    println("===== DATA NILAI MAHASISWA =====")
    println()

    // menampilkan header tabel
    println(String.format("%-3s %-15s %-30s %-17s %-12s",
        "No","NIM","Nama","MataKuliah","Nilai"))

    var no = 1

    // menampilkan semua data mahasiswa
    for (m in daftarMahasiswa) {
        println(String.format("%-3s %-15s %-30s %-17s %-12s",
            no, m.nim, m.nama, m.mataKuliah, m.nilai
        ))
        no++
    }

    // menghitung rata-rata nilai
    val rataRata = daftarMahasiswa.map { it.nilai }.average()

    // mencari nilai tertinggi dan terendah
    val tertinggi = daftarMahasiswa.maxByOrNull { it.nilai }
    val terendah = daftarMahasiswa.minByOrNull { it.nilai }

    println()

    println("===== STATISTIK =====")
    println("Total Mahasiswa : ${daftarMahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")

    // memisahkan mahasiswa yang lulus dan tidak
    val lulus = daftarMahasiswa.filter { it.nilai >= 70 }
    val tidakLulus = daftarMahasiswa.filter { it.nilai < 70 }

    println()

    println("===== MAHASISWA LULUS =====")
    var noLulus = 1
    for (m in lulus) {
        println("$noLulus. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
        noLulus++
    }

    println()

    println("===== MAHASISWA TIDAK LULUS =====")
    var noTidak = 1
    for (m in tidakLulus) {
        println("$noTidak. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
        noTidak++
    }

    // mengurutkan nilai dari kecil ke besar
    val asc = daftarMahasiswa.sortedBy { it.nilai }

    println()
    println("===== URUTAN NILAI SECARA ASCENDING =====")
    for (m in asc) {
        println("${m.nama} - ${m.nilai}")
    }

    // mengurutkan nilai dari besar ke kecil
    val desc = daftarMahasiswa.sortedByDescending { it.nilai }

    println()
    println("===== URUTAN NILAI SECARA DESCENDING =====")
    for (m in desc) {
        println("${m.nama} - ${m.nilai}")
    }

    // mengelompokkan jumlah mahasiswa berdasarkan grade
    val groupGrade = daftarMahasiswa.groupBy { getGrade(it.nilai) }

    println()
    println("===== JUMLAH PER GRADE =====")
    for ((grade, list) in groupGrade) {
        println("Grade $grade: ${list.size} mahasiswa")
    }

    println()

    // mencari mahasiswa berdasarkan nama
    print("Cari Nama Mahasiswa: ")
    val namaMahasiswa = readLine()!!.lowercase()

    val hasil = daftarMahasiswa.filter {
        it.nama.lowercase().contains(namaMahasiswa)
    }

    println()
    println("===== HASIL PENCARIAN =====")

    for (m in hasil) {
        println("${m.nama} - ${m.nilai}")
    }
}