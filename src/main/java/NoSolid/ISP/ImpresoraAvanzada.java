package NoSolid.ISP;

public class ImpresoraAvanzada implements Impresora {
    @Override
    public void printDocument() {
        System.out.println("La impresora avanzada imprime un documento.");
    }

    @Override
    public void sendFax(Fax fax) {
        fax.varFax();
        System.out.println("La impresora avanzada envía un fax.");

    }
}
