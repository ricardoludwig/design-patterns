package patterns.behavioral.interpreter

/*
    1. Create an instance of FromClause.
    2. Store FromClause as a member of SelectClause.
    3. Pass an instance of FromClause to the where lambda.
    4. Return the instance of FromClause.

*/
class SelectClause(private val columns: String) {
    
    private lateinit var from: FromClause

    fun from(
        table: String,
        where: FromClause.() -> Unit
        ): FromClause {
            this.from = FromClause(table)
            return this.from.apply(where)
        }

        override fun toString() = "SELECT $columns $from"
}
