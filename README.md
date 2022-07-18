<h1 align="center"> Práctica Califica 3 </h1>

## Principio de responsabilidad única (Sofía Poma)

* **Pregunta 1 Muestra la salida y explica los resultados en función de los métodos entregados**

> ![](src/main/resources/I1.jpeg)


> En principio se tienen 2 clases, la clase Cliente y la clase Estudiante.
>Al momento de ejecutar el código, se llama al “main” que se encuentra en la clase Cliente. Comienza por imprimir que haremos una demostración sin SRP, luego se instancia un objeto de la clase Empleado, llamando a su constructor el cual se le pasará el nombre, apellido y los años de experiencia. Llamamos al método showEmpDetail de la clase Cliente,  al cual le pasamos por parámetro el objeto Empleado instanciado. Este método hace uso del objeto pasado como parámetro llamando al método displayEmpDetail, el cual imprime el nombre, apellido y los años de experiencia del empleado. A continuación imprime el ID del empleado llamando al método generateEmpId de la clase Empleado, al cual se le pasa por parámetro el nombre del empleado con la finalidad de que nos genere el ID del empleado concatenado la primera letra de su nombre con un número entero random menor que 1000 para así pasar a imprimirlo. Después, se imprime el nivel laboral del empleado llamando al método checkSenior de la clase Empleado, al cual se le pasa por parámetro los años de experiencia del empleado con la finalidad de que evalúe que si los años de experiencia son mayores a 5 entonces será de senior, caso contrario será un junior. Continuando con el main, hace un impresión de un separador denotado por simbolos “-”, para luego volver a instanciar otro objeto de tipo Empleado pasándole sus respectivos datos para finalmente volver a llamar al método displayEmpDetail, el cual ya ha sido detallado anteriormente. Concluyendo así la ejecución del programa.

* **Pregunta 2 ¿Cuál es el problema con este diseño y las razones posibles del problema?**

>El problema con este diseño es que viola el principio de responsabilidad única ya que como se puede observar la clase Empleado tiene 3 responsabilidades distintas, el método displayEmpDetail(), el método checkSeniority, el método generateEmpId, cada una de estos métodos tiene diferentes finalidades lo que provoca un alto acoplamiento y una baja cohesión, lo que hace que nuestro diseño sea frágil. Si quisiéramos, por ejemplo, imprimir los detalles del empleado de manera distinta, no podríamos debido a que solo contamos con un método print. Otro problema sería que si quisiéramos testear el método que verifica la experiencia en años del empleado, estamos obligados a testear los otros métodos también. Es por esto que una posible solución es mover este método a una sola clase la cual se encargará de tener todos los métodos de impresión.

* **Pregunta 3 Modifica la clase Empleado. Agrega dos clases SeniorityChecker que contiene el método checkSeniority() y la clase GeneradorIDEmpleado contiene el método generateEmpId(...) para generar la identificación del empleado. Para mejorar la legibilidad del código y evitar torpezas dentro del método main(), utiliza el método estático showEmpDetail(...). Este método llama al método displayEmpDetail() de Empleado, al método generateEmpId() de GeneradorIDEmpleado y al método checkSeniority() de SeniorityChecker. Tú entiendes que este método no era necesario, pero hace que el código del cliente sea simple y fácilmente comprensible.**

>Código de la clase Cliente
>![](src/main/resources/I2.jpeg)

>Código de la clase Empleado
>![](src/main/resources/I3.jpeg)

>Código de la clase GeneradoIDEmpleado
>![](src/main/resources/I4.jpeg)

>Código de la clase SeniorityChecker
>![](src/main/resources/I11.jpeg)

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

* **Pregunta 8 Debes abordar el método de evaluación para la distinción de una mejor manera. Por lo tanto, crea la interfaz DistinctionDecider que contiene un método llamado EvaluationDistinction.**

![](src/main/resources/I8.jpeg)

* **Pregunta 9 Completa el código de ArtsDistinctionDecider y ScienceDistinctionDecider que implementan esta interfaz y sobreescriben el método de evaluateDistinction(...) para especificar los criterios de evaluación según sus necesidades. De esta forma, los criterios de distinción específicos de flujo se envuelven en una unidad independiente. Debes tener en cuenta que el método de evaluateDistinction(...) acepta un parámetro Estudiante. Significa que ahora también puede pasar un objeto ArtsStudent o un objeto ScienceStudent a este método. El código restante es fácil y no debería tener ningún problema para comprender la siguiente demostración ahora.**
>Código de la clase ArtsDistinctionDecider:
>![](src/main/resources/I9.jpeg)

