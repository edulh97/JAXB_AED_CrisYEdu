package com.ejemplo.maventaskade;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "plataforma_streaming")
public class ContenidoWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Contenido> contenidos;

    public ContenidoWrapper() {
    }

    public ContenidoWrapper(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    @XmlElement(name = "contenido")
    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }
}
