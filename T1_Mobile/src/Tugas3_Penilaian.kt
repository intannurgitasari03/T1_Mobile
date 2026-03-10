// Nama: Intan Nurgitasari
// NIM : F1D02310060
// PEMBER B

fun main() {

    println("===== SISTEM PENILAIAN =====")

    // meminta pengguna memasukkan nama mahasiswa
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()

    // input nilai UTS
    print("Masukkan Nilai UTS (0-100): ")
    val uts = readLine()!!.toInt()

    // input nilai UAS
    print("Masukkan Nilai UAS (0-100): ")
    val uas = readLine()!!.toInt()

    // input nilai tugas
    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = readLine()!!.toInt()

    println()

    // menampilkan data nilai yang telah diinput
    println("===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("--------------------------------")

    // menghitung nilai akhir berdasarkan bobot
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    // menentukan grade berdasarkan nilai akhir
    val grade = when (nilaiAkhir){
        in 85.0..100.0 -> "A"
        in 70.0..84.0 -> "B"
        in 60.0..69.0 -> "C"
        in 50.0..59.0 -> "D"
        else -> "F"
    }

    // menentukan keterangan dari grade
    val keterangan = if (grade == "A"){
        "Sangat Baik"
    } else if (grade == "B"){
        "Baik"
    }else if (grade == "C"){
        "Cukup"
    }else if (grade == "D"){
        "Kurang"
    }else {
        "Sangat Kurang"
    }

    // menentukan status kelulusan mahasiswa
    val status = if (nilaiAkhir >= 60.0){
        "Lulus"
    }else {
        "Tidak Lulus"
    }

    // menampilkan hasil akhir penilaian
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")
}