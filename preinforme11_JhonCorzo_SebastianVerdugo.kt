

fun main() {
    var datos_votacion = arrayOf(arrayOf(21F,35F,37F,41F), arrayOf(36F,20F,45F,32F), arrayOf(58F,11F,20F,15F), arrayOf(45F,5F,19F,21F), arrayOf(12F,23F,38F,36F))

    //Ejercicio a
    println("-Los datos de la votación fueron, por candidato y por cada mesa de votación:")
    imprimirCand(datos_votacion,1)
    imprimirCand(datos_votacion,2)
    imprimirCand(datos_votacion,3)
    imprimirCand(datos_votacion,4)
    imprimirCand(datos_votacion,5)

    //Ejercicio b
    var total = totalCand(datos_votacion,0) + totalCand(datos_votacion,1) + totalCand(datos_votacion,2) + totalCand(datos_votacion,3)+ totalCand(datos_votacion,4)
    println("-El total de votos fueron: $total")
    impCand(datos_votacion,0,total)
    impCand(datos_votacion,1,total)
    impCand(datos_votacion,2,total)
    impCand(datos_votacion,3,total)
    impCand(datos_votacion,4,total)

    //Ejercicio c
    var mayor = 0F
    var rango = arrayOf(0, 1, 2, 3, 4)
    for (i in rango) {
        var comp = totalCand(datos_votacion, i)
        var cand = 0F
        if (comp > mayor) {
            mayor = comp
        }
    }
    println("-El candidato que obtuvo la mayor votación fue el candidato número 1 con un total de $mayor votos.")

    //Ejercicio d
    println("-Como ningún candidato obtuvo más del 50% de los votos, los candidatos que pasan a la siguiente vuelta son:")
    ejercicioD(datos_votacion,0,total)
    ejercicioD(datos_votacion,1,total)
}



fun imprimirCand(arreglo:Array<Array<Float>>,fila:Int){
    var votos = arreglo[fila-1].drop(0)
    println("Candidato $fila: $votos")
}
fun totalCand(arreglo: Array<Array<Float>>, cant:Int):Float {
    var rango = Array(4) { i -> i * 1 }
    var acum = 0F
    for (x in rango) {
        acum = acum + arreglo[cant].get(x)
    }
    return acum
}

fun impCand(arreglo: Array<Array<Float>>, cant: Int, total: Float){
    var cantDatos = totalCand(arreglo,cant)
    var por = cantDatos*100/total
    println("El ${cant+1} candidato obtuvo $cantDatos votos, corresponden al $por%.")
}

fun ejercicioD(arreglo: Array<Array<Float>>,cant: Int, total: Float) {
    var cantDatos = totalCand(arreglo,cant)
    var por = cantDatos*100/total
    println("Candidato ${cant+1}, con un porcentaje de $por% del total del los votos.")

}


