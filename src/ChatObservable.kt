// Observable class, Timurhan Calisiyor 1706766
interface ChatObservable{

    fun registerObserver(observer: ChatObserver)

    fun deregisterObserver(observer: ChatObserver)

    fun notifyObservers(message: String)
}