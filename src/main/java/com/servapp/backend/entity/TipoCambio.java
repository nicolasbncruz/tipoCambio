package com.servapp.backend.entity;

public class TipoCambio {

    private String id;
    private String idDolares;
    private String idEuros;
    private String descripcionDolares;
    private String descripcionEuros;
    private Double tipoCambioDolares;
    private Double tipoCambioEuros;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDolares() {
        return idDolares;
    }

    public void setIdDolares(String idDolares) {
        this.idDolares = idDolares;
    }

    public String getIdEuros() {
        return idEuros;
    }

    public void setIdEuros(String idEuros) {
        this.idEuros = idEuros;
    }

    public String getDescripcionDolares() {
        return descripcionDolares;
    }

    public void setDescripcionDolares(String descripcionDolares) {
        this.descripcionDolares = descripcionDolares;
    }

    public String getDescripcionEuros() {
        return descripcionEuros;
    }

    public void setDescripcionEuros(String descripcionEuros) {
        this.descripcionEuros = descripcionEuros;
    }


    public Double getTipoCambioDolares() {
        return tipoCambioDolares;
    }

    public void setTipoCambioDolares(Double tipoCambioDolares) {
        this.tipoCambioDolares = tipoCambioDolares;
    }

    public Double getTipoCambioEuros() {
        return tipoCambioEuros;
    }

    public void setTipoCambioEuros(Double tipoCambioEuros) {
        this.tipoCambioEuros = tipoCambioEuros;
    }

    @Override
    public String toString() {
        return "TipoCambio{" +
                "idDolares='" + idDolares + '\'' +
                ", idEuros='" + idEuros + '\'' +
                ", descripcionDolares='" + descripcionDolares + '\'' +
                ", descripcionEuros='" + descripcionEuros + '\'' +
                ", tipoCambioDolares=" + tipoCambioDolares +
                ", tipoCambioEuros=" + tipoCambioEuros +
                '}';
    }
}
