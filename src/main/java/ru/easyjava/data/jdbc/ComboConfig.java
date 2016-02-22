package ru.easyjava.data.jdbc;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

import static ru.easyjava.data.jdbc.PoolTest.runParallelQueries;

/**
 * Simple example of c3p0 direct instantiation.
 */
public final class ComboConfig {

    /**
     * Do not construct me.
     */
    private ComboConfig() {
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     * @throws PropertyVetoException when something goes wrong.
     */
    public static void main(final String[] args) throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("org.postgresql.Driver");
        ds.setUser("test");
        ds.setPassword("test");
        ds.setJdbcUrl("jdbc:postgresql://192.168.75.6/test");

        try {
            runParallelQueries(ds);
        } catch (InterruptedException ex) {
            System.out.println("Execution failure: "
                    + ex.getMessage());

        }

    }

}
