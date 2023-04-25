import java.util.*;

public class Aeropuerto {

    private Map<String, Set<Vuelo>> vuelos;

    public Aeropuerto() {
        vuelos = new HashMap<>();
    }

    /**
     * A�ade un vuelo a la aerolinea correspondiente solo en el caso de que el vuelo
     * no estuviese ya introducido, si la aerolinea no existiese se a�ade tanto la
     * aerolinea como el vuelo.
     */
    public void addVuelo(String aerolinea, Vuelo vuelo) {
        Set<Vuelo> v;

        if (vuelos.containsKey(aerolinea)) {
            vuelos.get(aerolinea).add(vuelo);
        } else {
            v = new TreeSet<>();
            vuelos.put(aerolinea, v);
        }
    }

    /**
     * Imprime los vuelos por cada aerolinea ordenados por destino, tanto aerolineas
     * como vuelos estaran ordenados alfabeticamente (Ver resultados de ejecucion)
     */
    public void ordenAerolineasAlfabetico() {
        StringBuilder sb = new StringBuilder();
        if (!vuelos.isEmpty()) {
            for (Map.Entry<String, Set<Vuelo>> v : vuelos.entrySet()) {
                System.out.println(v.getKey());
            }
        }

    }

    /**
     * Muestra los vuelos regulares de la aerolinea pasada por parametro, se
     * visualizaran de mayor a menor segun el numero de plazas
     *
     * @param aerolinea Aerolinea de la que se imprimiran los vuelos regulares
     */
    public void regularPorPlazas(String aerolinea) {
        Set<Regular> ordenar = new TreeSet<>(new Comparator<Regular>() {
            @Override
            public int compare(Regular o1, Regular o2) {
                return o2.getPlazasLibres() - o1.getPlazasLibres();
            }
        });

        for (Vuelo v : vuelos.get(aerolinea)) {
            if (v instanceof Regular r) {
                ordenar.add(r);
            }
        }

        for (Regular r : ordenar) {
            System.out.println(r.toString());
        }
    }

    /**
     * Devuelve una lista con vuelos regulares con plazas libres
     */
    public List<Vuelo> plazasLibres() {
        return null;
    }

    /**
     * Muestra el numero de vuelos de cada aerolinea que llegan al destino pasado
     * por parametro, ver resultados de ejecucion
     *
     * @param destino Destino del que se debe sacar la estadistica
     */
    public void estadisticaDestino(String destino) {

    }

    /**
     * Borra los vuelos reservados por una empresa y devuelve el numero de vuelos
     * borrados, utiliza un conjunto de entradas
     *
     * @param nifEmpresa
     * @return numero de vuelos borrados
     */
    public int borrarVuelosEmpresa(String nifEmpresa) {
        return 0;
    }

    /**
     * Imprime la lista de vuelos pasada por parametro
     *
     * @param listaVuelos
     */
    public void imprimirListaVuelos(List<Vuelo> listaVuelos) {
        System.out.println(listaString(listaVuelos));
    }

    /**
     * Represetaci�n textual del mapa tal y como se muestra en el enunciado
     */
    private String listaString(List<Vuelo> listaVuelos) {
        StringBuilder sb = new StringBuilder();
        for (Vuelo v : listaVuelos) {
            if (v instanceof Regular r) {
                sb.append(r);
            } else if (v instanceof Charter c) {
                sb.append(c);
            } else {
                sb.append(v.toString());
            }
        }
        return sb.toString();
    }

    /**
     * Rellena el mapa haciendo uso de un fichero de texto
     */
    public void leerFicheroCursos() {
        Scanner entrada = null;
        try {
            entrada = new Scanner(Objects.requireNonNull(this.getClass().getResourceAsStream("/aviones.txt")));
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                int pos = linea.indexOf(":");
                String aerolinea = linea.substring(0, pos);
                String[] vuelo = linea.substring(pos + 1).split(":");
                String destino = vuelo[1];
                String avion = vuelo[2];
                int plazas = Integer.parseInt(vuelo[3].trim());
                if (vuelo[0].equals("R")) {
                    int plazasLibres = Integer.parseInt(vuelo[4].trim());
                    this.addVuelo(aerolinea, new Regular(destino, avion, plazas, plazasLibres));
                } else {
                    String nifEmpresa = vuelo[4];
                    this.addVuelo(aerolinea, new Charter(destino, avion, plazas, nifEmpresa));
                }
            }

        } finally {
            try {
                entrada.close();
            } catch (NullPointerException e) {
                System.out.println("Error en IO , no se ha creado el fichero");
            }
        }

    }

}
