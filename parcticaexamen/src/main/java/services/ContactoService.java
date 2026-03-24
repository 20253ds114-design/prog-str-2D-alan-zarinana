package com.example.parcticaexamen.Services;

import com.example.parcticaexamen.models.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactoService {

    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    public ObservableList<Contacto> getContactos() {
        return listaContactos;
    }

    public void agregar(Contacto contacto) {
        listaContactos.add(contacto);
    }

    public void eliminar(Contacto contacto) {
        listaContactos.remove(contacto);
    }

    public Contacto buscarPorNombre(String nombre) {
        return listaContactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}