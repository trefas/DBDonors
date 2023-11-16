// * Copyright (c) 2023. trefas@yandex.ru

package ru.sysadminvlg;
public class Bloodgroup {
    public int Code;
    public Phenotype Ph;
    public Bloodgroup(int code){
        Code = code;
        Ph = new Phenotype();
        Ph.setPartCode(code&63);
    }
    public Bloodgroup(String fullCode){
        String[] parts = fullCode.split(" ");
        Ph = new Phenotype();
        Ph.setTextCode(parts[1]);
        String[] gr = parts[0].split("\\)");
        switch (gr[0]){
            case "A(II": Code = 64; break;
            case "B(III": Code = 128; break;
            case "AB(IV": Code = 192; break;
            case "0(I": Code = 0; break;
        }
        Code += Ph.getPartCode();
    }
    public int getCode() { return Code; }
    public Phenotype getPh() { return Ph; }
    public int getGroup() { return Code>>6; }
    public boolean getRh() { return Ph.antigens[5]; }
    public String getGroupText(){
        String[] groups = { "0(I)","A(II)","B(III)","AB(IV)" };
        String txt = groups[getGroup()];
        txt += (Ph.antigens[5])? "Rh+":"Rh-";
        return txt;
    }
    public String getFullText(){ return getGroupText() + " " + Ph.getTextCode(); }
}