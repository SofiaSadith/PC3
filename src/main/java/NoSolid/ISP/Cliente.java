package NoSolid.ISP;

// import java.util.ArrayList;
// import java.util.List;

class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion sin ISP");
        Impresora impresora = new ImpresoraAvanzada();
        impresora.printDocument();
        Fax analogFax = new AnalogFax();
        impresora.sendFax(analogFax);

        impresora = new ImpresoraBasica();
        impresora.printDocument();
        //impresora.sendFax();// Lanza un error
    }

}
