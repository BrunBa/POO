import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class CatRepository
{
    private static Database database;
    private static Dao<Cat, Integer> dao;
    private List<Cat> loadedCats;
    private Cat loadedCat; 
    
    public CatRepository(Database database) {
        CatRepository.setDatabase(database);
        loadedCats = new ArrayList<Cat>();
    }
    
    public static void setDatabase(Database database) {
        CatRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Cat.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Cat.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Cat create(Cat Cat) {
        int nrows = 0;
        try {
            nrows = dao.create(Cat);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedCat = Cat;
            loadedCats.add(Cat);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Cat;
    }    

    public void update(Cat Cat) {
      // TODO
    }

    public void delete(Cat Cat) {
      // TODO
    }
    
    public Cat loadFromId(int id) {
        try {
            this.loadedCat = dao.queryForId(id);
            if (this.loadedCat != null)
                this.loadedCats.add(this.loadedCat);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCat;
    }    
    
    public List<Cat> loadAll() {
        try {
            this.loadedCats =  dao.queryForAll();
            if (this.loadedCats.size() != 0)
                this.loadedCat = this.loadedCats.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCats;
    }

    // getters and setters ommited...        
}