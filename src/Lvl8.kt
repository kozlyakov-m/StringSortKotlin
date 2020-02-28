import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun main(args:Array<String>){

    val message:Array<String>

    if(args.isEmpty()){
        message = readLine()!!.split(" ").toTypedArray()
    }
    else{
        if(args[0]=="-f"){
           try{
               if(args.size > 1){
                   message = File(args[1]).readText().split(" ").toTypedArray()
               }
               else{
                   println("Не указано имя файла")
                   exitProcess(1)
               }
           }
           catch (e:FileNotFoundException){
                println(e.message)
                exitProcess(1)
           }
        }
        else{
            message = args
        }
    }

    val result: MutableList<MutablePair> = mutableListOf()
    for(str in message){

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



