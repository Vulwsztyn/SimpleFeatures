package SimpleFeatures;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        String inputQuery = "select ?s ?o where {?s <http://dbpedia.org/ontology/waterwayThroughTunnel> ?o} order by ?o ?s";
        SPARQLquery query = new SPARQLquery(inputQuery);
    }
}
