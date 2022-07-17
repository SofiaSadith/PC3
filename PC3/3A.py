'''
Dados los puntos de control (−1, 1), (1, 1) y (1, 0) de una curva de Bézier:
a) Evaluar PB(t) en t = 1/4 usando el algoritmo de Casteljau

'''

import numpy as np
def Bezier_Cubica_Casteljau(t, p):
    return (1 - t)**2*p[0] + 2*t*(1 - t)*p[1] + t**2*p[2]

P = np.array([[-1,1],[1,1],[1,0]])

t = 0.25

p_t = Bezier_Cubica_Casteljau(t, P)
print("Usando el algoritmo de Casteljau")
print("x(t) =", p_t[0])
print("y(t) =", p_t[1])
