import kotlin.random.Random

fun main() {
    println(
            "  __  __ _____ _   _ ______  _______          ________ ______ _____  ______ _____  \n" +
            " |  \\/  |_   _| \\ | |  ____|/ ____\\ \\        / /  ____|  ____|  __ \\|  ____|  __ \\ \n" +
            " | \\  / | | | |  \\| | |__  | (___  \\ \\  /\\  / /| |__  | |__  | |__) | |__  | |__) |\n" +
            " | |\\/| | | | | . ` |  __|  \\___ \\  \\ \\/  \\/ / |  __| |  __| |  ___/|  __| |  _  / \n" +
            " | |  | |_| |_| |\\  | |____ ____) |  \\  /\\  /  | |____| |____| |    | |____| | \\ \\ \n" +
            " |_|  |_|_____|_| \\_|______|_____/    \\/  \\/   |______|______|_|    |______|_|  \\_\\\n"
    )
    var pilih = pilih("Mulai", "Keluar", 1)
    while ((pilih[0] == 1 && (pilih[1] == 1) || pilih[1] == 2)) {
        val mine1 = buatMine(1)
        val mine2 = buatMine(2)
//        printMine(mine2)   //ngecheat
        var mineDibuka = 0
        var gameOver = false
        var status = "Mulai"
        while (!gameOver && mineDibuka <= 19) {
            println("------------------- $status -------------------")
            printMine(mine1)
            println("Pilih Koordinat")
            var x: Int = koordinat("x")
            var y: Int = koordinat("y")
            while (mine1[ubahIndex(x)][ubahIndex(y)] == '1') {
                println("Koordinat ($x,$y) sudah terbuka, pilih koordinat lain!")
                x = koordinat("x")
                y = koordinat("y")
            }
            println("Mengecek koordinat ($x,$y)")

            val cek = cekMine(mine2, x, y)
            if (cek) {
                status = "Bukan Bom"
                mine1[ubahIndex(x)][ubahIndex(y)] = '1'
                mineDibuka++
            }else {
                status = "Duarr"
                mine1[ubahIndex(x)][ubahIndex(y)] = '*'
                println("------------------- $status -------------------")
                printMine(mine1)
                gameOver = true
                println("Yowai Mo")
                println("Gitu doang kalah")
            }
        }
        if (!gameOver && mineDibuka == 20 ) {
            status = "Menang"
            println("------------------- $status -------------------")
            printMine(mine1)
            println("Hoki doang itu")
        }
        pilih = pilih("Main lagi", "Dah ah cape", 2)
        if(pilih[0] == 2 && pilih[1] == 2) {
            printMine(mine2)
            pilih = pilih("Main lagi", "Keluar", 1)

        }
    }
    if (pilih[1] == 2)
        println("Gitu doang nyerah T_T")
    println("Keluar....")
}

fun pilih(s: String, t: String, u: Int) :List<Int> {
    val v = u + 1
    println("1. $s")
    if(u == 2)
        println("2. Lihat posisi bom")
    println("$v. $t")
    println("Pilih: ")

    var pilih: Int = -1
    while (pilih == -1) {
        val input= readLine()?.toIntOrNull()
        if (input != null) {
            if (((input == 1 || input == 2) && u == 1) || ((input in 1..3) && u == 2))
                pilih = input
            else
                println("Pilihan apaan itu!")
        }
        else
            println("Pilihan apaan itu!")
    }
    return listOf(pilih, u)
}

fun buatMine(mine: Int) :Array<Array<Char>> {
    val mineHasil = Array(5) { Array(5) { ' ' } }
    if (mine == 1) {
        for (i in 0..4) {
            for (j in 0..4) {
                mineHasil[i][j] = '_'
            }
        }
    }else if (mine == 2) {
        for (i in 0..4) {
            for (j in 0..4) {
                mineHasil[i][j] = '1'
            }
        }
        var bom = 0
        while (bom < 5) {
            val randomBaris = Random.nextInt(4)
            val randomKolom = Random.nextInt(4)
            if (mineHasil[randomBaris][randomKolom] != '*') {
                mineHasil[randomBaris][randomKolom] = '*'
                bom++
            }
        }
    }
    return mineHasil
}

fun printMine(mine: Array<Array<Char>>) {
    println("# Y 1 2 3 4 5")
    println("X |==========")
    for (i in 0..4) {
        val baris = i + 1
        print("$baris |")
        for (j in 0..4) {
            print(" " + mine[i][j])
        }
        println()
    }
}

fun koordinat(z:String) :Int {
    var n: Int = -1
    while (n == -1) {
        print("$z : ")
        val input = readLine()?.toIntOrNull()
        if (input != null) {
            if (input in 1..5)
                n = input
            else
                println("Invalid")
        }else
            println("Invalid")
    }
    return n
}

fun ubahIndex(n:Int):Int {
    return n - 1
}

fun cekMine(mine: Array<Array<Char>>, x: Int , y: Int ) :Boolean {
    return if (mine[ubahIndex(x)][ubahIndex(y)] == '*')
        false
    else
        true
}