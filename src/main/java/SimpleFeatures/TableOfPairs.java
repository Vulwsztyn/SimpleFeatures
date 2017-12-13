package SimpleFeatures;

import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;

import java.util.*;

public class TableOfPairs {
    private ArrayList<SOrow> rows;
    int numberOfRows;
    public  TableOfPairs(SPARQLquery stringRows){
        this.rows= new ArrayList<>(stringRows.getRows());
        numberOfRows=stringRows.getNumberOfRows();
     }
     public TableOfPairs(TableOfPairs oldOne){
        this.numberOfRows=oldOne.numberOfRows;
        this.rows=new ArrayList<>();
        this.rows.addAll(oldOne.rows);
     }
     public Resource getS(int i){
        return rows.get(i).getS();
     }
     public RDFNode getO(int i){
         return rows.get(i).getO();
     }
     public int getNumberOfRows(){return numberOfRows;}

    public ArrayList<SOrow> getRows() {
        return rows;
    }
    public void sortByS(){
        rows.sort(Comparator.comparing((x) -> x.getS().toString()));
    }

    // TODO: ta funkcja nie powinna być w tej klasie, to dosc mocno psuje podzial odpowiedzialnosci
    // TODO: toString() powinny zostac stad usuniete i nalezy to rozwiazac jakos inaczej
    public boolean isThereSymmetry(SOrow oldRow){

        //to be used in sortedByO
        for(SOrow row:rows){
            int compareResult=row.getO().toString().compareTo(oldRow.getO().toString());
            if(compareResult>0) return false;
            if(compareResult==0) if(row.getS().toString().compareTo(oldRow.getS().toString())==0) return true;
        }
        return false;
    }
}
