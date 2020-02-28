
fun main(args:Array<String>){
    

    val result: MutableList<MutablePair> = mutableListOf()
    for(str in args){

        var nothingFound:Boolean = true;
        for(pair in result) {
            if (pair.word.equals(str)) {
                pair.frequency++;
                nothingFound = false;
                break;
            }

        }
        if(nothingFound){
            result.add(MutablePair(str,1));
        }
    }

    result.sortWith(compareByDescending<MutablePair>{it.frequency}.thenBy {it.word})


    for((word, freq) in result){
        println("""$word $freq""")

    }

}


