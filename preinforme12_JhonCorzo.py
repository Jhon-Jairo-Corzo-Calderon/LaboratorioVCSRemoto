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

#Ejercicio 4
presion_sup=[]
cont=0    #Con los 2 primeros contadores se evalua si los promedios semanales son mayores al promedio mensual y son consecutivos.
contc=0   
contb=0   #Este contador solo se va a usar para indicar las semanas en las que se cumplen las condiciones.

for u in presion_semanal:
    if u>promedio and cont==0:
        presion_sup.append(['Semana {}'.format(contb+1),u])
        contc+=1
        cont+=1
    elif u>promedio and contc==cont-1:
        presion_sup.append(['Semana {}'.format(contb+1),u])
        contc+=1
    
    if cont!=0:
        if contc==cont-1:
            cont+=1
        else:
            cont=0
            contc=0
    contb+=1

presion_inf=[]
cont=0
contc=0
contb=0

for o in presion_semanal:
    if o<promedio and cont==0:
        presion_inf.append(['Semana {}'.format(contb+1),o])
        contc+=1
        cont+=1
    elif o<promedio and contc==cont-1:
        presion_inf.append(['Semana {}'.format(contb+1),o])
        contc+=1
    elif o<promedio and contc!=cont-1:
        cont=0
        contc=0

    if cont!=0:
        if contc==cont-1:
            cont+=1
        else:
            cont=0
            contc=0
    contb+=1

print("\nLas semanas consecutivas en las que el promedio semanal fue mayor al promedio anual son:\n{}\n".format(presion_sup))
print("Las semanas consecutivas en las que el promedio semanal fue menor al promedio anual son:\n{}\n".format(presion_inf))
