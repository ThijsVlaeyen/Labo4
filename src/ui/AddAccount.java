package ui;

import domain.Bank;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class AddAccount implements EventHandler<ActionEvent> {
    private Scene oldscene;
    private Stage primarystage;
    private Bank bank;

    public AddAccount(Scene oldscene, Stage primarystage,Bank bank){
        this.oldscene = oldscene;
        this.primarystage = primarystage;
        this.bank = bank;
    }

    @Override
    public void handle(ActionEvent event) {
        TextField balance = new TextField();

    }
}
