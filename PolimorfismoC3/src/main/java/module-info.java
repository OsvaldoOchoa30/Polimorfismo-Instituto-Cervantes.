module org.osvaldoochoa.polimorfismoc3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.osvaldoochoa.polimorfismoc3 to javafx.fxml;
    exports org.osvaldoochoa.polimorfismoc3;
    exports org.osvaldoochoa.polimorfismoc3.controllers;
    opens org.osvaldoochoa.polimorfismoc3.controllers to javafx.fxml;
}