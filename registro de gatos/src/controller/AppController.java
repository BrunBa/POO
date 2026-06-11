package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import model.GatoRepositorio;
import view.AppView;

public class AppController implements Initializable {
    @FXML
    private TableView<view.Gato> tabela;
    @FXML
    private TableColumn<view.Gato, String> nomeCol;
    @FXML
    private TableColumn<view.Gato, String> dataDeNascimentoCol;
    @FXML
    private TableColumn<view.Gato, String> brinquedoFavoritoCol;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField dataDeNascimentoField;
    @FXML
    private TextField brinquedoFavoritoField;
    @FXML
    private Button adicionarButton;
    @FXML
    private Button atualizarButton;
    @FXML
    private Button deletarButton;    
    @FXML
    private Button cancelarButton;    
    @FXML
    private Button salvarButton;
    
    AppView appView;
    
    private static model.Database database = new model.Database("app.sqlite");
    private static model.GatoRepositorio gatoRepo = 
        new model.GatoRepositorio(database);
        
    public AppController() {
        this.appView = new AppView();
    }
    
    public static void main(String[] args) throws Exception {
        AppController appController = new AppController();
        appController.appView.run(args);
    }
    
    private void desabilitarBotoes(boolean adicionar, boolean atualizar, boolean deletar, boolean cancelar, boolean salvar) {
        adicionarButton.setDisable(adicionar);
        atualizarButton.setDisable(atualizar);
        deletarButton.setDisable(deletar);
        cancelarButton.setDisable(cancelar);
        salvarButton.setDisable(salvar);        
    }
    
    private void desabilitarCampos(boolean desabilitado) {
        nomeField.setDisable(desabilitado);
        brinquedoFavoritoField.setDisable(desabilitado);
        dataDeNascimentoField.setDisable(desabilitado);
    }
    
    private void limparCampos() {
        dataDeNascimentoField.setText("");
        nomeField.setText("");
        brinquedoFavoritoField.setText("");        
    }
    
    @FXML
    public void onCancelarButtonAction() {
        desabilitarCampos(true);
        desabilitarBotoes(false,true,true,true,true);
        limparCampos();
        tabela.getSelectionModel().select(-1);        
    }
    
    @FXML
    public void onSalvarButtonAction() {
        try {
            model.Gato gato = new model.Gato();            
            gato.setNome(nomeField.getText());
            gato.setDataDeNascimento(dataDeNascimentoField.getText()); 
            gato.setBrinquedoFavorito(brinquedoFavoritoField.getText());
            model.Gato gato_salvo = gatoRepo.create(gato); 
            view.Gato gatoView = modelToView(gato_salvo);
            tabela.getItems().add(gatoView);
            tabela.getSelectionModel().select(gatoView);    
            desabilitarCampos(true);
            desabilitarBotoes(false,true,true,true,true);            
        }
        catch(Exception e) {
            new Alert(AlertType.ERROR, "Erro ao salvar: "+e.getMessage()).show();
        }
    }    
    
    @FXML
    public void onAdicionarButtonAction() {
        tabela.getSelectionModel().select(-1);
        desabilitarCampos(false);
        desabilitarBotoes(true,true,true,false,false);
        limparCampos();
    }

    @FXML
    private void handleGatoSelected(view.Gato newSelection) {
        if (newSelection != null) {
            dataDeNascimentoField.setText(newSelection.getDataDeNascimento());
            nomeField.setText(newSelection.getNome());
            brinquedoFavoritoField.setText(newSelection.getBrinquedoFavorito());
            desabilitarBotoes(false,false,false,true,true);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        dataDeNascimentoCol.setCellValueFactory(
                new PropertyValueFactory<>("dataDeNascimento"));
        brinquedoFavoritoCol.setCellValueFactory(
                new PropertyValueFactory<>("brinquedoFavorito"));
        tabela.setItems(loadAllGatos());
        tabela.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldSelection, newSelection) -> {
                handleGatoSelected(newSelection);
            });
    }
    
    private view.Gato modelToView(model.Gato gato) {
        return new view.Gato(
            gato.getNome(),
            gato.getDataDeNascimento(),
            gato.getBrinquedoFavorito()
        );
    }
    
    private ObservableList<view.Gato> loadAllGatos() {
        ObservableList<view.Gato> lista = 
            FXCollections.observableArrayList();
        List<model.Gato> listaFromDatabase = gatoRepo.loadAll();
        for(model.Gato gato: listaFromDatabase) {
            lista.add(modelToView(gato));
        }
        return lista;
    }
}