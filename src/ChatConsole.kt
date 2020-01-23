// Class that prints the chat history to the console when :messages command is used, Timurhan Calisiyor 1706766
class ChatConsole: ChatObserver{

    var historyConsole = mutableListOf<String>()
    var usernimi = String()

    fun register(){
        ChatHistory.registerObserver(this)

    }
    fun insertEm(message: String) {
        historyConsole.add(message)
    }

    fun printAll(){
        for(n in ChatHistory.history){
            println(n)
        }
    }

    override fun newMessage(message: String) {
        //println(System.out)
    }

    fun printToTop(){
        println(": ${historyConsole.size}")
    }
}