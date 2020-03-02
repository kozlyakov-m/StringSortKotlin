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

    return if (args.isNotEmpty()) {
        if (args[0] != "-f") {
            args
        } else {
            try {
                if (args.size > 1) {
                    checkEmptyLine(File(args[1]).readText())
                } else {
                    exitProcess(1)
                }
            } catch (e: FileNotFoundException) {
                exitProcess(1)
            }
        }
    } else {
        checkEmptyLine(readLine()?.trim('"')?.trim())
    }
}

private fun checkEmptyLine(input: String?): Array<String> {
    return if (input?.isEmpty() == true) {
        emptyArray()
    } else {
        input?.split("""[\s\t\n\r]+""".toRegex())?.toTypedArray() ?: emptyArray()
    }
}

private fun findUnique(text: Array<String>): LinkedHashMap<String, Int> {
    val result: LinkedHashMap<String, Int> = linkedMapOf()
    for (str in text) {
        val freq = result[str] ?: 0
        result.put(str, freq+1)
    }
    return result   
}

private fun output(result: List<Pair<String, Int>>) {
    for ((word, freq) in result) {
        println("""$word $freq""")
    }
}



