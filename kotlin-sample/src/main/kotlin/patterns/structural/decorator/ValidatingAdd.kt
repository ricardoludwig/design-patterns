package patterns.structural.decorator

class ValidatingAdd(private val repository: StarTrekRepository) 
    : StarTrekRepository by repository {

    private val maxNameLength = 15

    override fun addCaptain(starshipName: String, captainName: String) {
        require(captainName.length <= maxNameLength) {
            "$captainName name is longer than $maxNameLength characters!"
        }

        repository.addCaptain(starshipName, captainName)
    }
}
