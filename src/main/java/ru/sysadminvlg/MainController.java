// * Copyright (c) 2024. trefas@yandex.ru
package ru.sysadminvlg;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_search;
    @FXML
    private Addrpicker ce_addr;
    @FXML
    private Bgpicker ce_bgroupe;
    @FXML
    private Docpicker ce_doc;
    @FXML
    private TableColumn col_bday;
    @FXML
    private TableColumn col_bgroupe;
    @FXML
    private TableColumn col_date;
    @FXML
    private TableColumn col_fio;
    @FXML
    private TableColumn col_med;
    @FXML
    private TableColumn col_phone;
    @FXML
    private DatePicker dp_bday;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_patronim;
    @FXML
    private TextField tf_phone;
    @FXML
    private TextField tf_surname;
    @FXML
    private TextField tf_work;
    @FXML
    private TableView blood;
    @FXML
    private TableView donors;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_fio.setCellValueFactory(new PropertyValueFactory<Donor, String>("FullName"));
        col_phone.setCellValueFactory(new PropertyValueFactory<Donor, String>("phone"));
        col_bday.setCellValueFactory(new PropertyValueFactory<Donor, String>("bday"));
        col_bgroupe.setCellValueFactory(new PropertyValueFactory<Donor, String>("BloodGroupe"));
        FilteredList<Donor> fdata = new FilteredList<>(FXCollections.observableArrayList(Test.list));
        donors.setItems(fdata);
    }

    public void onDonorSelect(MouseEvent mouseEvent) {
        Donor selDonor = (Donor) donors.getSelectionModel().getSelectedItem();
        tf_surname.setText(selDonor.getSurname());
        tf_name.setText(selDonor.getName());
        tf_patronim.setText(selDonor.getPatronim());
        dp_bday.setValue(selDonor.getBday());
        tf_phone.setText(selDonor.getPhone());
        ce_addr.setAddr(selDonor.getAddr());
        ce_addr.address.setText(selDonor.getAddr().getFullTxt());
        ce_doc.setDoc(selDonor.getDoc());
        ce_doc.document.setText(selDonor.getDoc().toString());
        ce_bgroupe.setCode(selDonor.getBgroup().getCode());
        ce_bgroupe.getTf().setText(selDonor.getBloodGroupe());
        tf_work.setText(selDonor.getWork());
    }

    public void onDonorClear(ActionEvent actionEvent) {
        tf_surname.setText("");
        tf_name.setText("");
        tf_patronim.setText("");
        dp_bday.setValue(LocalDate.now());
        dp_bday.getEditor().setText("");
        tf_phone.setText("");
        ce_addr.address.setText("");
        ce_addr.setAddr(new Address("","","","","",0,0));
        ce_doc.document.setText("");
        ce_doc.setDoc(new Document(TypeDoc.PAS,"",0,"",LocalDate.now()));
        ce_bgroupe.getTf().setText("");
        ce_bgroupe.setCode(0);
        tf_work.setText("");
    }
}