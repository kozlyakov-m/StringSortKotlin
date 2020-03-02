fun main(args: Array<String>) {
    args.sort()
    val result = args.groupingBy { it }.eachCount()
    result.forEach { (word, freq) -> println("$word : $freq") }
}



