import numpy as np

def generador(min,max):
    array = np.random.randint(min,max,size=48).reshape(4,12)
    return array