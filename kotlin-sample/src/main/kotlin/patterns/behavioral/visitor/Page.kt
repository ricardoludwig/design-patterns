package patterns.behavioral.visitor

import patterns.behavioral.visitor.HtmlElement
import patterns.behavioral.visitor.LinksCrawler

class Page(val elements: MutableList<HtmlElement> = mutableListOf()) {
    constructor(vararg elements: HtmlElement) : this(elements.toMutableList()) {
        for (s in elements) {
            this.elements.add(s)
        }
    }
}

fun Page.accept(feature: LinksCrawler) = feature.visit(this)
