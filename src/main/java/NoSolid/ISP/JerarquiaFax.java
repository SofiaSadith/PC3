package NoSolid.ISP;


interface  Fax {
    void varFax();
}

class LanFax implements Fax{
    @Override
    public void varFax(){
        System.out.println("Fax de tipo LanFax");
    }
}

class EFax implements Fax{
    @Override
    public void varFax(){
        System.out.println("Fax de tipo EFax");
    }
}

class AnalogFax implements Fax{
    @Override
    public void varFax() {
        System.out.println("Fax de tipo AnalogFax");
    }
}