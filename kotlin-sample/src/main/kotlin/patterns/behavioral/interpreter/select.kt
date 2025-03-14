package patterns.behavioral.interpreter

/*  The second parameter is another function that receive nothing and return 
    nothing.
    The most interesting part is that we specify the receiver for our lambda: 

    SelectClause.() -> Unit
*/
fun select(columns: String, from: SelectClause.() -> Unit): SelectClause {
    /* 
        This could be translated into the following piece of code:
        val selectClause = SelectClause(columns)
        from(selectClause)
        return selectClause
    */ 
    return SelectClause(columns).apply(from)
}
