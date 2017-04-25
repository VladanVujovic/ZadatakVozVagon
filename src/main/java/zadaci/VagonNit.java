package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Vagon;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class VagonNit extends Thread{

    public String oznaka;
    public Vagon vagon;

    static Dao<Vagon, Integer> vagonDao;

    public VagonNit(String oznaka, Vagon vagon) {
        this.oznaka = oznaka;
        this.vagon = vagon;
    }

    public static void main(String[] args) {


        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            vagonDao = DaoManager.createDao(connectionSource, Vagon.class);

            List<Vagon> vagoni = vagonDao.queryForAll();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


