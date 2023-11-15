// * Copyright (c) 2023. trefas@yandex.ru
package ru.sysadminvlg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
public class Bgpopup extends AnchorPane {
    private int Code;
    private String Text;
    private Bloodgroup bgroup;
    @FXML
    private ToggleGroup bg;
    @FXML
    private CheckBox rh;
    @FXML
    private CheckBox AgC;
    @FXML
    private CheckBox Agc;
    @FXML
    private CheckBox AgE;
    @FXML
    private CheckBox Age;
    @FXML
    private CheckBox AgK;
    @FXML
    private Button btn;
    public Button getBtn() {
        return btn;
    }
    private void loadForm() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bgpopup.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Не удалось загрузить форму bgpopup.fxml");
            throw new RuntimeException(e);
        }
    }
    public void setCode(int code) {
        Code = code;
        bgroup = new Bloodgroup(code);
        Text = bgroup.getFullText();
        setCheck();
    }
    public void setText(String text) {
        Text = text;
        bgroup = new Bloodgroup(text);
        Code = bgroup.getCode();
        setCheck();
    }
    public int getCode() {
        return Code;
    }
    public String getText() {
        return Text;
    }
    public Bgpopup(int code){
        loadForm();
        setCode(code);
    }
    public Bgpopup(String txt){
        loadForm();
        setText(txt);
    }
    private void setCheck() {
        rh.setSelected(bgroup.getRh());
        boolean[] antigens = bgroup.getPh().antigens;
        AgC.setSelected(antigens[0]);
        AgE.setSelected(antigens[1]);
        Agc.setSelected(antigens[2]);
        Age.setSelected(antigens[3]);
        AgK.setSelected(antigens[4]);
        bg.getToggles().get(bgroup.getGroup()).setSelected(true);
    }
}