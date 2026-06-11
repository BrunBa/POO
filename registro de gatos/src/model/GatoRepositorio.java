package model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class GatoRepositorio
{
    private static Database database;
    private static Dao<Gato, Integer> dao;
    private List<Gato> loadedGatos;
    private Gato loadedGato;
    
    public GatoRepositorio(Database database) {
        GatoRepositorio.setDatabase(database);
        loadedGatos = new ArrayList<Gato>();
    }
    
    public static void setDatabase(Database database) {
        GatoRepositorio.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Gato.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Gato.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Gato create(Gato gato) {
        int nrows = 0;
        try {
            nrows = dao.create(gato);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedGato = gato;
            loadedGatos.add(gato);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gato;
    }    

    public void update(Gato Gato) {
      // TODO
    }

    public void delete(Gato Gato) {
      // TODO
    }
    
    public Gato loadFromId(int id) {
        try {
            this.loadedGato = dao.queryForId(id);
            if (this.loadedGato != null)
                this.loadedGatos.add(this.loadedGato);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedGato;
    }    
    
    public List<Gato> loadAll() {
        try {
            this.loadedGatos =  dao.queryForAll();
            if (this.loadedGatos.size() != 0)
                this.loadedGato = this.loadedGatos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedGatos;
    }

    // getters and setters ommited...        
}