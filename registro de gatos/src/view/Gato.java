package view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Gato {
    
    private SimpleStringProperty nome;
    private SimpleStringProperty dataDeNascimento;
    private SimpleStringProperty brinquedoFavorito;
    
    public Gato(String nome, 
                    String dataDeNascimento, String brinquedoFavorito) {
        this.nome = new SimpleStringProperty(nome);
        this.dataDeNascimento = new SimpleStringProperty(dataDeNascimento);
        this.brinquedoFavorito = new SimpleStringProperty(brinquedoFavorito);        
    }
    
//Start GetterSetterExtension Source Code

       /**GET Method Propertie nome*/
    public String getNome(){
        return this.nome.get();
    }//end method getNome

    /**SET Method Propertie nome*/
    public void setNome(String nome){
        this.nome.set(nome);
    }//end method setNome

    /**GET Method Propertie dataDeNascimento*/
    public String getDataDeNascimento(){
        return this.dataDeNascimento.get();
    }//end method getDataDeNascimento

    /**SET Method Propertie dataDeNascimento*/
    public void setDataDeNascimento(String dataDeNascimento){
        this.dataDeNascimento.set(dataDeNascimento);
    }//end method setDataDeNascimento
    
    /**GET Method Propertie brinquedoFavorito*/
    public String getBrinquedoFavorito(){
        return this.brinquedoFavorito.get();
    }//end method getbrinquedoFavorito

    /**SET Method Propertie brinquedoFavorito*/
    public void setBrinquedoFavorito(String brinquedoFavorito){
        this.brinquedoFavorito.set(brinquedoFavorito);
    }//end method setbrinquedoFavorito

//End GetterSetterExtension Source Code


}//End class