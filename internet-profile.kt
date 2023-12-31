fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        
        var details: String? = null;
        
        if(hobby != null) {
        	details = "Likes to $hobby."
        } else {
            details = "Has no hobbies."
        }
        
        if(referrer != null) {
			details += " Has a referrer named Amanda${if(referrer.hobby == null) "." else ", who likes to ${referrer.hobby}"}."
        } else {
        	details += " Doesn't have a referrer"
    	}
    
    	println(details)
        println()
    }
}
