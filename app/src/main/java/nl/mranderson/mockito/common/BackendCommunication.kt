package nl.mranderson.mockito.common


class BackendCommunication {

    fun doTask(url: String): Boolean {
        Thread.sleep(3000) //BE Call
        return true
    }
}
