// practice class method overrides and inheritance

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true): Phone() {
    override fun switchOn() {
        if(!isFolded) {
            super.switchOn()
        }
    }
    
    fun fold() {
        isFolded = true
    }
    
    fun unfold() {
        isFolded = false
    }
}

fun main() {
    val phone = FoldablePhone()
    
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.unfold()
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.switchOff()
    phone.checkPhoneScreenLight()
}