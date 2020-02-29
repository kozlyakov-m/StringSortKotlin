import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val text: Array<String> = getText(args)

    val words: LinkedHashMap<String, Int> = findUnique(text)

    val comparator = compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }
    val result: List<Pair<String, Int>> = words.toList().sortedWith(comparator)

    output(result)

}

private fun getText(args: Array<String>): Array<String> {

    if (args.isEmpty()) {
        return readLine()!!.split(" ").toTypedArray()
    } else {
        if (args[0] == "-f") {
            try {
                if (args.size > 1) {
                    return File(args[1]).readText().split(" ").toTypedArray()
                } else {
                    println("Не указано имя файла")
                    exitProcess(1)
                }
            } catch (e: FileNotFoundException) {
                println(e.message)
                exitProcess(1)
            }
        } else {
            return args
        }
    }
}

private fun findUnique(text: Array<String>): LinkedHashMap<String, Int> {
    val result: LinkedHashMap<String, Int> = linkedMapOf()
    for (str in text) {

        if (result.containsKey(str)) {
            val freq = result[str]
            result.put(str, freq!!.plus(1)) // почему-то теперь не дает сделать просто freq+1
        } else {
            result.put(str, 1);
        }
    }
    return result
}

private fun output(result: List<Pair<String, Int>>) {
    for ((word, freq) in result) {
        println("""$word $freq""")
    }
}



