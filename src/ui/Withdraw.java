package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Withdraw implements EventHandler<ActionEvent> {

    private Scene oldscene;
    private Stage primarystage;

    public Withdraw(Scene oldscene, Stage primarystage){
        this.oldscene = oldscene;
        this.primarystage = primarystage;
    }
    @Override
    public void handle(ActionEvent event) {

    }
}
