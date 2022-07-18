package Solid.DIP;


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
