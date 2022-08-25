module rs.chernyshevdv.demo4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens rs.chernyshevdv.demo4 to javafx.fxml;
    exports rs.chernyshevdv.demo4;
}