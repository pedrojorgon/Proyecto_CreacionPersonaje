package Modelo.Objetos;

import java.time.LocalDate;

public class Personaje {

    private int id_usuario;
    private int id_personaje;
    private String nombre;
    private LocalDate fecha_creacion;
    private int idCasco;
    private int idPecho;
    private int idPiernas;

    public Personaje(int id_usuario, int id_personaje, String nombre, LocalDate fecha_creacion, int idCasco, int idPecho, int idPiernas) {
        this.id_usuario = id_usuario;
        this.id_personaje = id_personaje;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.idCasco = idCasco;
        this.idPecho = idPecho;
        this.idPiernas = idPiernas;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
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
