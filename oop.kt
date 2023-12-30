import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"
    
    open fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }
    
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }
    
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set
    
    fun decreaseTvVolume() {
        if(smartTvDevice.deviceStatus != "on") return
        
        smartTvDevice.decreaseSpeakerVolume()
    }

    fun turnOnTv() {
        if(smartTvDevice.deviceStatus == "on") return
        
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        if(smartTvDevice.deviceStatus == "off") return
        
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        if(smartTvDevice.deviceStatus == "off") return
        
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        if(smartTvDevice.deviceStatus == "off") return
        
        smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious() {
        if(smartTvDevice.deviceStatus == "off") return
        
        smartTvDevice.previousChannel()
    }
    
    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }
    
    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun turnOnLight() {
        if(smartLightDevice.deviceStatus != "off") return
        
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        if(smartLightDevice.deviceStatus == "off") return
        
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        if(smartLightDevice.deviceStatus == "off") return
        
        smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        if(smartLightDevice.deviceStatus == "off") return
        
        smartLightDevice.decreaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartHome: SmartHome = SmartHome(
        smartTvDevice = SmartTvDevice("Android TV", "Entertainment"),
        smartLightDevice = SmartLightDevice("Google Light", "Utility")
    )
    smartHome.turnOnTv()
    smartHome.turnOnLight()
    
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    
    smartHome.decreaseLightBrightness()
}
