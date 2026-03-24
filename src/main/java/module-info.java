module com.example.parcticaexamen {
    requires javafx.controls;
    requires javafx.fxml;

    // Abrir el paquete principal
    opens com.example.parcticaexamen to javafx.fxml;
    exports com.example.parcticaexamen;

    // ABRIR CONTROLADORES (Importante para que el FXML funcione)
    opens com.example.parcticaexamen.controllers to javafx.fxml;

    // ABRIR MODELOS (Importante si usas TableView o ListView)
    opens com.example.parcticaexamen.models to javafx.base;
}