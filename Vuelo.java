import java.util.Objects;

public abstract class Vuelo implements Comparable<Vuelo>{

    private String destino;
    private String avion;
    private int plazas;

    public Vuelo(String destino, String avion, int plazas) {
        this.destino = destino;
        this.avion = avion;
        this.plazas = plazas;
    }

    public String getDestino() {
        return destino;
    }

    public Vuelo setDestino(String destino) {
        this.destino = destino;
        return this;
    }

    public String getAvion() {
        return avion;
    }

    public Vuelo setAvion(String avion) {
        this.avion = avion;
        return this;
    }

    public int getPlazas() {
        return plazas;
    }

    public Vuelo setPlazas(int plazas) {
        this.plazas = plazas;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nDestino: ").append(destino);
        sb.append("\nAvion: ").append(avion);
        sb.append("\nPlazas: ").append(plazas);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vuelo vuelo = (Vuelo) o;

        return plazas == vuelo.plazas && destino.equals(vuelo.destino);
    }

    @Override
    public int hashCode() {
        int result = destino != null ? destino.hashCode() : 0;
        result = 31 * result + (avion != null ? avion.hashCode() : 0);
        result = 31 * result + plazas;
        return result;
    }
    public int compareTo(Vuelo o) {
        return destino.compareTo(o.destino);
    }

}