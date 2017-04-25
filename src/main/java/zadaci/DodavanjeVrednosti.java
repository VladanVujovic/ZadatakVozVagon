package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Vagon;
import model.Voz;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class DodavanjeVrednosti {


    static Dao<Voz, Integer> vozDao;
    static Dao<Vagon, Integer> vagonDao;


    public static void main(String[] args) {

        ConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            vozDao = DaoManager.createDao(connectionSource, Voz.class);
            vagonDao = DaoManager.createDao(connectionSource, Vagon.class);


            Voz v1 = new Voz("Voz1", "Dizel");
            vozDao.create(v1);

            Voz v2 = new Voz("Voz2", "Elektricni");
            vozDao.create(v2);

            Vagon g1 = new Vagon("Vagon1", "Za prenos goriva", 10, v1 );
            g1.setVoz(v1);
            vagonDao.create(g1);

            Vagon g2 = new Vagon("Vagon2", "Za prenos toksicnih materijala", 15,  v2);
            g2.setVoz(v1);
            vagonDao.create(g2);


            Vagon g3 = new Vagon("Vagon3", "Za prenos psenice", 20,  v1);
            g3.setVoz(v1);
            vagonDao.create(g3);

            Vagon g4 = new Vagon("Vagon4", "Za spavanje", 5,  v2);
            g4.setVoz(v2);
            vagonDao.create(g4);

            Vagon g5 = new Vagon("Vagon5", "Restoran", 3,  v2);
            g5.setVoz(v2);
            vagonDao.create(g5);

            List<Voz> vozovi = vozDao.queryForAll();
            for (Voz v: vozovi){
                System.out.println("Voz: " + v);
            }

            List<Vagon> vagoni = vagonDao.queryForAll();
            for (Vagon g: vagoni){
                System.out.println("Vagon: " + g);
            }



        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}

