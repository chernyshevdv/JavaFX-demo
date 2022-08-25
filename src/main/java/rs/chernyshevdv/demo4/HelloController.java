package rs.chernyshevdv.demo4;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText, statusLabel;

    @FXML
    private TableView<Task> tasksTable;
    @FXML
    private TableColumn titleColumn, statusColumn, isDoneColumn;

    @FXML
    private TextField newTitle, newStatus;

    private ObservableList<Task> data;

    public HelloController(ObservableList<Task> data){
        this.data = data;
    }

    @FXML
    protected void addButtonAction() {
        String newTaskTitle = newTitle.getText();
        Task task = new Task(newTaskTitle, newStatus.getText(), false);
        data.add(task);
        statusLabel.setText(String.format("Task [%s] added", newTaskTitle));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tasksTable.setEditable(true);
        // title column
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setCellFactory(TextFieldTableCell.<Task>forTableColumn());
        titleColumn.setOnEditCommit((Event e) -> {
            TableColumn.CellEditEvent<Task, String> t = (TableColumn.CellEditEvent<Task, String>) e;
            int index = t.getTablePosition().getRow();
            Task task = t.getTableView().getItems().get(index);
            task.setTitle(t.getNewValue());
        } );
        // status column
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        // isDone column
        isDoneColumn.setCellValueFactory(new PropertyValueFactory<>("done"));
        isDoneColumn.setCellFactory(CheckBoxTableCell.<Task>forTableColumn(isDoneColumn));
        tasksTable.setItems(data);
    }
}