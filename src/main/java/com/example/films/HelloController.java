package com.example.films;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.Button;


public class HelloController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idTab.setCellValueFactory(new PropertyValueFactory<Film, String>("id"));
        rangTab.setCellValueFactory(new PropertyValueFactory<Film, Integer>("rang"));
        nomFilmTab.setCellValueFactory(new PropertyValueFactory<Film, String>("nom"));
        anneeSortieTab.setCellValueFactory(new PropertyValueFactory<Film, Integer>("annee"));

    }
     public void ajouterFilmDansTableau(Integer rang, String id, String nom, Integer annee){

         Film film = new Film();
         film.setId(id);
         film.setRang(rang);
         film.setNom(nom);
         film.setAnnee(annee);

         ObservableList<Film> films = tab.getItems();
         films.add(film);
         tab.setItems(films);
     }

    public void chargerDonneesDepuisCSV(String fichierCSV) {
        String ligne;
        String separateur = ","; // Séparateur utilisé pour séparer les colonnes

        try (BufferedReader br = new BufferedReader(new FileReader(fichierCSV))) {

            // Lire la ligne d'en-tête
            String entete = br.readLine();
            String[] colonnes = entete.split(separateur);

            // Vérifier si les colonnes correspondent aux noms attendus
            if (colonnes.length == 4 && colonnes[0].equals("rang") && colonnes[1].equals("id") &&
                    colonnes[2].equals("nom") && colonnes[3].equals("annee")) {

                while ((ligne = br.readLine()) != null) {
                    String[] donnees = ligne.split(separateur);

                    // Vérifier si le tableau de données contient suffisamment d'éléments
                    if (donnees.length == 4) {
                        // Extraire les données nécessaires du tableau "donnees"
                        Integer rang = Integer.parseInt(donnees[0]);
                        String id = donnees[1];
                        String nom = donnees[2];
                        Integer annee = Integer.parseInt(donnees[3]);

                        // Appeler la méthode ajouterFilmDansTableau pour ajouter les données à la table
                        ajouterFilmDansTableau(rang, id, nom, annee);
                    } else {
                        System.out.println("Données incorrectes dans la ligne du fichier CSV : " + ligne);
                    }
                }
            } else {
                System.out.println("En-tête du fichier CSV incorrecte : " + entete);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private TableView tab;
    @FXML
    private TableColumn idTab;
    @FXML
    private TableColumn rangTab;
    @FXML
    private TableColumn nomFilmTab;
    @FXML
    private TableColumn anneeSortieTab;
    @FXML
    private GridPane gpane;
    @FXML
    private Label rangL;
    @FXML
    private Label idL;
    @FXML
    private Label nomL;
    @FXML
    private TextArea txA;
    @FXML
    private TextField txF;
    @FXML
    private TextField txF3;
    @FXML
    private Label annee;
    @FXML
    private TextField txF4;
    @FXML
    private TextField txF2;
    @FXML
    private  Button btnAjouter;
    @FXML
    private Button bntVider;
    @FXML
    private Button btnCharger;

    @FXML
    private void ajouterFilm(){
        Integer rang = Integer.parseInt(txF.getText());
        String id = txF2.getText();
        String nom = txF3.getText();
        Integer annee = Integer.parseInt(txF4.getText());

        ajouterFilmDansTableau(rang, id, nom, annee);

    }
    @FXML
    private void viderFilm() {
        Film filmSelectionne = (Film) tab.getSelectionModel().getSelectedItem();
        if (filmSelectionne != null) {
            ObservableList<Film> films = tab.getItems();
            films.remove(filmSelectionne);
            tab.setItems(films);
        }
    }
    @FXML
    private void chargerDonnees() {
        String fichierCSV = "src/main/java/com/example/films/fichier.csv";
        chargerDonneesDepuisCSV(fichierCSV);
    }
}
