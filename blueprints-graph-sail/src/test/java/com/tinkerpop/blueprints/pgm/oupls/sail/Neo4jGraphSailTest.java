package com.tinkerpop.blueprints.pgm.oupls.sail;

import com.tinkerpop.blueprints.pgm.IndexableGraph;
import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
import org.junit.Test;

/**
 * @author Joshua Shinavier (http://fortytwo.net)
 */
public class Neo4jGraphSailTest {//extends GraphSailTest {

    private String getWorkingDirectory() {
        String directory = System.getProperty("neo4jGraphDirectory");
        if (directory == null) {
            if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                directory = "C:/temp/blueprints_test";
            else
                directory = "/tmp/blueprints_test";
        }
        return directory;
    }

    /*
    @Test
    public void testEvalNew() throws Exception {
        Neo4jGraph graph;
        Sail sail = null;
        deleteDirectory(new File(getWorkingDirectory()));
        graph = new Neo4jGraph(getWorkingDirectory());
        sail = new GraphSail(graph);
        sail.initialize();
        RepositoryConnection rc = new
                SailRepository(sail).getConnection();
        try {
            rc.add(SailTest.class.getResourceAsStream("graph-example-sparql.ttl"),
                    "http://example.org/baseURI/",
                    RDFFormat.TURTLE);
            rc.commit();
            System.out.println("Execute SPARQL query");
            TupleQuery query = rc.prepareTupleQuery(QueryLanguage.SPARQL,
                    "PREFIX ctag: <http://commontag.org/ns#> " +
                            "SELECT ?tag ?label " +
                            "WHERE { " +
                            "?tag ctag:label ?label . " +
                            "}");
            System.out.println("TupleQuery");
            TupleQueryResult result = query.evaluate();
            System.out.println("TupleQueryResults:");
            while (result.hasNext()) {
                System.out.println(result.next());
            }
        } finally {
            rc.close();
            sail.shutDown();
        }
    }
    */

    @Test
    public void testSelfEdgesNotSupported() throws Exception {

    }

    protected IndexableGraph createGraph() {
        String directory = System.getProperty("neo4jGraphDirectory");
        if (directory == null)
            directory = this.getWorkingDirectory();
        return new Neo4jGraph(directory);
    }
}