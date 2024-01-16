/*
 * Copyright (c) 2023. trefas@yandex.ru
 */

package ru.sysadminvlg;

public enum TypeDoc {
    PAS("Паспорт РФ"), MIL("Военный билет");
    String name;
    TypeDoc(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