>Código de la clase ScienceDistinctionDecider:
>![](src/main/resources/I10.jpeg)

* **Pregunta 10 Realiza una demostración completa que sigue a OCP. Explica tus resultados.**

    **Estudiante.java**

    **ArteEstudiante.java**

    **CienciaEstudiante.java**

    **DistinctionDecider.java**

    **ScienceDistinctionDecider.java**

    **ArtsDistinctionDecider.java**

    **Cliente.java**

>![](src/main/resources/I12.jpeg)
>![](src/main/resources/I13.jpeg)
>![](src/main/resources/I14.jpeg)
>![](src/main/resources/I15.jpeg)
>


## Pregunta 25
Reemplaza el segmento de código con una expresión lambda adecuada. Tú eliges cuál quieres usar.

```java
class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion sin ISP");
        List<Impresora> impresoras = new ArrayList<Impresora>();
        impresoras.add(new ImpresoraAvanzada());
        impresoras.add(new ImpresoraBasica());
        impresoras.forEach((dispositivo)->{
            dispositivo.printDocument();
            dispositivo.sendFax();
        });

    }

}
```

## Pregunta 26
Muestra la salida y explica los resultados en función de los métodos entregados.

Salida:

>![](src/main/resources/cap25.jpg)

La impresora avanzada cumple ambas funcionalidades correctamente.
Mientras la impresora basica solo imprime documentos pero no puede enviar fax porque
el método sendFax() de ImpresoraBasica está desarrollado para que lance una excepcion
en tiempo de ejecución.

## Pregunta 27
Para terminar esta pregunta, en la sección de SOLID del código entregado, completa los
siguientes archivos. No olvides explicar tus resultados.

Impresora.java:
```java
interface Impresora {
    void printDocument();
}
```
DispositivoFax.java:
```java
interface DispositivoFax {
   void sendFax();
}
```
ImpresoraBasica.java:
```java
public class ImpresoraBasica implements Impresora{
    @Override
    public void printDocument() {
        System.out.println("La impresora básica imprime un documento.");
    }
}
```
ImpresoraAvanzada.java:
```java
public class ImpresoraAvanzada implements Impresora, DispositivoFax{
    @Override
    public void printDocument() {
        System.out.println("La impresora avanzada imprime un documento.");
    }

    @Override
    public void sendFax() {
        System.out.println("La impresora avanzada envía un fax.");
    }
}
```
Cliente.java:
```java
public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion ISP");

        Impresora impresora = new ImpresoraBasica();
        impresora.printDocument();
        impresora = new ImpresoraAvanzada();
        impresora.printDocument();

        DispositivoFax fax = new ImpresoraAvanzada();
        fax.sendFax();

    }
}
```
Salida:

>![](src/main/resources/cap26.jpg)

Esta nueva implementacion de las dos impresoras a partir de dos
interfaces separadas (DispositivoFax e Impresora) permiten que
las clases ImpresoraAvanzada e ImpresoraBasica solo implementen
los metodos que realmente usan (ISP).

## Pregunta 28
¿Qué sucede si usa un método predeterminado dentro de la interfaz?

Las clases que implementen este método no tendrian necesidad de
desarrollarla, solo la sobreescribirian si necesitan modificarla para un uso
especifico.

## Pregunta 29
¿Qué sucede si proporcionas un método de fax predeterminado en una interfaz?.

La clase ImpresoraAvanzada podría implementar la funcion sendFax, sin necesidad
de desarrollarla.

El problema es que hay veces que vas a querer implementar una interfaz
en una clase que estés desarrollando, pero estarías implementando
métodos que tal vez no necesita tu clase.

## Pregunta 30
¿Qué sucede si usa un método vacío, en lugar de lanzar la excepción?

ImpresoraBasica.java:
```java
class ImpresoraBasica implements Impresora {
    @Override
    public void printDocument() {
        System.out.println("La impresora basica imprime un documento.");
    }

    @Override
    public void sendFax() {
        //throw new UnsupportedOperationException();
    }
}
```
Salida:

>![](src/main/resources/cap30.jpg)

Vemos que se ejecuta sin errores.

## Pregunta 31
Salida:

>![](src/main/resources/cap31.jpg)

