package model;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName="gato")
public class Gato {
            
    @DatabaseField(dataType=DataType.STRING)    
    private String nome;
    
    @DatabaseField(dataType=DataType.STRING)        
    private String dataDeNascimento;
    
    @DatabaseField(dataType=DataType.STRING)        
    private String brinquedoFavorito;
    

//Start GetterSetterExtension Source Code
    /**GET Method Propertie nome*/
    public String getNome(){
        return this.nome;
    }//end method getNome

    /**SET Method Propertie nome*/
    public void setNome(String nome){
        this.nome = nome;
    }//end method setNome

    /**GET Method Propertie dataDeNascimento*/
    public String getDataDeNascimento(){
        return this.dataDeNascimento;
    }//end method getDataDeNascimento

    /**SET Method Propertie dataDeNascimento*/
    public void setDataDeNascimento(String dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }//end method setDataDeNascimento
    
    /**GET Method Propertie brinquedoFavorito*/
    public String getBrinquedoFavorito(){
        return this.brinquedoFavorito;
    }//end method getBrinquedoFavorito

    /**SET Method Propertie brinquedoFavorito*/
    public void setBrinquedoFavorito(String brinquedoFavorito){
        this.brinquedoFavorito = brinquedoFavorito;
    }//end method setBrinquedoFavorito

}//End class