package SimpleFeatures;

import java.util.*;


public class App 
{
    public static void main(String[] args) {
        String inputHTTP="http://dbpedia.org/ontology/waterwayThroughTunnel";
        String inputQuery = "select ?s ?o where {?s <"+inputHTTP+"> ?o} order by ?o ?s";
        TableOfPairs sortedByO = new TableOfPairs(inputQuery);
        TableOfPairs sortedByS = new TableOfPairs(sortedByO);
        sortedByS.sortByS();
        Features features = new Features(sortedByS,sortedByO,0.9);
        features.printFeatures();
    }
}
