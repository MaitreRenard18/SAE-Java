package fr.aftek.ihm.controleurs;

import java.io.IOException;

import fr.aftek.ihm.ApplicationJO;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class ControleurMenu extends Controleur {

    @FXML
    public VBox vboxOrg;
    @FXML 
    public VBox vboxAdm;

    private boolean afficherOrg;
    private boolean afficherAdm;

    public ControleurMenu(ApplicationJO application, boolean afficherOrg, boolean afficherAdm) {
        this.application = application;
        this.afficherOrg = afficherOrg;
        this.afficherAdm = afficherAdm;
    }

    @FXML
    public void initialize() {
        vboxOrg.setVisible(afficherOrg || afficherAdm);
        vboxAdm.setVisible(afficherAdm);
    }

    public void afficherAthletes() throws IOException, InterruptedException {
        application.classementAthletes();
    }

    public void afficherEquipes() {
        // TODO
    }

    public void afficherEpreuves() {
        // TODO
    }

    public void afficherPays() {
        // TODO
    }
    
    public void afficherAdmin() {
        // TODO
    }
}
