package patterns.behavioral.interpreter

class WhereClause(private val conditions: String) {
    override fun toString()= "WHERE $conditions"
}
