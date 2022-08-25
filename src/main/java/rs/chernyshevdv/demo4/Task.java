package rs.chernyshevdv.demo4;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {
    private final SimpleStringProperty title;
    private final SimpleStringProperty status;
    private final SimpleBooleanProperty done;

    public Task(String title, String status, Boolean done){
        this.title = new SimpleStringProperty(title);
        this.status = new SimpleStringProperty(status);
        this.done = new SimpleBooleanProperty(done);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public boolean isDone() {
        return done.get();
    }

    public void setDone(boolean done) {
        this.done.set(done);
    }

    @Override
    public String toString(){
        return String.format("(Task: %s, %s, Done: %s)", this.getTitle(), this.getStatus(), this.isDone());
    }
}
