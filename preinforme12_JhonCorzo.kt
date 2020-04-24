import kotlin.math.sqrt

fun main(){
    //Ejercicio 1

    val presionSemanal = listOf<Float>(110.06F,107.89F,108.45F,108.49F,109.03F,110.11F,109.87F,119.38F,119.35F,116.34F,117.73F,120.01F,118.19F,119.53F,117.09F,118.03F,118.65F,117.47F,
            117.49F,109.65F,110.44F,110.51F,107.38F,109.26F,106.18F,109.36F,106.61F,105.16F,110.11F,105.48F,108.37F,107.59F,108.91F,108.35F,109.57F,122.56F,
            124.44F,125.97F,121.03F,121.22F,122.41F,122.15F,124.52F,123.35F,125.76F,121.08F,122.29F,105.42F,110.67F,107.73F,105.76F,107.85F)

    //Ejercicio 2
    var mayor=0F
    for(i in presionSemanal){
        if(i>mayor)
            mayor=i
    }
    var menor=0F
    for(x in presionSemanal) {
        if (x < menor)
            menor = x
    }
    var dif = mayor - menor

    println("El resultado de la diferencia entre la mayor y la menor presión promedio semanal registrada es de $dif")

    //Ejercicio 3
    var bpresion = presionSemanal.toMutableList()

    bpresion.sort()
    var mediana = (bpresion[25]+bpresion[26])/2

    var acum=0F
    for  (i in presionSemanal){
        acum=i+acum
    }
    var promedio = acum/52
    println("La media o promedio de los datos es ${promedio}KPa, la mediana es ${mediana}KPa y la diferencia de estas es ${promedio-mediana}.")

    //Ejercicio 4
    var presionSup = mutableListOf<Float>()
    var cont=0F
    var contc=0F
    var contb=0F

    for (u in presionSemanal) {
        if ((u > promedio) && (cont==0F)) {
            presionSup.add(u)
            contc += 1F
            cont += 1F
        }
        else if (u > promedio && contc == cont -1F) {
            presionSup.add(u)
            contc += 1F
        }
        if (cont != 0F) {
            if (contc == cont - 1F)
                cont += 1F
            else {
                cont = 0F
                contc = 0F
            }
            contb += 1F
        }
    }

    var presionInf = mutableListOf<Float>()
    cont=0F
    contc=0F
    contb=0F

    for (o in presionSemanal) {
        if ((o < promedio) && (cont==0F)) {
            presionInf.add(o)
            contc += 1F
            cont += 1F
        }
        else if (o < promedio && contc == cont -1F) {
            presionInf.add(o)
            contc += 1F
        }
        if (cont != 0F) {
            if (contc == cont - 1F)
                cont += 1F
            else {
                cont = 0F
                contc = 0F
            }
            contb += 1F
        }
    }
    println("\nLas semanas consecutivas en las que el promedio semanal fue mayor al promedio anual son:\n${presionSup}\n")
    println("Las semanas consecutivas en las que el promedio semanal fue menor al promedio anual son:\n${presionInf}\n")

    //Ejercicio 6

    //6.1

    var tempSemanal = mutableListOf<Float>()
    for(k in presionSemanal){
        var t=(k*510)/(17.16*8.314472)
        tempSemanal.add(t.toFloat())
    }
    acum=0F
    for(ii in tempSemanal)
        acum=ii+acum
    var tempPro=acum/52
    println("La temperatura promedio de las semanas es ${tempPro}°C")

    //6.2
    acum=0F
    for(p in tempSemanal){
        var sumr:Float = (p-tempPro) * (p-tempPro)
        acum= sumr + acum
    }
    val desviacion = sqrt(acum/52)
    println("La desviación estandar de las mediciones en temperaturas registradas a lo largo del año es $desviacion")

    //6.3
    var tempSup= mutableListOf<String>()
    var tempSupCopy = mutableListOf<Float>()
    cont=0F
    contc=0F
    contb=0F

    for (u in  presionSemanal){
        if (u>promedio && cont==0F){
            tempSup.add("Semana ${(contb+1).toInt()}, presión $u y temperatura ${tempSemanal[contb.toInt()]}°C")
            tempSupCopy.add(tempSemanal[contb.toInt()])
            contc+=1
            cont+=1
        }
        else if (u>promedio && contc==cont-1){
            tempSup.add("Semana ${(contb+1).toInt()}, presión $u y temperatura ${tempSemanal[contb.toInt()]}°C")
            tempSupCopy.add(tempSemanal[contb.toInt()])
            contc+=1
        }
        if (cont!=0F){
            if (contc==cont-1)
            cont+=1F
            else {
                cont = 0F
                contc = 0F
            }
        }
        contb+=1F

    }

    var tempInf= mutableListOf<String>()
    var tempInfCopy = mutableListOf<Float>()
    cont=0F
    contc=0F
    contb=0F

    for (u in  presionSemanal){
        if (u<promedio && cont==0F){
            tempInf.add("Semana ${(contb+1).toInt()}, presión $u y temperatura ${tempSemanal[contb.toInt()]}°C")
            tempInfCopy.add(tempSemanal[contb.toInt()])
            contc+=1
            cont+=1
        }
        else if (u<promedio && contc==cont-1){
            tempInf.add("Semana ${(contb+1).toInt()}, presión $u y temperatura ${tempSemanal[contb.toInt()]}°C")
            tempInfCopy.add(tempSemanal[contb.toInt()])
            contc+=1
        }
        if (cont!=0F){
            if (contc==cont-1)
                cont+=1F
            else {
                cont = 0F
                contc = 0F
            }
        }
        contb+=1F
    }
    println("\nLas semanas consecutivas en las que el promedio semanal fue mayor al promedio anual, con su respectiva temperatura, son:\n${tempSup}\n")
    println("Las semanas consecutivas en las que el promedio semanal fue menor al promedio anual, con su respectiva temperatura, son:\n${tempInf}\n")

    //6.4
    println("La desviación estandar en la semana 1 a la 7, en este tiempo la presión estuvo por debajo del promedio, es ${desviacionMuestra(0,7,tempInfCopy)}")
    println("La desviación estandar en la semana 8 a la 19, en este tiempo la presión estuvo por encima del promedio, es ${desviacionMuestra(0,11,tempSupCopy)}")
    println("La desviación estandar en la semana 20 a la 35, en este tiempo la presión estuvo por debajo del promedio, es ${desviacionMuestra(8, 23, tempInfCopy)}")
    println("La desviación estandar en la semana 36 a la 47, en este tiempo la presión estuvo por encima del promedio, es ${desviacionMuestra(12,24,tempSupCopy)}")
    println("La desviación estandar en la semana 48 a la 52, en este tiempo la presión estuvo por debajo del promedio, es ${desviacionMuestra(24, 28, tempInfCopy)}")

    //6.5
    println("\nLa desviación estandar en la semana 1 a la 7, en este tiempo la presión estuvo por debajo del promedio, es ${desviacionMuestra(0,7,tempInfCopy)}, y el promedio de temperatura durante estas semanas fue de ${media(0,7,tempInfCopy)}°C.\n")
    println("La desviación estandar en la semana 8 a la 19, en este tiempo la presión estuvo por encima del promedio, es ${desviacionMuestra(0,11,tempSupCopy)}, y el promedio de temperatura durante estas semanas fue de ${media(0,11,tempSupCopy)}°C.\n")
    println("La desviación estandar en la semana 20 a la 35, en este tiempo la presión estuvo por debajo del promedio, es ${desviacionMuestra(8,23,tempInfCopy)}, y el promedio de temperatura durante estas semanas fue de ${media(8,23,tempInfCopy)}°C.\n")
    println("La desviación estandar en la semana 36 a la 47, en este tiempo la presión estuvo por encima del promedio, es ${desviacionMuestra(12,24,tempSupCopy)}, y el promedio de temperatura durante estas semanas fue de ${media(12,24,tempSupCopy)}°C.\n")
    println("La desviación estandar en la semana 48 a la 52, en este tiempo la presión estuvo por debajo del promedio, es ${desviacionMuestra(24,28,tempInfCopy)}, y el promedio de temperatura durante estas semanas fue de ${media(24,28,tempInfCopy)}°C.\n")
}

fun desviacionMuestra(ini:Int,fin:Int,lista:MutableList<Float>):Float{
    var des=0F
    var prom= media(ini,fin,lista)
    for (w in ini until fin) {
        des = ((prom - lista[w])*(prom - lista[w]))+ des
    }
    des= ((des/fin-1)*0.5).toFloat()
    return des
}

fun media(ini:Int,fin: Int,lista: MutableList<Float>): Float {
    var acum=0F
    var cont=0F
    for(nu in ini..fin-1){
        acum=acum+lista[nu]
        cont+=1
    }
    var prom=acum/cont
    return prom
}


