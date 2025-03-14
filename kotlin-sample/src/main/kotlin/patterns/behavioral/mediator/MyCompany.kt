package patterns.behavioral.mediator

class MyCompany(private val productManager: ProductManager) {
    fun taskCompleted(isMajorRelease: Boolean) {
            println(productManager.isAllGood(isMajorRelease))
    }
}
