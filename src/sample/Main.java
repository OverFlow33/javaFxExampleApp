package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main extends Application {
    static SessionFactory sessionFactory;
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        VBox vbox = fxmlLoader.load(
                getClass().getResource("loginUi.fxml"));

        primaryStage.setTitle("Application java fx");
        Scene scene = new Scene(vbox, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Utilisateur.class)
                .buildSessionFactory();

        UtilisateurDao utilisateurDao = new UtilisateurDaoImpl(sessionFactory);
        LoginController loginController = new LoginController(utilisateurDao);

        launch(args);
    }
}
