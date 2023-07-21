//fungsi sloanesOeis membutuhkan 1 inputan bertipe integer dan akan mengembalikan nilai bertipe string
fun sloanesOeis(n: Int): String {
    val output = mutableListOf<String>()

    // looping berdasarkan dari inputan user
    // dimulai dari 0 agar output yang dihasilkan sesuai (mulai dari 1 bukan 2)
    for (i in 0..n) {
        // melakukan perhitungan
        val value = i * (i + 1) / 2 + 1

        // store hasil dari perhitungan tadi ke dalam list output.
        // diubah menjadi string dengan tujuan memudahkan saat print agar dapat diconcatenate dengan '-'
        output.add(value.toString())
    }

    // concatenate value dari list output dengan '-' menjadi satu string
    return output.joinToString("-")
}

fun main() {
    // user input
    print("Input (int) : ")
    val input = readLine()?.toIntOrNull()

    // memvalidasi apakah input tidak bernilai null (kosong) dan tidak negatif
    if (input != null && input > 0) {

        // memanggil fungsi sloanesOeis dengan input dikurang 1 karena loop dimulai dari 0 dan menyimpan return valuenya di variabel output
        val output = sloanesOeis(input - 1)
        println("Output: $output")
    } else {
        println("Masukkan angka positif yang valid.")
    }
}
