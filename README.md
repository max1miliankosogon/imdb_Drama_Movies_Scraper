# imdb_Drama_Movies_Scraper

The programme gets a list of movies from IMDb by a certain genre and displays their titles on the screen.

This program uses the kotlinx.coroutines and Jsoup libraries to get a list of movies from IMDb.

The main function main() first displays the message "Program has started." using the println() function.

Then the launch block is launched, which consists of a repeat loop of the page variable, which passes through the range of pageRange pages. On each page, the program queries the IMDb drama search page and retrieves a list of movies with titles.

To get the page at the address, the getPage(url: String): Document? function is used, which accepts a string from the URL and returns a Document object with the contents of the page. The function uses a built-in coroutine with the Dispatchers.IO context to make a request to the server in another thread and not block the main thread.

To avoid overloading the IMDb server, the program pauses for 1 second on each page before moving to the next page.

Finally, the invokeOnCompletion function adds an event handler that outputs the message "Program has finished." after the completion of the launch block.
