package SimpleFeatures;
import org.apache.jena.query.* ;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP ;
import java.util.*;

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
            while(rs.hasNext()) {
                String rowString=rs.nextSolution().toString();
                System.out.println(rowString);

            }




//ResultSetFormatter.out(System.out, rs, query);
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//| s                                                                                     | o                                                            |
//========================================================================================================================================================
//| <http://dbpedia.org/resource/Greywell_Tunnel>                                         | <http://dbpedia.org/resource/Basingstoke_Canal>              |
//| <http://dbpedia.org/resource/Netherton_Tunnel_Branch_Canal>                           | <http://dbpedia.org/resource/Birmingham_Canal_Navigations>   |
//| <http://dbpedia.org/resource/Chalifert_Tunnel>                                        | <http://dbpedia.org/resource/Canal_de_Meaux_à_Chalifert>     |
//| <http://dbpedia.org/resource/Riqueval_Tunnel>                                         | <http://dbpedia.org/resource/Canal_de_Saint-Quentin>         |
//| <http://dbpedia.org/resource/Norwood_Tunnel>                                          | <http://dbpedia.org/resource/Chesterfield_Canal>             |
//| <http://dbpedia.org/resource/Butterley_Tunnel>                                        | <http://dbpedia.org/resource/Cromford_Canal>                 |
//| <http://dbpedia.org/resource/Dudley_Tunnel>                                           | <http://dbpedia.org/resource/Dudley_Canal>                   |
//| <http://dbpedia.org/resource/Lapal_Tunnel>                                            | <http://dbpedia.org/resource/Dudley_Canal>                   |
//| <http://dbpedia.org/resource/Blisworth_Tunnel>                                        | <http://dbpedia.org/resource/Grand_Union_Canal>              |
//| <http://dbpedia.org/resource/Braunston_Tunnel>                                        | <http://dbpedia.org/resource/Grand_Union_Canal>              |
//| <http://dbpedia.org/resource/Shrewley_Tunnel>                                         | <http://dbpedia.org/resource/Grand_Union_Canal>              |
//| <http://dbpedia.org/resource/Standedge_Tunnels>                                       | <http://dbpedia.org/resource/Huddersfield_Narrow_Canal>      |
//| <http://dbpedia.org/resource/Bruce_Tunnel>                                            | <http://dbpedia.org/resource/Kennet_and_Avon_Canal>          |
//| <http://dbpedia.org/resource/Laramie-Poudre_Tunnel>                                   | <http://dbpedia.org/resource/Laramie_River>                  |
//| <http://dbpedia.org/resource/Chirk_Tunnel>                                            | <http://dbpedia.org/resource/Llangollen_Canal>               |
//| <http://dbpedia.org/resource/Raúl_Uranga_–_Carlos_Sylvestre_Begnis_Subfluvial_Tunnel> | <http://dbpedia.org/resource/Paraná_River>                   |
//| <http://dbpedia.org/resource/Eyre's_Tunnel>                                           | <http://dbpedia.org/resource/Regent's_Canal>                 |
//| <http://dbpedia.org/resource/Maida_Hill_Tunnel>                                       | <http://dbpedia.org/resource/Regent's_Canal>                 |
//| <http://dbpedia.org/resource/Islington_Tunnel>                                        | <http://dbpedia.org/resource/Regents_Canal>                  |
//| <http://dbpedia.org/resource/Berwick_Tunnel>                                          | <http://dbpedia.org/resource/Shrewsbury_Canal>               |
//| <http://dbpedia.org/resource/Sapperton_Canal_Tunnel>                                  | <http://dbpedia.org/resource/Thames_and_Severn_Canal>        |
//| <http://dbpedia.org/resource/Harecastle_Tunnel>                                       | <http://dbpedia.org/resource/Trent_and_Mersey_Canal>         |
//| <http://dbpedia.org/resource/Wast_Hills_Tunnel>                                       | <http://dbpedia.org/resource/Worcester_and_Birmingham_Canal> |
//            --------------------------------------------------------------------------------------------------------------------------------------------------------
//            while( rs.hasNext() ){
//                System.out.println(rs.nextSolution());
//                break;
//            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}