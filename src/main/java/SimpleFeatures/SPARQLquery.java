package SimpleFeatures;
import org.apache.jena.query.* ;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP ;

public class SPARQLquery
{
    public SPARQLquery(String SPARQLendpoint)
    {
        Query query = QueryFactory.create(SPARQLendpoint);


        // Remote execution.
        try ( QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query) ) {


            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;


            // Execute.
            ResultSet rs = qexec.execSelect();
            ResultSetFormatter.out(System.out, rs, query);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}