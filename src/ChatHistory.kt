// Class that collects sent messages in to a list, Timurhan Calisiyor 1706766
object ChatHistory: ChatObservable {

    var history = mutableListOf<String>()
    val observers = mutableSetOf<ChatObserver>()

    fun insert(message: String) {
        var uusiNimi = message.substringAfterLast(' ')
        history.add(message)
        notifyObservers(message)
    }

    fun checkHistory() {
        println("History:")
        for (t in history) {
            println(t)
        }
    }

    override fun registerObserver(observer: ChatObserver) {
            observers.add(observer)
    }
    override fun deregisterObserver(observer: ChatObserver) {
    }
    override fun notifyObservers(message: String) {
        for (o in observers){
            o.newMessage(message)
        }
    }
}