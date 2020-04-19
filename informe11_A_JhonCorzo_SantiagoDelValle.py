import numpy as np

#Punto a
def generador(min,max):
    array = np.random.randint(min,max,size=48).reshape(4,12)
    return array

#Punto b
ingresos = generador(100,181)
egresos = generador(60,131)

#Punto c
def imprimir(arreglo,n_arreglo):
    filas,columnas = arreglo.shape
    n_arreglo = n_arreglo.upper()
    for i in range(-2,filas):
        if i==0:
            print("║              ║Bucaramanga:   {}║".format(arreglo[i,:]))
        elif i==1:
            print("║CIUDADES      ║Floridablanca: {}║".format(arreglo[i,:]))
        elif i==2:
            print("║              ║Girón:         {}║".format(arreglo[i,:]))
        elif i==3:
            print("║              ║Piedecuesta:   {}║".format(arreglo[i,:]))
        elif i==-1:
            print("╔══════════════╦════════════════════════════════════════════════════════════════╗")
            print("║# MES         ║                 01  02  03  04  05  06  07  08  09  10  11  12 ║")
            print("╠══════════════╬════════════════════════════════════════════════════════════════╣")
        else:
            print("                            TABLA DE {}                                         ".format(n_arreglo))
    print("╚══════════════╩════════════════════════════════════════════════════════════════╝\n")

#Punto d
imprimir(ingresos,"ingresos")
imprimir(egresos,"egresos")

#Punto e
def calculador(a,b):
    r=a-b
    return 

#Punto f
ganancias = calculador(ingresos,egresos)
imprimir(ganancias,"ganancias")

#Punto g
def mejor_ciudad(arreglo):
    mayor=-31
    for i in range(4):
        comp = np.sum(arreglo[i,:])
        if mayor<comp:
            mayor=comp
            ciud=i
    if ciud == 0:
        print("La mejor ciudad es Bucaramanga, con {} millones de pesos en ganancias.".format(mayor))
    elif ciud==1:
        print("La mejor ciudad es Floridablanca, con {} millones de pesos en ganancias.".format(mayor))
    elif ciud==2:
        print("La mejor ciudad es Girón, con {} millones de pesos en ganancias.".format(mayor))
    else:
        print("La mejor ciudad es Piedecuesta, con {} millones de pesos en ganancias.".format(mayor))

mejor_ciudad(ganancias)