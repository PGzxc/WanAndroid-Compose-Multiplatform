package network

enum class ExceptionCode(value:Int){
    JSON_NULl(1000)
}

class JsonException(private val status:String,private val desc:String):Exception() {
    override val message: String
        get() = "[$status]${desc}"
}