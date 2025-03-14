package patterns.behavioral.visitor

import patterns.behavioral.visitor.HtmlElement
import patterns.behavioral.visitor.LinksCrawler

class Container(val elements: MutableList<HtmlElement> = mutableListOf()) : HtmlElement() {
    constructor(vararg units: HtmlElement) : this(mutableListOf()) {
        for (u in units) {
            this.elements.add(u)
        }
    }
}

fun Container.accept(feature: LinksCrawler) {
    feature.visit(elements)
}
