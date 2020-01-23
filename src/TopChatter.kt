// Class that was supposed to count the sum of messages sent by each user, but i could not get it to work properly.
// Class prints to console sum of every messages sent with every users name, Timurhan Calisiyor 1706766
class TopChatter(var nimi: String): ChatObserver {

    var messageMap = mutableMapOf<String, Int>()

    fun registerTC() {
        ChatHistory.registerObserver(this)
    }

    override fun newMessage(message: String) {
        if (!messageMap.containsKey(nimi)) {
            messageMap.merge(this.nimi, 1, Int::plus)
            println(messageMap)
        } else {
            messageMap.merge(nimi, 1, Int::plus)
        }
        println(messageMap)
    }
}



