package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.w3c.dom.html.HTMLBodyElement;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Label lblMsg;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEdad;


    // Se mantiene como final para proteger la referencia de la lista observable
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    /**
     * El método initialize se ejecuta automáticamente después de que el FXML
     * ha sido cargado y los elementos @FXML han sido inyectados.
     */
    @FXML
    public void initialize() {
        // Vincula la lista de datos con el componente visual ListView
        if (listView != null) {
            listView.setItems(data);
        }

        // Carga los datos iniciales al arrancar la aplicación
        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener( (obs, oldValue, newValue) -> {
                    loadDataToForm(newValue); //String con el valor del row 0 test-email@gmail.com-18
                }
        );
    }

    @FXML
    public void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            service.addPerson(name, email, edad);

            lblMsg.setText("Usuario creado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");

            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();

            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe ser un número");
            lblMsg.setStyle("-fx-text-fill: red");

        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        } catch (IllegalArgumentException e) {
            lblMsg.setText("Hubo un error con los datos " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String name= txtName.getText();
        String email= txtEmail.getText();
        String edad= txtEdad.getText();
        try{
            service.updatePerson(index, name, email, edad);
            loadFromFile();
            lblMsg.setText("Persona actualizada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();

        } catch (IOException e ) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }



    @FXML
    private void loadFromFile() {
        try {
            // Obtenemos la lista desde el servicio
            List<String> items = service.loadDataforList();

            // Actualizamos la lista observable (esto refresca el ListView automáticamente)
            if (items != null) {
                data.setAll(items);
            }


            if (lblMsg != null) {
                lblMsg.setText("Datos cargados exitosamente");
                lblMsg.setStyle("-fx-text-fill: green;");
            }

        } catch (IOException e) {
            // Manejo de error si el archivo no existe o no se puede leer
            if (lblMsg != null) {
                lblMsg.setText("Error: " + e.getMessage());
                lblMsg.setStyle("-fx-text-fill: red;");
            }

            // Imprimir el error en consola para depuración
            e.printStackTrace();
        }
    }

    private void loadDataToForm(String item){
        String[] parts = item.split("-");
        txtName.setText(parts[0]); //Corresponde a la parte del nombre
        txtEmail.setText(parts[1]); //Corresponde a la parte del email
        txtEdad.setText(parts[2]);  //Corresponde a la parte de la edad
    }


}