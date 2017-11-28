package SimpleFeatures;
import org.apache.jena.query.* ;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP ;
import java.util.*;

public class SPARQLquery
{
    private  ArrayList<String> rowStrings;
    private int numberOfRows;

    public SPARQLquery(String SPARQLendpoint)
    {
        Query query = QueryFactory.create(SPARQLendpoint);


        // Remote execution.
        try ( QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query) ) {


            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;


            // Execute.
            ResultSet rs = qexec.execSelect();
            numberOfRows=0;
            rowStrings = new ArrayList<>();
            while(rs.hasNext()) {
                String rowString=rs.nextSolution().toString();
                rowStrings.add(rowString);
                numberOfRows++;

            }



        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getRowString(int i){
        return rowStrings.get(i);
    }

    public ArrayList<String> getRowSrtingsList() {
        return rowStrings;
    }

    public int getNumberOfRows(){
        return numberOfRows;
    }

}