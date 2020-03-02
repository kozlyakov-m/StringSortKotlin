fun main(args: Array<String>) {

    val words: LinkedHashMap<String, Int> = linkedMapOf()
    for (str in args) {
        val freq = words[str] ?: 0
        words.put(str, freq+1)
    }

    val comparator = compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }
    val result: List<Pair<String, Int>> = words.toList().sortedWith(comparator)


    for ((word, freq) in result) {
        println("""$word $freq""")
    }

}



