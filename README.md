<h1 align="center"> Práctica Califica 3 </h1>

## Principio de responsabilidad única

* **Pregunta 1 Muestra la salida y explica los resultados en función de los métodos entregados**

![](src/main/resources/I1.jpeg)


> En principio se tienen 2 clases, la clase Cliente y la clase Estudiante.
>Al momento de ejecutar el código, se llama al “main” que se encuentra en la clase Cliente. Comienza por imprimir que haremos una demostración sin SRP, luego se instancia un objeto de la clase Empleado, llamando a su constructor el cual se le pasará el nombre, apellido y los años de experiencia. Llamamos al método showEmpDetail de la clase Cliente,  al cual le pasamos por parámetro el objeto Empleado instanciado. Este método hace uso del objeto pasado como parámetro llamando al método displayEmpDetail, el cual imprime el nombre, apellido y los años de experiencia del empleado. A continuación imprime el ID del empleado llamando al método generateEmpId de la clase Empleado, al cual se le pasa por parámetro el nombre del empleado con la finalidad de que nos genere el ID del empleado concatenado la primera letra de su nombre con un número entero random menor que 1000 para así pasar a imprimirlo. Después, se imprime el nivel laboral del empleado llamando al método checkSenior de la clase Empleado, al cual se le pasa por parámetro los años de experiencia del empleado con la finalidad de que evalúe que si los años de experiencia son mayores a 5 entonces será de senior, caso contrario será un junior. Continuando con el main, hace un impresión de un separador denotado por simbolos “-”, para luego volver a instanciar otro objeto de tipo Empleado pasándole sus respectivos datos para finalmente volver a llamar al método displayEmpDetail, el cual ya ha sido detallado anteriormente. Concluyendo así la ejecución del programa.

