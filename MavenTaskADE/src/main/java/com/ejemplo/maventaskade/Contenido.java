package com.ejemplo.maventaskade;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contenido implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String descripcion;
    private String categoria;
    private String creador;
    private int año_publicacion;
    private int clasificacion_edad;

    // Constructor sin parámetros (necesario para JAXB)
    public Contenido() {
    }

    public Contenido(String titulo, String descripcion, String categoria, String creador, int año_publicacion, int clasificacion_edad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.creador = creador;
        this.año_publicacion = año_publicacion;
        this.clasificacion_edad = clasificacion_edad;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @XmlElement(name = "titulo")
    public String getTitulo() {
        return titulo;
    }

    @XmlElement(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    @XmlElement(name = "categoria")
    public String getCategoria() {
        return categoria;
    }

    @XmlElement(name = "creador")
    public String getCreador() {
        return creador;
    }

    @XmlElement(name = "año_publicacion")
    public int getAño_publicacion() {
        return año_publicacion;
    }

    @XmlElement(name = "clasificacion_edad")
    public int getClasificacion_edad() {
        return clasificacion_edad;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setAño_publicacion(int año_publicacion) {
        this.año_publicacion = año_publicacion;
    }

    public void setClasificacion_edad(int clasificacion_edad) {
        this.clasificacion_edad = clasificacion_edad;
    }

}
