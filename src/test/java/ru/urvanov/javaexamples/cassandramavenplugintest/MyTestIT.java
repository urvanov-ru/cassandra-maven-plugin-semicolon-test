package ru.urvanov.javaexamples.cassandramavenplugintest;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyTestIT {

    @Test
    public void test1() {

        //queries
        String query = "SELECT * FROM configuration";

        //Creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

        //Creating Session object
        Session session = cluster.connect("keyspace1");

        //Getting the ResultSet
        ResultSet result = session.execute(query);
        List<String> values = new ArrayList<>();
        result.forEach(item -> values.add(item.getString("value")));
        assertEquals("qqqqqq;wwwwwww", values.get(0));
    }
}