Esta salida se debe a que el cliente hace uso del método
saveEmployeeId() de interfazUsuario.java que a su vez invoca
al método saveEmpIdInDatabase() de OracleDatabase.java para poder guardar datos
de empleados en la BD.

## Pregunta 32
El programa es simple, pero ¿qué tipo de problemas presenta?

Este programa viola el principio de Inversion de Dependencia(DIP),
pues una clase concreta de alto nivel (InterfazUsuario) no debe
depender de una clase concreta de bajo nivel (OracleDatabase).

El código que viola este principio puede acoplarse demasiado,
y eso hace que el código sea difícil de mantener, ilegible, incluso
más difícil de probar.

También viola el principio de Abierto-Cerrado(OCP) porque
si el cliente quiere usar otro tipo de BD se tendria que
modificar la clase OracleDatabase o crear otra.

De esta forma, el programa se convierte en un programa frágil,
impredecible y no reutilizable.

## Pregunta 33
InterfazUsuario.java
```java
class InterfazUsuario {
    private BaseDatos bd;

    public InterfazUsuario(BaseDatos bd) {
        this.bd = bd;
    }
    public void saveEmployeeId(String empId) {
        bd.saveEmpIdInDatabase(empId);
    }
}
```
## Pregunta 34
Completa todos los archivos siguientes de la sección SOLID:

BaseDatos.java
```java
interface BaseDatos {
    public void saveEmpIdInDatabase(String empId);
}
```
OracleDatabase.java
```java
class OracleDatabase implements BaseDatos {
    public void saveEmpIdInDatabase(String empId) {
        System.out.println("El id: " + empId + " es guardado en la base de datos Oracle.");
    }
}
```
MySQLDatabase.java
```java
class MySQLDatabase implements BaseDatos {
    public void saveEmpIdInDatabase(String empId) {
        System.out.println("El id: " + empId + " es guardado en la base de datos MySQL.");
    }
}
```
Cliente.java
```java
public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion con DIP");
        InterfazUsuario usuario;
        // Usando Oracle
        usuario = new InterfazUsuario(new OracleDatabase());
        usuario.saveEmployeeId("E001");

        // Usando Mysql
        usuario = new InterfazUsuario(new MySQLDatabase());
        usuario.saveEmployeeId("E001");

        // Cambiando la base de datos objetivo
        //usuario = new InterfazUsuario(new OracleDatabase());

    }
}
```
Explica los resultados. ¿El programa resuelve todos los posibles problemas del programa que
no usa DIP?

>![](src/main/resources/cap34.jpg)

Sí los resuelve, pues ahora el cliente puede registrar usuarios en distintas
BD, gracias a que tanto el módulo de alto nivel (InterfazUsuario)
y los módulos de bajo nivel (MySQLDatabase, OracleDatabase) dependen de la
abstraccion BaseDatos (Principio DIP).

Lo que permite implementar nuevas clases de base de datos
en el código sin modificar las ya existentes (Principo OCP).

De esta manera, se ha reducido el alto acoplamiento que habia
al principio, lo que hace que el código sea más entendible, testeable
y reutilizable.

## Pregunta 35

## Pregunta 36
El constructor de la clase InterfazUsuario acepta un parámetro de base de datos.
Proporciona una instalación adicional a un usuario cuando utiliza tanto el constructor como el
método setter (setDatabase) dentro de esta clase. ¿Cuál es el beneficio?.

```java
class InterfazUsuario {
    private BaseDatos bd;

    public InterfazUsuario(BaseDatos bd) {
        this.bd = bd;
    }
    public void saveEmployeeId(String empId) {
        bd.saveEmpIdInDatabase(empId);
    }
    public void setBd(BaseDatos bd) {
        this.bd = bd;
    }
}
```
El beneficio es que este método nos permite que una
vez inicializada la variable usuario de tipo InterfazUsuario
podemos modificar el tipo de BD que queremos utilizar sin necesidad
de instanciar la variable de nuevo.

```java
public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion con DIP");
        InterfazUsuario usuario;
        // Usando Oracle
        usuario = new InterfazUsuario(new OracleDatabase());
        usuario.saveEmployeeId("E001");

        // Usando Mysql
        usuario = new InterfazUsuario(new MySQLDatabase());
        usuario.saveEmployeeId("E001");

        // Cambiando la base de datos objetivo
        usuario.setBd(new OracleDatabase());
        usuario.saveEmployeeId("E001");

    }
}
```