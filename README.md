<h1 align="center"> Práctica Califica 3 </h1>

## Principio de responsabilidad única (Sofía Poma)

* **Pregunta 1 Muestra la salida y explica los resultados en función de los métodos entregados**

> ![](src/main/resources/I1.jpeg)


> En principio se tienen 2 clases, la clase Cliente y la clase Estudiante.
>Al momento de ejecutar el código, se llama al “main” que se encuentra en la clase Cliente. Comienza por imprimir que haremos una demostración sin SRP, luego se instancia un objeto de la clase Empleado, llamando a su constructor el cual se le pasará el nombre, apellido y los años de experiencia. Llamamos al método showEmpDetail de la clase Cliente,  al cual le pasamos por parámetro el objeto Empleado instanciado. Este método hace uso del objeto pasado como parámetro llamando al método displayEmpDetail, el cual imprime el nombre, apellido y los años de experiencia del empleado. A continuación imprime el ID del empleado llamando al método generateEmpId de la clase Empleado, al cual se le pasa por parámetro el nombre del empleado con la finalidad de que nos genere el ID del empleado concatenado la primera letra de su nombre con un número entero random menor que 1000 para así pasar a imprimirlo. Después, se imprime el nivel laboral del empleado llamando al método checkSenior de la clase Empleado, al cual se le pasa por parámetro los años de experiencia del empleado con la finalidad de que evalúe que si los años de experiencia son mayores a 5 entonces será de senior, caso contrario será un junior. Continuando con el main, hace un impresión de un separador denotado por simbolos “-”, para luego volver a instanciar otro objeto de tipo Empleado pasándole sus respectivos datos para finalmente volver a llamar al método displayEmpDetail, el cual ya ha sido detallado anteriormente. Concluyendo así la ejecución del programa.

* **Pregunta 2 ¿Cuál es el problema con este diseño y las razones posibles del problema?**

>El problema con este diseño es que viola el principio de responsabilidad única ya que como se puede observar la clase Empleado tiene 3 responsabilidades distintas, el método displayEmpDetail(), el método checkSeniority, el método generateEmpId, cada una de estos métodos tiene diferentes finalidades lo que provoca un alto acoplamiento y una baja cohesión, lo que hace que nuestro diseño sea frágil. Si quisiéramos, por ejemplo, imprimir los detalles del empleado de manera distinta, no podríamos debido a que solo contamos con un método print. Otro problema sería que si quisiéramos testear el método que verifica la experiencia en años del empleado, estamos obligados a testear los otros métodos también. Es por esto que una posible solución es mover este método a una sola clase la cual se encargará de tener todos los métodos de impresión.

* **Pregunta 3 Modifica la clase Empleado. Agrega dos clases SeniorityChecker que contiene el método checkSeniority() y la clase GeneradorIDEmpleado contiene el método generateEmpId(...) para generar la identificación del empleado. Para mejorar la legibilidad del código y evitar torpezas dentro del método main(), utiliza el método estático showEmpDetail(...). Este método llama al método displayEmpDetail() de Empleado, al método generateEmpId() de GeneradorIDEmpleado y al método checkSeniority() de SeniorityChecker. Tú entiendes que este método no era necesario, pero hace que el código del cliente sea simple y fácilmente comprensible.**


>![](src/main/resources/I2.jpeg)


>![](src/main/resources/I3.jpeg)


>![](src/main/resources/I4.jpeg)

* **Pregunta 4 Realiza una demostración completa que sigue a SRP. Explica tus resultados**
        Empleado.java

        GeneradorIdEmpleado.java

        SeniorityChecker.java

        Cliente.java

>![](src/main/resources/I5.jpeg)

>La clase Cliente tiene el método main en el cuál se instancia un objeto de la clase Empleado y se llama al método showEmpDetail()
>La clase Empleado tiene al método displayEmpDetail() el cual nos mostrará el nombre y el tiempo de experiencia del empleado.
>La clase SeniorityChecker, tiene el método checkSeniority el cuál haciendo uso del atributo experienceInYears evaluará si los años de experiencia del empleado son suficientes para considerarlo junior o senior, será considerado senior si los años de experiencia son mayores a 5 años.
>La clase GeneradorIdEmpleado tiene el método generateEmpId nos generará aleatoriamente el Id del empleado concatenando la primera letra de su nombre con un número aleatorio entre 1000 números enteros.



## Principio abierto/cerrado (Bruno Cipriano)
* **Pregunta 5 ¿Por que no es correcto colocar displayResult() y evaluateDistinction() en la misma clase, como la siguiente:**

    class Estudiante {

        // ....

        public void displayResult() {

        // codigo

        }

        public void evaluateDistinction() {

        // codigo

        }

        // ...

    }

**Sean los siguientes archivos:**

Estudiante.java

DistinctionDecider.java

Cliente.java

>En el caso de que hubiera modificaciones o se quisiera extender los requerimientos, la clase Estudiante se vería siempre expuesta a modificaciones. Por ejemplo, aumentar más tipos de departamentos de los que hay, pues solo necesitamos modificar la lista de departamentos, ya que el método evaluateDistiction hace uso de ella, pero al estar todo en la misma clase Estudiante, esta sería la más expuesta aunque no se quisiera cambiar nada del método displayResult violando así el principio Open/Closed.
>En el caso del testing, al tener estas clases separadas, nos ayudará a no tener que modificar sus respectivos tests cada vez que se mejore o amplíe dicho código. Además, al tener 2 métodos que hacen cosas muy diferentes en una sola clase, estaría violando el principio de responsabilidad única.

* **Pregunta 6 Muestra la salida y explica los resultados en función de los métodos entregados**

>En principio se llama al método enrollStudents() la cual tiene como propósito instanciar objetos de tipo Estudiante, definiendo su nombre, código de registro y calificación. Luego estas instancias las almacena en un lista la cual al final retorna.

>Para imprimir los resultados se hace uso de un bucle “for” el cual recorre cada uno de los elementos de la lista  Estudiantes para  luego “imprimirlos”. El software sabe como imprimir este objeto debido a que la clase Estudiante cuenta con el método sobrescrito “toString()” el cual retorna la manera en que se debe mostrar en pantalla los atributos o datos de dicho objeto.

>El método evaluateDistinction  evaluará primero al tipo de departamento al que pertenece el estudiante y de acuerdo a eso procederá a evaluar si el estudiante tiene el puntaje suficiente para recibir una distinción en el tipo de departamento al que pertenece, en el caso que pertenezca al departamento de Ciencias necesitará tener un puntaje mayor a 80 si desea recibir una distinción; si pertenece al departamento de Arte, necesitará tener un puntaje mayor a 70.

>![](src/main/resources/I6.jpeg)

>![](src/main/resources/I7.jpeg)

* **Pregunta 7 ¿Cuál es el problema con este diseño y las razones posibles del problema?**

>El problema con este diseño es que si se quiere agregar otra corriente, por ejemplo Ingeniería, se tendría que modificar la clase DistinctionDecider, agregando más condicionales lo que ocasiona un alto acoplamiento. Otro problema ocurrirá si es que se quisiera implementar nuevos métodos para los estudiantes de algún departamento en particular en ese caso nos veríamos en la necesidad de modificar la clase Estudiante, lo cuál demuestra que nuestro código es abierto a extensiones pero por otro lado dichos cambios afectarian al código base ya escrito por lo tanto sería vulnerable a modificaciones y no cumpliría el Principio de abierto y cerrado.
