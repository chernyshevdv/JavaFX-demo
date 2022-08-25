package rs.chernyshevdv.demo4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public final ObservableList<Task> taskList = FXCollections.observableArrayList(
            new Task("Create demand for Bocharov's replacement", "open", false),
            new Task("Develop projects overview slidepack", "open", false),
            new Task("Yesman: poke CWPO to keep correct assign for him only", "open", true)
    );

    @Override
    public void start(Stage stage) throws IOException {
        HelloController controller = new HelloController(taskList);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        System.out.println(String.format("%s tasks in the list:", taskList.size()));
        for (Task t: taskList){
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}