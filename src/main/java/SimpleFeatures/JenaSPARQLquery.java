package SimpleFeatures;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import java.util.ArrayList;
import java.util.List;

public class JenaSPARQLquery implements SPARQLquery {

    private ArrayList<SOrow> rows=new ArrayList<>();


    public JenaSPARQLquery(String SPARQLendpoint)
    {
        Query query = QueryFactory.create(SPARQLendpoint);


        // Remote execution.
        try ( QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query) ) {


            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;


            // Execute.
            ResultSet rs = qexec.execSelect();
            List<String> vars = rs.getResultVars();
            assert vars.size() == 2;
            while(rs.hasNext()) {
                QuerySolution solution=rs.nextSolution();
                Resource s = solution.getResource(vars.get(0));
                RDFNode o = solution.get(vars.get(1));
                rows.add(new SOrow(s, o));
            }



        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SOrow> getRows() {
        return rows;
    }

    public int getNumberOfRows(){
        return rows.size();
    }
}
