fun main(args: Array<String>) {

    val result: LinkedHashMap<String, Int> = linkedMapOf()
    for (str in args) {

        if (result.containsKey(str)) {
            val freq = result[str]
            result.put(str, freq!!.plus(1)) // почему-то теперь не дает сделать просто freq+1
        } else {
            result.put(str, 1);
        }
    }

    for ((word, freq) in result) {
        println("""$word $freq""")
    }

}



