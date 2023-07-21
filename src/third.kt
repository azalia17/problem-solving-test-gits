// fungsi isBalancedBracket membutuhkan inputan sebuah string dan akan mengembalikan nilai bertipe string
fun isBalancedBracket(input: String): String {
    val stack = mutableListOf<Char>()

    // membuat sebuah read-only set berisi opening brackets
    val openingBrackets = setOf('(', '[', '{')

    // membuat read-only map berisi closing brackets dan pasangannya
    val closingBrackets = mapOf(')' to '(', ']' to '[', '}' to '{')

    // looping setiap character dari input
    for (char in input) {

        // jika character merupakan salah satu dari ke 3 opening bracket bernilai true
        if (openingBrackets.contains(char)) {

            // character akan dimasukkan ke dalam list
            stack.add(char)
        }

        // jika bernilai false, maka character akan dicek apakah dia merupakan salah satu dari key yang ada di closingBrackets map
        else if (closingBrackets.containsKey(char)) {

            // jika iya, dicek kembali apakah list masih kosong atau value terakhir yang ada di list tersebut tidak sama dengan character
            if (stack.isEmpty() || stack.removeAt(stack.size - 1) != closingBrackets[char]) {

                // console akan print NO
                return "NO"
            }
        }

        // jika bukan keduanya, karakter tidak valid
        else {
            return "Karakter tidak valid: \"${char}\""
        }
    }

    // jika list berakhir dengan empty list, maka return YES yang artinya braket seimbang antara buka dan tutup
    // jika tidak, maka return NO
    return if (stack.isEmpty()) "YES" else "NO"
}

fun main() {
    print("Input (tanpa spasi): ")
    val input = readLine() ?: return

    if (input.isNotEmpty())
        print("Output: ${isBalancedBracket(input)}")
}
