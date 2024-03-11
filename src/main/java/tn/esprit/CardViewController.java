package tn.esprit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

public class CardViewController {

    @FXML
    private Label age;

    @FXML
    private HBox boxh;

    @FXML
    private VBox boxv;
    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    public void setPersonnes(Personne p ){
        nom.setText(p.getNom());
        prenom.setText(p.getPrenom());
        age.setText(""+p.getAge());
        boxv.setStyle("-fx-background-color: c1e1ff");


    }


}
