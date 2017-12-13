package SimpleFeatures;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

public class SOrow{
    private Resource s;
    private RDFNode o;

    public SOrow(Resource s, RDFNode o) {
        this.s = s;
        this.o = o;
    }

    public Resource getS(){return s;}
    public RDFNode getO(){return o;}
    public void printO(){
        System.out.println(o);
    }
    public void printS(){
        System.out.println(s);
    }

}
