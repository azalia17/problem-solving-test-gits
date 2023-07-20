// fungsi denseRanking membutuhkan 2 parameter bertipe list of integer yakni scores dan gitsScores
// dan akan memberikan return list of integer
fun denseRanking(scores: List<Int>, gitsScores: List<Int>): List<Int> {
    val rankList = mutableListOf<Int>()

    // score para pemain akan menjadi list tanpa duplicate dan di sorting secara descending (besar ke kecil)
    val uniqueScores = scores.distinct().sortedDescending()

    // looping berdasarkan gitscores
    for (gitsScore in gitsScores) {
        var rank = 1

        // looping berdasarkan score yang ada di uniqueScores
        for (score in uniqueScores) {

            // jika gitScore lebih besar atau sama dengan score, loop akan berhenti
            if (gitsScore >= score) {
                break
            }

            // jika tidak, rank akan ditambah 1 dan looping tetap berjalan
            rank++
        }

        // ketika keluar dari loop, value rank akan dimasukkan ke dalam rankList
        rankList.add(rank)
    }

    // mengembalikan list bertipe integer
    return rankList
}

fun main() {
    print("Jumlah pemain: ")
    val totalPlayers = readLine()?.toIntOrNull() ?: return

    print("Daftar skor pemain: ")
    val scores = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return

    print("Jumlah permainan GITS: ")
    val gitsGames = readLine()?.toIntOrNull() ?: return

    print("Skor GITS setelah permainan: ")
    val gitsScores = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return

    if (gitsScores.size != gitsGames) {
        println("Jumlah permainan GITS dan jumlah skor tidak sesuai.")
        return
    }

    // memanggil fungsi denseRanking dan menyimpan return valuenya ke result
    val result = denseRanking(scores, gitsScores)
    println("Output: ${result.joinToString(" ")}")
}
