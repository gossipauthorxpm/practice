package com.example.practice.windows;

import com.example.practice.data.bin.Account;
import com.example.practice.data.bin.AccountTables;
import com.example.practice.data.bin.DataHandler;
import com.example.practice.data.bin.StaticData;
import com.example.practice.logic.exceptions.UserException;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class AdminPanel {
    Account account_select;

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
     */
    private void createFabricToNameTables() {
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

    //    Событие клика по таблице
    EventHandler<MouseEvent> click_event = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            ObservableList<AccountTables> account_tables = accounts_table.getSelectionModel().getSelectedItems();
            if (account_tables.size() > 1) {
                return;
            }
            AccountTables account = account_tables.get(0);

            account_select = new AccountTables(
                    account.getId(),
                    account.getLogin(),
                    account.getPassword(),
                    account.getStatus(),
                    account.getRole()
            );

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
    private final TableColumn<AccountTables, Integer> id_column = new TableColumn<>("Id");
    private final TableColumn<AccountTables, String> login = new TableColumn<>("Login");
    private final TableColumn<AccountTables, String> password = new TableColumn<>("password");
    private final TableColumn<AccountTables, String> status = new TableColumn<>("status");
    private final TableColumn<AccountTables, String> role = new TableColumn<>("role");
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

    @FXML
    private Button delete_accounts;

    @FXML
    protected void clickDeleteAccount() {
        DataHandler database = new DataHandler();
        if (this.account_select == null) {
            new Alert(Alert.AlertType.ERROR, "Ошибка удаление аккаунта.\nВыберите аккаунт для удаления!").show();
            return;
        }
        try {
            int id_account_select = this.account_select.getId();
            database.deleteAccount(id_account_select);
            new Alert(Alert.AlertType.INFORMATION, "Аккаунт успешно удален!").show();
            ObservableList<AccountTables> accounts = database.getAccountDataToAdminTable();
            accounts_table.setItems(accounts);
        } catch (SQLException error) {
            new Alert(Alert.AlertType.ERROR, "Ошибка удаление аккаунта.\nОшибка базы данных!").show();
            return;
        }

    }

    /**
     * Проверка на заполение форм данными
     */
    private void checkEmptyFields(String id, String login, String password, String status, String role) throws UserException {
        if (id.trim().equals("")) {
            throw new UserException("Пустой id");
        }
        if (login.trim().equals("")) {
            throw new UserException("Пустой login");
        }
        if (password.trim().equals("")) {
            throw new UserException("Пустой password");
        }
        if (status.trim().equals("")) {
            throw new UserException("Пустой status");
        }
        if (role.trim().equals("")) {
            throw new UserException("Пустой role");
        }
    }

    private void checkEmptyFields(String id, String login, String status, String role) throws UserException {
        if (id.trim().equals("")) {
            throw new UserException("Пустой id");
        }
        if (login.trim().equals("")) {
            throw new UserException("Пустой login");
        }
        if (status.trim().equals("")) {
            throw new UserException("Пустой status");
        }
        if (role.trim().equals("")) {
            throw new UserException("Пустой role");
        }
    }

    /**
     * Проверка наличия вводимых id и login в базе данных
     */
    private void checkRepeatLoginAndId(String id, String login, List<Account> accounts) throws UserException {
        for (Account account : accounts) {
            String account_login = account.getLogin();
            String account_id = Integer.toString(account.getId());
            if (account_login.equals(login)) {
                throw new UserException("Данный login присутствует в системе!");
            }
            if (account_id.equals(id)) {
                throw new UserException("Данный id присутствует в системе!");
            }
        }
    }

    /**
     * Проверка длинн строчек полей ввода для корректного запроса в бд и отлова ошибок
     */
    private void checkLongWordsFields(String login, String password, String status, String role) throws UserException {
        if (login.length() > StaticData.FATAL_LOGIN_LENGTH) {
            throw new UserException("Превышена длинна поля login");
        }
        if (password.length() > StaticData.FATAL_PASSWORD_LENGTH) {
            throw new UserException("Превышена длинна поля password");
        }
        if (status.length() > StaticData.FATAL_STATUS_LENGTH) {
            throw new UserException("Превышена длинна поля status");
        }
        if (role.length() > StaticData.FATAL_ROLE_LENGTH) {
            throw new UserException("Превышена длинна поля role");
        }
    }

    @FXML
    protected void clickCreateAccount() throws SQLException {
        DataHandler database = new DataHandler();
        String id = id_field.getText().trim();
        if (!id.equals("")) {
            try {
                Integer int_id = Integer.parseInt(id);
            } catch (NumberFormatException error) {
                new Alert(Alert.AlertType.ERROR, "Введите в поле id число а не строку").show();
                return;
            }
        }
        String login = login_field.getText().trim();
        String password = password_field.getText().trim();
        String status = status_field.getText().trim();
        String role = role_field.getText().trim();
        try {
            this.checkEmptyFields(id, login, password, status, role);
        } catch (UserException error) {
            new Alert(Alert.AlertType.ERROR, error.getError()).show();
            return;
        }
        try {
            this.checkLongWordsFields(login, password, status, role);
        } catch (UserException error) {
            new Alert(Alert.AlertType.ERROR, error.getError()).show();
            return;
        }
        try {
            List<Account> accounts = database.getAllAccounts();
            this.checkRepeatLoginAndId(id, login, accounts);
        } catch (UserException error) {
            new Alert(Alert.AlertType.ERROR, error.getError()).show();
            return;
        }
        database.createAccount(id, login, password, role, status);
        new Alert(Alert.AlertType.INFORMATION, "Аккаунт успешно создан!").show();
        ObservableList<AccountTables> accounts = database.getAccountDataToAdminTable();
        accounts_table.setItems(accounts);
    }

    @FXML
    protected void clickBackButton() {
        Stage admin_window = (Stage) delete_accounts.getScene().getWindow();
        Stage authorization_window = StaticData.getAuthorizationWindow();

        StaticData.setAdminWindow(admin_window);
        authorization_window.show();
        admin_window.close();
    }

    @FXML
    protected void updateAccount() throws SQLException {
//    можно изменить роль, статус
        DataHandler database = new DataHandler();
        String id = id_field.getText().trim();
        if (!id.equals("")) {
            try {
                Integer int_id = Integer.parseInt(id);
            } catch (NumberFormatException error) {
                new Alert(Alert.AlertType.ERROR, "Введите в поле id число а не строку").show();
                return;
            }
        }
        String login = login_field.getText().trim();
        String status = status_field.getText().trim();
        String role = role_field.getText().trim();
        try {
            this.checkEmptyFields(id, login, status, role);
        } catch (UserException error) {
            new Alert(Alert.AlertType.ERROR, error.getError()).show();
            return;
        }
        try {
            List<Account> accounts = database.getAllAccounts();
            this.checkValidIdToLogin(accounts, id, login);
        } catch (UserException error) {
            new Alert(Alert.AlertType.ERROR, error.getError()).show();
            return;
        }
        database.updateAccount(id, role, status);
        new Alert(Alert.AlertType.INFORMATION, "Информация об аккаунте изменена успешно!").show();
        ObservableList<AccountTables> accounts = database.getAccountDataToAdminTable();
        accounts_table.setItems(accounts);
    }

    /**
     * Проверка принадлежности логина к аккауту к его индентификатору
     */
    private void checkValidIdToLogin(List<Account> accounts, String id, String login) throws UserException {
        for (Account account : accounts) {
            if (account.getId() == Integer.parseInt(id)) {
                if (account.getLogin().equals(login)) {
                    return;
                } else {
                    throw new UserException("Для данного id, указан неверный login.\nПоле login для данного id не подлежит изменению");
                }
            }
        }
        throw new UserException("Не найден аккаунт с данным id.\nВведите корректный id");
    }

}
