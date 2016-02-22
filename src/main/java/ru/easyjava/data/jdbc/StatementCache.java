package ru.easyjava.data.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import static ru.easyjava.data.jdbc.PoolTest.runParallelQueries;

/**
 * Simple example of c3p0 statement cache enable.
 */
public final class StatementCache {
    /**
     * c3p0 statement cache size.
     */
    private static final Integer STATEMENT_CACHE_SIZE = 128;


    /**
     * Do not construct me.
     */
    private StatementCache() {
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     */
    public static void main(final String[] args) {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser("test");
        ds.setPassword("test");
        ds.setJdbcUrl("jdbc:postgresql://192.168.75.6/test");
        ds.setMaxStatements(STATEMENT_CACHE_SIZE);

        try {
            runParallelQueries(ds);
        } catch (InterruptedException ex) {
            System.out.println("Execution failure: "
                    + ex.getMessage());

        }

    }
}
