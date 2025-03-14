package patterns.behavioral.visitor

import patterns.behavioral.visitor.HtmlElement

object Image: HtmlElement() {
    val src: String
        get() = "https://some.image"
}
