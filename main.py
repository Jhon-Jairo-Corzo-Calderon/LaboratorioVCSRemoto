import math 

print("""Bienvenido usuario, para resolver la ecuacion cuadratica, primero ingrese el
valor del numero que acompaña a la  elevada al cuadrado, luego el que acompaña a la 
x y por último ingrese el numero sin la x.""")

a=int(input("1."))
b=int(input("2."))
c=int(input("3."))

d = b**2 - (4*a*c)

if d > 0:
    x1 = (-b+math.sqrt(d))/2*a
    x2 = (-b-math.sqrt(d))/2*a
    print("X vale 0 cuando toma el valor de",x1,"y ",x2,)
elif d < 0:
    print("No existe solución a la ecuación cuadrática dentro del dominio de los números reales.")
else:
    x = -b/2*a
    print("X vale 0 cuando toma el valor de",x,)
