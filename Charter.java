public class Charter extends Vuelo{
    private String NIF;

    public Charter(String destino, String avion, int plazas, String NIF) {
        super(destino, avion, plazas);
        this.NIF = NIF;
    }


    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vuelo Charter\n------------");
        sb.append(super.toString()).append("NIF Empresa: ").append(NIF);
        return sb.toString();
    }
}