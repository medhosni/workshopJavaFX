package tn.esprit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import tn.esprit.Personne;
import tn.esprit.ServicePersonne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionPersonne {

    @FXML
    private TextField age_tf;

    @FXML
    private HBox boxh;

    @FXML
    private TextField nom_tf;

    @FXML
    private TextField prenom_tf;

    @FXML
    void addPersonne(ActionEvent event) {
        ServicePersonne sp = new ServicePersonne();
        sp.add(new Personne(0,nom_tf.getText(),prenom_tf.getText(),Integer.parseInt(age_tf.getText())));

    }

    @FXML
    void showPerosnnoe(ActionEvent event) {
        ServicePersonne sp = new ServicePersonne();

        List<Personne> personnes = sp.getAll();
        for (Personne p : personnes){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cardview.fxml")) ;
                HBox boc =fxmlLoader.load();
                CardViewController c = fxmlLoader.getController();
                 c.setPersonnes(p);

                boxh.getChildren().add(boc);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }

}
