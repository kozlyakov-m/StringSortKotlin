
fun main (args:Array<String>){
    val result:MutableSet<String> = mutableSetOf()
    for(str in args){
        if(!result.contains(str))
            result.add(str)
        
    }
    result.toMutableList().sort()

    for(str in result){
        println(str)
    }
}