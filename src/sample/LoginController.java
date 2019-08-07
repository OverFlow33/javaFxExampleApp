package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoginController {

    int co = 0;
    static UtilisateurDao utilisateurDao;

    public LoginController() {
    }

    public LoginController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @FXML
    private VBox vbox;

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    public void hundleClear(ActionEvent actionEvent) {
        usernameInput.setText("");
        passwordInput.setText("");
    }

    public void hundleLogin(ActionEvent actionEvent) {
        Utilisateur utilisateur =
                LoginController.utilisateurDao.readByUsername(usernameInput.getText());

        if(utilisateur != null){
            if(usernameInput.getText().equals(utilisateur.getUsername()) &&
                    passwordInput.getText().equals(utilisateur.getPassword())){
                System.out.println("you are logged in ");

                co = 0;
            } else {
                if(co < 5){
                    System.out.println("try again");
                    co++;
                } else {
                    ((Stage)passwordInput.getScene().getWindow()).close();
                }
            }
        } else {
            if(co < 5){
                System.out.println("try again");
                co++;
            } else {
                ((Stage)passwordInput.getScene().getWindow()).close();
            }
        }

    }
}
