package com.diego.sejas.flowtest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Province {

    public Province(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    @SerializedName("provincias")
    private List<Province> province;


    public List<Province> getProvince() {
        return province;
    }

    @SerializedName("nombre")
    String nombre;

    @SerializedName("id")
    String id;

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
