import java.util.*

fun main (args:Array<String>){
    val result:SortedSet<String> = sortedSetOf()
    for(str in args){
        if(!result.contains(str))
            result.add(str)

    }
    for(str in result){
        println(str)
    }
}