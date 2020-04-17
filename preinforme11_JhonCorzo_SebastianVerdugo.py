import numpy as np

def imprimir_cand(num):
    print("Candidato",num,":",datos_votacion[:,num-1],)

def cant_votos(arreglo,num):
    suma=np.sum(arreglo[:,num-1])
    return suma

def porcentaje(num,total):
    return num*100/total

datos_votacion = np.array([[21,36,58,45,12],
                           [35,20,11,5,23],
                           [37,45,20,19,38],
                           [41,32,15,21,36]])

#Ejercicio a
print("Los datos de la votación fueron, por candidato y por cada mesa de votación:")
imprimir_cand(1)
imprimir_cand(2)
imprimir_cand(3)
imprimir_cand(4)
imprimir_cand(5)

#Ejercicio b
total=np.sum(datos_votacion)
print("El total de votos fueron:",total)
print("El primer candidato obtuvo",cant_votos(datos_votacion,1),"votos, corresponden al",porcentaje(cant_votos(datos_votacion,1),total),"%.")
print("El segundo candidato obtuvo",cant_votos(datos_votacion,2),"votos, corresponden al",porcentaje(cant_votos(datos_votacion,2),total),"%.")
print("El tercer candidato obtuvo",cant_votos(datos_votacion,3),"votos, corresponden al",porcentaje(cant_votos(datos_votacion,3),total),"%.")
print("El cuarto candidato obtuvo",cant_votos(datos_votacion,4),"votos, corresponden al",porcentaje(cant_votos(datos_votacion,4),total),"%.")
print("El quinto candidato obtuvo",cant_votos(datos_votacion,5),"votos, corresponden al",porcentaje(cant_votos(datos_votacion,5),total),"%.")

#Ejercicio c
mayor = -1
for i in range(1,6):
    comp = cant_votos(datos_votacion,i)
    if comp>mayor:
        mayor = comp
        cand = i

print("El candidato que obtuvo la mayor votación fue el candidato número",cand,", con un total de",mayor,"votos.")

#Ejercicio d
print("Como ningún candidato obtuvo más del 50% de los votos, los candidatos que pasan a la siguiente vuelta son:")
print("Candidato 1, con un porcentaje de",porcentaje(cant_votos(datos_votacion,1),total),"% del total del los votos.")
print("Candidato 2, con un porcentaje de",porcentaje(cant_votos(datos_votacion,2),total),"% del total del los votos.")