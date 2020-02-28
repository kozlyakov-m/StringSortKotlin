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

    val words:LinkedHashMap<String, Int> = linkedMapOf()
    for(str in message){

        if(words.containsKey(str)){
            val freq = words[str]
            words.put(str, freq!!.plus(1) ) // почему-то теперь не дает сделать просто freq+1
        }
        else{
            words.put(str, 1);
        }
    }

    val comparator = compareByDescending<Pair<String, Int>>{it.second}.thenBy {it.first}
    val result:List<Pair<String, Int>> = words.toList().sortedWith(comparator)


    for((word, freq) in result){
        println("""$word $freq""")

    }

}



