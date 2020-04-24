import math

#Ejercicio 1

presion_semanal= [110.06,107.89,108.45,108.49,109.03,110.11,109.87,119.38,119.35,116.34,117.73,120.01,118.19,119.53,117.09,118.03,118.65,117.47,
                  117.49,109.65,110.44,110.51,107.38,109.26,106.18,109.36,106.61,105.16,110.11,105.48,108.37,107.59,108.91,108.35,109.57,122.56,
                  124.44,125.97,121.03,121.22,122.41,122.15,124.52,123.35,125.76,121.08,122.29,105.42,110.67,107.73,105.76,107.85]

#Ejercicio 2
mayor=0
for i in presion_semanal:
    if i>mayor:
        mayor=i

menor=150
for x in presion_semanal:
    if x<menor:
        menor=x

dif=mayor-menor

print("El resultado de la diferencia entre la mayor y la menor presión promedio semanal registrada es de",dif)

#Ejercicio 3
bpresion_semanal=presion_semanal.copy()
bpresion_semanal.sort()
mediana = (bpresion_semanal[25]+bpresion_semanal[26])/2

acum=0
for i in presion_semanal:
    acum=i +acum
promedio=acum/52

print("La media o promedio de los datos es {}KPa, la mediana es {}KPa y la diferencia de estas es {}".format(promedio,mediana,promedio-mediana))