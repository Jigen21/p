package com.example.axelh.tpposta;

public class Noticia
{

    private String titulo;
    private String descripcion;
    private String linkimagen;
    private String linkpagina;

    public String getLinkpagina() {
        return linkpagina;
    }

    public void setLinkpagina(String linkpagina) {
        this.linkpagina = linkpagina;
    }

    private byte[] datosimagen;

    public byte[] getDatosimagen() {
        return datosimagen;
    }

    public void setDatosimagen(byte[] datosimagen) {
        this.datosimagen = datosimagen;
    }

    private String fecha;

    public Noticia()
    {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinkimagen() {
        return linkimagen;
    }

    public void setLinkimagen(String linkimagen) {
        this.linkimagen = linkimagen;
    }



    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
