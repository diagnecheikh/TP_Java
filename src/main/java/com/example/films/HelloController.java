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

public class HelloController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idTab.setCellValueFactory(new PropertyValueFactory<Film, String>("nom"));
        rangTab.setCellValueFactory(new PropertyValueFactory<Film, Integer>("rang"));
        nomFilmTab.setCellValueFactory(new PropertyValueFactory<Film, String>("id"));
        anneeSortieTab.setCellValueFactory(new PropertyValueFactory<Film, Integer>("annee"));

        ajouterFimDansTableau(8, "dryf", "fgcjf", 1695);



    }
     public void ajouterFimDansTableau(Integer rang, String id, String nom, Integer annee){

         Film film = new Film();
         film.setId(id);
         film.setRang(rang);
         film.setNom(nom);
         film.setAnnee(annee);

         ObservableList<Film> films = tab.getItems();
         films.add(film);
         tab.setItems(films);
     }
    public void supprimerFimDansTableau(Integer rang, String id, String nom, Integer annee){

        Film delete = new Film();
        delete.setId(id);
        delete.setRang(rang);
        delete.setNom(nom);
        delete.setAnnee(annee);

        ObservableList<Film> films = tab.getItems();
        films.clear();
        tab.setItems(films);
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
    private void ajouterFilm(){
        Integer rang = Integer.parseInt(txF.getText());
        String id = txF2.getText();
        String nom = txF3.getText();
        Integer annee = Integer.parseInt(txF4.getText());

        ajouterFimDansTableau(rang, id, nom, annee);

    }
    @FXML
    private void viderFilm(){
        Integer rang = Integer.parseInt(rangTab.getText());
        String id = idTab.getText();
        String nom = nomFilmTab.getText();
        Integer annee = Integer.parseInt(anneeSortieTab.getText());

        supprimerFimDansTableau(rang,id,nom,annee);
    }

}