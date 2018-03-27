CREATE KEYSPACE keyspace1 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
use keyspace1;

CREATE TABLE configuration (
        name ascii,
        value text,
        PRIMARY KEY ( name )
) WITH compression = { 'sstable_compression' : 'LZ4Compressor' };

-- Problem in String.split(";") here
-- https://github.com/mojohaus/cassandra-maven-plugin/blob/408653092ba659013984b7153e77b0545ac7e903/src/main/java/org/codehaus/mojo/cassandra/AbstractCqlExecMojo.java#L98
-- It cannot determine right line end.
INSERT INTO configuration (name,value) VALUES('config.name2', 'qqqqqq;wwwwwww');


