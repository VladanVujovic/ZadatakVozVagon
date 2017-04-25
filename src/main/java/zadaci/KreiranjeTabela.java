package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Vagon;
import model.Voz;

import java.sql.SQLException;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class KreiranjeTabela {


    public static void main(String[] args) {

        ConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            TableUtils.dropTable(connectionSource, Voz.class, true);
            TableUtils.dropTable(connectionSource, Vagon.class, true);


            TableUtils.createTable(connectionSource, Voz.class);
            TableUtils.createTable(connectionSource, Vagon.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
