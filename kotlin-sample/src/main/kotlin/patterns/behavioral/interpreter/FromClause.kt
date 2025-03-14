package patterns.behavioral.interpreter

class FromClause(private val table: String) {

    private lateinit var where: WhereClause

    fun where(conditions: String) = this.apply {
        where = WhereClause(conditions)
    }

    override fun toString()= "FROM $table $where"
}
