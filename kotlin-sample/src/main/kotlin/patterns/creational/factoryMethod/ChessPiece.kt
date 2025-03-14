package patterns.creational.factoryMethod

interface ChessPiece {
    val file: Char
    val rank: Char
}

// Factory method
fun createPiece(notation: String): ChessPiece {
    val (type, file, rank) = notation.toCharArray()
    return when (type) {
        'P' -> Pawn(file, rank)
        'Q' -> Queen(file, rank)
        else -> throw IllegalArgumentException("Invalid piece type")
    }
}
