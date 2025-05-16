package Modelo.Objetos;

import java.time.LocalDate;

public class Personaje {

    private int id_usuario;
    private int id_personaje;
    private String nombre;
    private LocalDate fecha_creacion;
    private int id_casco;
    private int id_pecho;
    private int id_piernas;

    public Personaje(int id_usuario, int id_personaje, String nombre, LocalDate fecha_creacion, int idCasco, int idPecho, int idPiernas) {
        this.id_usuario = id_usuario;
        this.id_personaje = id_personaje;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.id_casco = idCasco;
        this.id_pecho = idPecho;
        this.id_piernas = idPiernas;
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

    public int getId_casco() {
        return id_casco;
    }

    public void setId_casco(int id_casco) {
        this.id_casco = id_casco;
    }

    public int getId_pecho() {
        return id_pecho;
    }

    public void setId_pecho(int id_pecho) {
        this.id_pecho = id_pecho;
    }

    public int getId_piernas() {
        return id_piernas;
    }

    public void setId_piernas(int id_piernas) {
        this.id_piernas = id_piernas;
    }
}
