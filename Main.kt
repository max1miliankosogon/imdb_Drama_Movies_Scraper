import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun main(): Unit = runBlocking {
    println("Program has started.")

    val job = launch {
        val pageRange = 1..4
        val baseUrl = "https://www.imdb.com"
        val searchUrl = "/search/title?genres=drama"

        repeat(pageRange.last) { page ->
            val searchPage = getPage(baseUrl + searchUrl + "&start=${page * 50 + 1}")

            val movies = searchPage?.select(".lister-item-header a[href^=\"/title/\"]")?.map { it.text() }

            println("Movies on page ${page + 1}: $movies")

            delay(1000)
        }
    }

    job.invokeOnCompletion {
        println("Program has finished.")
    }
}

suspend fun getPage(url: String): Document? = withContext(Dispatchers.IO) {
    try {
        Jsoup.connect(url).get()
    } catch (e: Exception) {
        println("Failed to get page: ${e.message}")
        null
    }
}


