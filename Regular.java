public class Regular extends Vuelo {
    private int plazasLibres;

    public Regular(String destino, String avion, int plazas, int plazasLibres) {
        super(destino, avion, plazas);
        this.plazasLibres = plazasLibres;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vuelo Regular\n------------");
        sb.append(super.toString()).append("\nPlazas Libres: ").append(plazasLibres).append("\n");
        return sb.toString();
    }

}