public class shippingcalculator {

    public double pesoskg;
    public int Distanciakm;
    public int Tiposervicio;
    public boolean esZonaRemota;

    public double subtotal;
    public double iva;
    public double total;

    public void process(double peso, int distancia, int servicio, boolean remota) {
        // Calcular Base dependiendo de servici0
        if (servicio == 1) {
            this.subtotal = 50;
        } else {
            this.subtotal = 90;
        }

        //  Suma costo por peso
        this.subtotal += (peso * 12);

        // Suma cargo por distancia
        if (distancia <= 50) {
            this.subtotal += 20;
        } else if (distancia <= 200) {
            this.subtotal += 60;
        } else {
            this.subtotal += 120;
        }

        //  Recargo zona remot
        if (remota == true) {
            this.subtotal += (this.subtotal * 0.10);
        }

        // Calcular impuestos y total final
        this.iva = this.subtotal * 0.16;
        this.total = this.subtotal + this.iva;
    }
}
