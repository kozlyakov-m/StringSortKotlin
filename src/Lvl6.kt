fun main(args: Array<String>) {

    val message: Array<String> =
        if (args.isNotEmpty()) {
            args
        } else {
            val input = readLine()?.trim('"')?.trim()
            if (input?.isEmpty() == true) {
                emptyArray()
            } else {
                input?.split("""[\s\t\n\r]+""".toRegex())?.toTypedArray() ?: emptyArray()
            }
        }

    val words: LinkedHashMap<String, Int> = linkedMapOf()
    for (str in message) {

        if (words.containsKey(str)) {
            val freq = words[str]
            words.put(str, freq!!.plus(1)) // почему-то теперь не дает сделать просто freq+1
        } else {
            words.put(str, 1);
        }
    }

    val comparator = compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }
    val result: List<Pair<String, Int>> = words.toList().sortedWith(comparator)


    for ((word, freq) in result) {
        println("""$word $freq""")
    }

}



