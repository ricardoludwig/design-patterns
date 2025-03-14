package patterns.behavioral.visitor

import patterns.behavioral.visitor.HtmlElement
import patterns.behavioral.visitor.Container
import patterns.behavioral.visitor.Link
import patterns.behavioral.visitor.Image

class LinksCrawler {

    private var _links = mutableListOf<String>()

    val links
        get() = _links.toList()

    fun visit(page: Page) {
        visit(page.elements)
    }

    fun visit(elements: List<HtmlElement>) {
        for (e in elements) {
            when(e) {
                is Container -> e.accept(this)
                is Link -> _links.add(e.href)
                is Image -> _links.add(e.src)
                else -> {}
            }
        }
    }
}

fun collectLinks(page: Page): List<String> {
    return LinksCrawler().run {
        page.accept(this)
        this.links
    }
}
