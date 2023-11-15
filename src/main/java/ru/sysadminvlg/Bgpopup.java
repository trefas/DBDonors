// * Copyright (c) 2023. trefas@yandex.ru

package ru.sysadminvlg;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class Bgpopup extends AnchorPane {
    private int Code;

    private String Text;

    private Bloodgroup bgroup;
    private ToggleGroup bg;
    private CheckBox rh;
    private CheckBox AgC;
    private CheckBox Agc;
    private CheckBox AgE;
    private CheckBox Age;
    private CheckBox AgK;
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
        setCode(code);
    }

    public Bgpopup(String txt){
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
