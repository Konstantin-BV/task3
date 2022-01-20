package lab4

class Matrix(var table : Array<Array<Double>>) {
    var a = table.size
    var b = table[0].size

    operator fun plus(other : Matrix) : Matrix {
        for (i in 1..a) {
            for (j in 1..b) {
                other.table[i - 1][j - 1] += table[i - 1][j - 1]
            }
        }
        return Matrix(other.table)
    }

    operator fun plusAssign(other : Matrix) {
        for (i in 1..a) {
            for (j in 1..b) {
                table[i - 1][j - 1] = table[i - 1][j - 1] + other.table[i - 1][j - 1]
            }
        }
    }

    operator fun minus(other : Matrix) : Matrix {
        for (i in 1..a) {
            for (j in 1..b) {
                other.table[i - 1][j - 1] -= table[i - 1][j - 1]
            }
        }
        return Matrix(other.table)
    }

    operator fun minusAssign(other : Matrix) {
        for (i in 1..a) {
            for (j in 1..b) {
                table[i - 1][j - 1] = table[i - 1][j - 1] - other.table[i - 1][j - 1]
            }
        }
    }

    fun times(other : Matrix) : Matrix {
        val resul : Array<Array<Double>> = Array(a) { Array(other.a) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..b) {
                for (k in 1..table.size) {
                    resul[i - 1][j - 1] += table[i - 1][k - 1] * other.table[k - 1][j - 1]
                }
            }
        }
        return Matrix(resul)
    }

    fun timesAssign(other : Matrix) {
        val resul : Array<Array<Double>> = Array(a) { Array(other.b) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..other.b) {
                for (k in 1..b) {
                    resul[i - 1][j - 1] += table[i - 1][k - 1] * other.table[k - 1][j - 1]
                }
            }
        }
        table = resul
        a = table.size
        b = table[0].size
    }

    fun is_comparison(other : Matrix) : Boolean {
        var comparison = true
        if (a == other.a && b == other.b)
            for (i in 1..a) {
                for (j in 1..b) {
                    if (other.table[i - 1][j - 1] != table[i - 1][j - 1])
                        comparison = false
                }
            }
        else {
            comparison = false
        }
        return comparison
    }

    fun ToString() : String {
        var resultat = ""
        for (i in 1..a) {
            for (j in 1..b) {
                resultat += table[i - 1][j - 1].toString() + "\t"
            }
            resultat += "\n"
        }
        return resultat
    }

    fun timesScalar(value : Double) : Matrix {
        val resul : Array<Array<Double>> = Array(a) { Array(b) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..b) {
                resul[i - 1][j - 1] += table[i - 1][j - 1] * value

            }
        }
        return Matrix(resul)
    }

    fun div(value : Double) : Matrix {
        val resul : Array<Array<Double>> = Array(a) { Array(b) { 0.0 } }
        for (i in 1..a) {
            for (j in 1..b) {
                resul[i - 1][j - 1] += table[i - 1][j - 1] / value

            }
        }
        return Matrix(resul)
    }

    fun divAssign(value : Double) {
        for (i in 1..a) {
            for (j in 1..b) {
                table[i - 1][j - 1] /= value

            }
        }
    }

    operator fun set(i : Int , j : Int , value : Double) {
        table[i][j] = value
    }

    fun getSizeRows() : Int {
        return a
    }

    fun getSizeColumns() : Int {
        return b
    }

    operator fun get(i : Int , j : Int) : Double {
        return table[i][j]
    }

    operator fun unaryMinus() : Matrix {
        val resultat = Matrix(table)
        for (i in 1..a) {
            for (j in 1..b) {
                resultat.table[i - 1][j - 1] = -table[i - 1][j - 1]
            }
        }
        return resultat
    }

    operator fun unaryPlus() : Matrix {
        return this
    }


}