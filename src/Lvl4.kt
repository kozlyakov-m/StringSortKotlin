fun main(args: Array<String>) {

    val result: LinkedHashMap<String, Int> = linkedMapOf()
    for (str in args) {
        val freq = result[str] ?: 0
        result.put(str, freq+1)
    }

    for ((word, freq) in result) {
        println("""$word $freq""")
    }

}



