package ui;

import domain.Account;
import domain.Bank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.nio.channels.AcceptPendingException;
import java.util.Map;


public class BankUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Bank bank = new Bank("kbc");
        GridPane root = new GridPane();
        Scene scene = new Scene(root,400,500);
        Button addAccount = new Button("add account");
        Button addObserver = new Button("add observer");
        Button removeObserver = new Button("remove Observer");
        Button registerObserver = new Button("register observer");
        Button withdraw = new Button("withdraw");
        root.add(addAccount,0,1);
        root.add(addObserver,0,2);
        root.add(removeObserver,0,3);
        root.add(registerObserver,0,4);
        root.add(withdraw,0,5);
        addAccount.setOnAction(new AddAccount(scene,primaryStage,bank));
        addObserver.setOnAction(new AddObserver(scene,primaryStage));
        removeObserver.setOnAction(new RemoveObserver(scene,primaryStage));
        registerObserver.setOnAction(new RegisterObserver(scene,primaryStage));
        withdraw.setOnAction(new Withdraw(scene,primaryStage));
        primaryStage.setTitle("KBC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
