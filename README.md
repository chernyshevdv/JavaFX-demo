# JavaFX-demo
A demo app to show basic JavaFX application
<img width="650" alt="Screen Shot 2022-08-25 at 21 11 49" src="https://user-images.githubusercontent.com/1935211/186748969-8559b673-1883-49bf-9204-c075f60814da.png">

This is the most simple JavaFX application containing 3 java files and 1 FXML.
It creates a form with a TableView.
The TableView has 3 columns:
* `title` is an editable text
* `status` is a non-editable text
* `done` is a checkbox, which you can toggle back-n-forth

The form also contains a set of `TextField`s and a `Button` to create a new record.
`Task` is a JavaFX flavour of POJO, the only difference is it uses `Property`s instead of simple types.
Data source for the TableView is an `ObservableList` of `Task`a.
You can easily replace it with a service.

Worth mentioning that `HelloController` class is used as a controller for the form.
It has a non-standard constructor accepting the `ObservableList<Task>` parameter.
Hence it is being initalized in `HelloApplication::start(Stage)` method rather than indicated in FXML file:
```HelloApplication.java
...
public void start(Stage stage) throws IOException {
    HelloController controller = new HelloController(taskList);
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    fxmlLoader.setController(controller);
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
}
...
```

`HelloController::initialize()` method sets up the TableView after loading it from FXML.
It assigns CellValueFactories to all columns, and for two of them (title and isDone) assigns CellFactories (`TextFieldTableCell` and `CheckBoxTableCell` correspondently).
It also sets event handler for title's `onEditCommit` event, where updates a correspondent Task's value in the `ObservableList`.
