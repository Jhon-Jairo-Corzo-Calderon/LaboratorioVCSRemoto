import numpy as np

#Punto a
def generador(min,max):
    array = np.random.randint(min,max,size=48).reshape(4,12)
    return array

#Punto b
ingresos = generador(100,181)
egresos = generador(60,131)
