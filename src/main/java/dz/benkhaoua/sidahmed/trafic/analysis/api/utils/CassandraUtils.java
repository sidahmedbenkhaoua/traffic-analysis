package dz.benkhaoua.sidahmed.trafic.analysis.api.utils;

import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public final class CassandraUtils {

    public static final int EMBEDDED_CASSANDRA_SERVER_WAITING_TIME = 10000;

    private CassandraUtils() {
    }

    static Session startCassandra() throws Exception {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Thread.sleep(EMBEDDED_CASSANDRA_SERVER_WAITING_TIME);
        Cluster cluster = new Cluster.Builder().addContactPoints("localhost")
                .withPort(9142).build();
        Session session = cluster.connect();
        return session;
    }
}