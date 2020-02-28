
fun main (args:Array<String>){
    var result:MutableList<String> = mutableListOf()
    for(str in args){
        if(!result.contains(str))
            result.add(str);
    }
    result.sort()

    for(str in result){
        println(str)
    }
}