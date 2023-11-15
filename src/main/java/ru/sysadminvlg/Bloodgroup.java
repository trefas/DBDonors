// * Copyright (c) 2023. trefas@yandex.ru

package ru.sysadminvlg;
public class Bloodgroup {
    public int Code;
    public boolean Rh;
    public Phenotype Ph;
    public Bloodgroup(int code){
        Code = code;
        Ph = new Phenotype();
        Ph.setPartCode(code&63);
        Rh = code%2 != 0;
    }
    public Bloodgroup(String fullCode){
        String[] parts = fullCode.split(" ");
        Ph = new Phenotype();
        Ph.setTextCode(parts[1]);
        switch (parts[0]){
            case "0(I)Rh+": Rh = true; Code = 0; break;
            case "A(II)Rh+": Rh = true; Code = 64; break;
            case "A(II)Rh-": Rh = false; Code = 64; break;
            case "B(III)Rh+": Rh = true; Code = 128; break;
            case "B(III)Rh-": Rh = false; Code = 128; break;
            case "AB(IV)Rh+": Rh = true; Code = 192; break;
            case "AB(IV)Rh-": Rh = false; Code = 192; break;
            default: Rh = false; Code = 0; break;
        }
        Code += Ph.getPartCode();
    }
    public int getCode() { return Code; }
    public Phenotype getPh() { return Ph; }
    public int getGroup() { return Code>>6; }
    public boolean getRh() { return Rh; }
    public String getGroupText(){
        String[] groups = { "0(I)","A(II)","B(III)","AB(IV)" };
        String txt = groups[getGroup()];
        txt += (getRh())? "Rh+":"Rh-";
        return txt;
    }
    public String getFullText(){ return getGroupText() + " " + Ph.getTextCode(); }
}