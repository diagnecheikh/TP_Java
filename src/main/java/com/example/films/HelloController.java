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
}