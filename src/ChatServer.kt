// ChatServer class gets the server socket and connects users, Timurhan Calisiyor 1706766
import java.net.ServerSocket
import java.util.*

class ChatServer{

    fun serve(){
        val ss = ServerSocket(40001)

        println("Port " + ss.localPort)
        while(true) {
            val s = ss.accept()
            println("New connection!")
            val reader: Scanner = Scanner(s.getInputStream())
            val thrd = Thread(CommandInterpreter(s.getInputStream(), s.getOutputStream()))
            thrd.start()
            false
        }
    }
}