import kotlin.random.Random

fun main() {
    println("Minesweeper !!!")
    println("1. Mulai")
    println("2. Keluar")
    println("Pilih: ")

    var pilih = pilih()
    when (pilih) {
        1 -> {
            var mine1 = buatMine(1)
            var mine2 = buatMine(2)
            var mineKosong = cekKosong(mine1)
            var gameOver = false
            var status = "Mulai"
            while (!gameOver) {
                if(mineKosong) {
                    println("------------------- $status -------------------")
                    printMine(mine1)
                    println("Pilih Koordinat")
                    var x: Int = koordinat("x")
                    var y: Int = koordinat("y")
                    println("Mengecek koordinat ($x,$y)")

                    while (mine1[x - 1][y - 1] == '1') {
                        println("koordinat ($x,$y) sudah terbuka, pilih koordinat lain!")
                        x = koordinat("x")
                        y = koordinat("y")
                    }

                    var cek = cekMine(mine2, x, y)
                    if (cek) {
                        status = "Bukan Bom"
                        mine1[x - 1][y - 1] = '1'
                        println("------------------- $status -------------------")
                        printMine(mine1)

                    }else {
                        status = "Duarr"
                        mine1[x - 1][y - 1] = '*'
                        println("------------------- $status -------------------")
                        printMine(mine1)
                        gameOver = true
                        println("Yowai Mo")
                        println("Terrorist Win")

                    }
                }else {
                    println("Counter-Terrorist Win")
                    break
                }
            }
            println("1. Ulangi")
            println("1. Ulangi")


        }
        2 -> println("Keluar....")
    }

}

fun pilih() :Int {
    println("Minesweeper !!!")
    println("1. Mulai")
    println("2. Keluar")
    println("Pilih: ")

    var pilih: Int = -1
    while (pilih == -1) {
        val input = readlnOrNull()?.toInt()
        if (input == 1 || input == 2)
            pilih = input
        else
            println("Pilihan Tidak Valid!")
    }
    return pilih
}

fun buatMine(mine: Int) :Array<Array<Char>> {
    var mineHasil = Array(5) { Array(5) { ' ' } }
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
            var randomBaris = Random.nextInt(4)
            var randomKolom = Random.nextInt(4)
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
        var baris = i + 1
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
        var input = readLine()?.toInt()
        if (input != null) {
            if (input > -1 && input < 6)
                n = input
            else
                println("Invalid")
        }else
            println("Invalid")
    }
    return n
}

fun cekKosong(mine: Array<Array<Char>>) :Boolean {
    var status = false
    for (baris in mine) {
        for (kolom in baris) {
            if (kolom == '_')
                status = true
        }
    }
    return status
}

fun cekMine(mine: Array<Array<Char>>, x: Int , y: Int ) :Boolean {
    if (mine[x - 1][y - 1] == '*')
        return false
    else
        return true
}