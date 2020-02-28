
fun main (args:Array<String>){
    val result:LinkedHashMap<String, Int> = linkedMapOf()
    for(str in args){

        var nothingFound:Boolean = true;
        for((word, freq) in result) {
            if (word.equals(str)) {
                result.put(str, freq+1);
                nothingFound = false;
                break;
            }

        }
        if(nothingFound){
            result.put(str, 1);
        }
    }

    for((word, freq) in result){
        println("""$word $freq""")
    }
}

