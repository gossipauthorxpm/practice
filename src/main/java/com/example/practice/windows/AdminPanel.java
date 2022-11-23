package com.example.practice.windows;

import com.example.practice.data.bin.AccountTables;
import com.example.practice.data.bin.DataHandler;
import com.example.practice.data.bin.StaticData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.Text;

import java.sql.SQLException;

public class AdminPanel {
    @FXML
    public void initialize() throws SQLException {
//        настройка таблицы с данными
        DataHandler database = new DataHandler();
        ObservableList<AccountTables> accounts = database.getAccountDataToAdminTable();
        accounts_table.setItems(accounts);
//        создание столбцов
        this.createFabricToNameTables();
        this.accounts_table.addEventFilter(MouseEvent.MOUSE_CLICKED, click_event);
    }
    /**
     * Присваивание типов для таблицы и передача их в саму таблицу
     * */
    private void createFabricToNameTables(){
        this.id_column.setCellValueFactory(new PropertyValueFactory<>("simple_id"));
        this.login.setCellValueFactory(new PropertyValueFactory<>("simple_login"));
        this.password.setCellValueFactory(new PropertyValueFactory<>("simple_password"));
        this.status.setCellValueFactory(new PropertyValueFactory<>("simple_status"));
        this.role.setCellValueFactory(new PropertyValueFactory<>("simple_role"));

        this.accounts_table.getColumns().add(this.id_column);
        this.accounts_table.getColumns().add(this.login);
        this.accounts_table.getColumns().add(this.password);
        this.accounts_table.getColumns().add(this.status);
        this.accounts_table.getColumns().add(this.role);
    }
    private void enterDataToFieldFromTable(ObservableList<AccountTables> account_tables){

    }
//    Событие клика по таблице
    EventHandler<MouseEvent> click_event = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            ObservableList<AccountTables> account_tables = accounts_table.getSelectionModel().getSelectedItems();
            if(account_tables.size() > 1){return;}
            AccountTables account = account_tables.get(0);
            status_field.setText(account.getStatus());
            id_field.setText(Integer.toString(account.getId()));
            login_field.setText(account.getLogin());
            role_field.setText(account.getRole());
            password_field.setText(account.getPassword());
        }
    };
    @FXML
    private TableView<AccountTables> accounts_table;
//    определение столбцов таблицы
    private TableColumn<AccountTables, Integer> id_column = new TableColumn<>("Id");
    private TableColumn<AccountTables, String> login = new TableColumn<>("Login");
    private TableColumn<AccountTables, String> password = new TableColumn<>("password");
    private TableColumn<AccountTables, String> status = new TableColumn<>("status");
    private TableColumn<AccountTables, String> role = new TableColumn<>("role");
    @FXML
    private TextField status_field;
    @FXML
    private TextField password_field;
    @FXML
    private TextField role_field;
    @FXML
    private TextField login_field;
    @FXML
    private TextField id_field;
}
