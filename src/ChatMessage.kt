// Class that takes a message from CommandInterpreter and gives it to ChatHistory as a string, Timurhan Calisiyor 1706766
class ChatMessage{

    fun newMessagee(viesti: String ,nimi: String, aika: String){
        ChatHistory.insert("$viesti - from $nimi@$aika")
    }

    fun newUser(nimi: String){
        ChatHistory.insert("$nimi has joined the chat!")
    }

    fun userLeft(nimi: String){
        ChatHistory.insert("$nimi has left the chat!")
    }
}
