package com.example.parcticaexamen.controllers;

import com.example.parcticaexamen.Services.ContactoService;
import com.example.parcticaexamen.models.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppController {


    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cbParentesco;
    @FXML private ListView<Contacto> lvContactos;

    private ContactoService service = new ContactoService();


    private String[] opcionesParentesco = {
            "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {

        cbParentesco.getItems().addAll(opcionesParentesco);


        lvContactos.setItems(service.getContactos());
    }

    @FXML
    void btnAgregarClick() {
        if (validarDatos()) {

            if (service.buscarPorNombre(txtNombre.getText()) != null) {
                mostrarAlerta("Error", "Ya existe un contacto con ese nombre.");
                return;
            }

            Contacto nuevo = new Contacto(
                    txtNombre.getText().trim(),
                    txtTelefono.getText().trim(),
                    cbParentesco.getValue()
            );

            service.agregar(nuevo);
            limpiar();
            mostrarAlerta("Éxito", "Contacto agregado correctamente.");
        }
    }

    @FXML
    void btnBuscarClick() {
        String nombreABuscar = txtNombre.getText().trim();
        Contacto encontrado = service.buscarPorNombre(nombreABuscar);

        if (encontrado != null) {
            txtTelefono.setText(encontrado.getTelefono());
            cbParentesco.setValue(encontrado.getParentesco());
        } else {
            mostrarAlerta("Búsqueda", "No se encontró ningún contacto con ese nombre.");
        }
    }

    @FXML
    void btnActualizarClick() {
        Contacto contactoExistente = service.buscarPorNombre(txtNombre.getText());

        if (contactoExistente != null) {
            if (validarDatos()) {
                contactoExistente.setTelefono(txtTelefono.getText());
                contactoExistente.setParentesco(cbParentesco.getValue());
                lvContactos.refresh(); // Actualiza la vista
                mostrarAlerta("Éxito", "Contacto actualizado.");
            }
        } else {
            mostrarAlerta("Error", "Busca un contacto existente para actualizar.");
        }
    }

    @FXML
    void btnEliminarClick() {
        Contacto contactoAEliminar = service.buscarPorNombre(txtNombre.getText());

        if (contactoAEliminar != null) {
            service.eliminar(contactoAEliminar);
            limpiar();
            mostrarAlerta("Éxito", "Contacto eliminado.");
        } else {
            mostrarAlerta("Error", "No se encontró el contacto para eliminar.");
        }
    }

    @FXML
    void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }



    private boolean validarDatos() {
        String nombre = txtNombre.getText().trim();
        String tel = txtTelefono.getText().trim();
        String par = cbParentesco.getValue();

        if (nombre.isEmpty() || tel.isEmpty() || par == null) {
            mostrarAlerta("Validación", "Todos los campos son obligatorios.");
            return false;
        }


        if (tel.length() != 10 || !tel.matches("\\d+")) {
            mostrarAlerta("Validación", "El teléfono debe tener exactamente 10 números.");
            return false;
        }

        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}