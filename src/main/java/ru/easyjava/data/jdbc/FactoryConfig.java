package ru.easyjava.data.jdbc;

import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Simple example of c3p0 factory instantiation.
 */
public final class FactoryConfig {

    /**
     * Do not construct me.
     */
    private FactoryConfig() {
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     * @throws SQLException when something goes wrong.
     */
    public static void main(final String[] args) throws SQLException {
        DataSource rawDs = DataSources.unpooledDataSource(
                "jdbc:postgresql://192.168.75.6/test",
                "test",
                "test");
        DataSource ds = DataSources.pooledDataSource(rawDs);

        try {
            PoolTest.runParallelQueries(ds);
        } catch (InterruptedException ex) {
            System.out.println("Execution failure: "
                    + ex.getMessage());
        }

    }

}
