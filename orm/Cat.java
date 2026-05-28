import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "cat")
public class Cat
{       
    @DatabaseField
    private String Name;
    
    @DatabaseField
    public String favToy;
    
    @DatabaseField(dataType=DataType.DATE)
    public Date birthday;    
    
    public String printBirthday() {
        SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
        return dateFor.format(birthday);
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie Name*/
    public String getName(){
        return this.Name;
    }//end method getName

    /**SET Method Propertie Name*/
    public void setName(String Name){
        this.Name = Name;
    }//end method setName

    /**GET Method Propertie favToy*/
    public String getfavToy(){
        return this.favToy;
    }//end method getfavToy

    /**SET Method Propertie favToy*/
    public void setfavToy(String favToy){
        this.favToy = favToy;
    }//end method setfavToy

    /**GET Method Propertie birthday*/
    public Date getBirthday(){
        return this.birthday;
    }//end method getBirthday

    /**SET Method Propertie birthday*/
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }//end method setBirthday

//End GetterSetterExtension Source Code


}//End class