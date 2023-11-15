// * Copyright (c) 2023. trefas@yandex.ru
package ru.sysadminvlg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Bgpicker extends HBox {
    @FXML
    private TextField tf;
    @FXML
    private Button btn;
    private int Code;
    public int getCode() {
        return Code;
    }
    public Bgpicker(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bgpicker.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Не удалось загрузить кастомный элемент BGPicker");
            throw new RuntimeException(e);
        }
        btn.onMouseClickedProperty().set(e -> btnClick());
        tf.setOnAction(e -> txtEnter());
    }
    private void btnClick() {
    }
    private void txtEnter() {
        Bloodgroup bg = new Bloodgroup(tf.getText());
        Code = bg.getCode();
        System.out.println(Code);
    }
}