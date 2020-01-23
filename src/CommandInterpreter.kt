// Class that handles all of the user input and actions, Timurhan Calisiyor 1706766
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.time.LocalDateTime
import java.util.*
import java.lang.Runnable
import java.time.format.DateTimeFormatter

class CommandInterpreter(input: InputStream, output: OutputStream): Runnable, ChatObserver {

    var quit = false
    var myMessages = ChatMessage()
    val scanner: Scanner = Scanner(input)
    val printStream: PrintStream = PrintStream(output, true)
    var nimi = ""
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")
    val chatConsole1 = ChatConsole()

    override fun run() {
        //printStream.println("Welcome to 2018 chat server")
        ChatHistory.registerObserver(this)
        chatConsole1.register()

        while (!quit) {
            val inputLine = scanner.nextLine()
            var time = LocalDateTime.now()
            val formattedDateTime: String = time.format(formatter)

                if (nimi == "") {
                    if (inputLine.startsWith(":user ")) {
                        nimi = inputLine.substringAfter(' ')
                        Users.addUser(inputLine.substringAfter(' '))
                        //printStream.println("Username set to $nimi")
                        myMessages.newUser(nimi)
                        val topChatter1 = TopChatter(nimi)
                        topChatter1.registerTC()

                    } else if(inputLine == ":user") {
                        printStream.println("User name not set: no user name specified")
                    } else {
                        printStream.println("User name not set. Use command :user to set it")
                    }

                } else if (inputLine.startsWith(':')) {
                        when (inputLine.substringBefore(' ')) {
                            ":user" ->
                                printStream.println("User name not set: no user name specified")
                            ":users" -> {
                                printStream.println("Users online:")
                                for (u in Users.userSet){
                                    printStream.println(u)
                                }
                            }
                            ":messages" -> {
                                printStream.println("History:")
                                for (t in ChatHistory.history){
                                printStream.println(t)
                            }
                                chatConsole1.printAll()
                            }
                            ":quit" -> {
                                val userName = nimi
                                Users.removeUser(userName)
                                quit = true
                            } else -> {
                                printStream.println("Did not get it " + inputLine)
                            }
                        }

                    } else if(inputLine.length != 0) {
                    myMessages.newMessagee(inputLine, nimi, formattedDateTime)

                    } else {
                        printStream.println("Messages without content are not sent!")
                    }
                }
        myMessages.userLeft(nimi)
        //scanner.close()
        }

    override fun newMessage(message: String) {
        printStream.println(message)
    }
}