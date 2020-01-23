// Class that keeps track of users that are online, Timurhan Calisiyor 1706766
object Users {

    val userSet = mutableSetOf<String>()

    fun addUser(substringAfter: String) {
        userSet.add(substringAfter)
    }
    fun removeUser(substringAfter2: String?) {
        userSet.remove(substringAfter2)
    }
    fun checkUser() {
        println("Users online:")
        for (u in userSet) {
            println(u)
        }
    }
}