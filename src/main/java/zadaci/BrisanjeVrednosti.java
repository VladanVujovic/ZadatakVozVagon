package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Vagon;
import model.Voz;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class BrisanjeVrednosti {

    static Dao<Voz, Integer> vozDao;
    static Dao<Vagon, Integer> vagonDao;


    public static void main(String[] args) {

        ConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            vozDao = DaoManager.createDao(connectionSource, Voz.class);
            vagonDao = DaoManager.createDao(connectionSource, Vagon.class);

            List<Vagon> vagoni = vagonDao.queryForAll();
            for (Vagon g: vagoni){
                System.out.println("Vagon: " + g);
            }

            vagoni = vagonDao.queryForEq(Vagon.POLJE_NOSIVOST, 10);

            Vagon vagon = vagoni.get(0);

            vagonDao.delete(vagoni);

            vagoni = vagonDao.queryForAll();
            for(Vagon g: vagoni){
                System.out.println("Vagon: " + g);
            }





        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
