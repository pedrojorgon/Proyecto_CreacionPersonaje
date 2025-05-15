package Modelo.Objetos;

public class Personaje {

    private int id;
    private String nombre;
    private int idCasco;
    private int idPecho;
    private int idPiernas;

    public Personaje(int id, String nombre, int idCasco, int idPecho, int idPiernas) {
        this.id = id;
        this.nombre = nombre;
        this.idCasco = idCasco;
        this.idPecho = idPecho;
        this.idPiernas = idPiernas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCasco() {
        return idCasco;
    }

    public void setIdCasco(int idCasco) {
        this.idCasco = idCasco;
    }

    public int getIdPecho() {
        return idPecho;
    }

    public void setIdPecho(int idPecho) {
        this.idPecho = idPecho;
    }

    public int getIdPiernas() {
        return idPiernas;
    }

    public void setIdPiernas(int idPiernas) {
        this.idPiernas = idPiernas;
    }
}
