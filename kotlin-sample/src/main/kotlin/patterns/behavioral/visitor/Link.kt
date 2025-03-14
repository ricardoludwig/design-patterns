package patterns.behavioral.visitor

import patterns.behavioral.visitor.HtmlElement

object Link: HtmlElement() {
    val href: String
        get() = "https://www.google.com"
}
