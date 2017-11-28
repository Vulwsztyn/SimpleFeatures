package SimpleFeatures;

import java.util.*;

public class TableOfPairs {
    private ArrayList<SOrow> rows;
    int numberOfRows;
    public  TableOfPairs(String queryString){
        this.rows=new ArrayList<SOrow>();
        SPARQLquery stringRows = new SPARQLquery(queryString);
        for (String stringRow: stringRows.getRowSrtingsList()){
            SOrow row = new SOrow(stringRow);
            rows.add(row);
        }
        numberOfRows=stringRows.getNumberOfRows();
     }
     public TableOfPairs(TableOfPairs oldOne){
        this.numberOfRows=oldOne.numberOfRows;
        this.rows=new ArrayList<>();
        this.rows.addAll(oldOne.rows);
     }
     public String getS(int i){
        return rows.get(i).getS();
     }
     public String getO(int i){
         return rows.get(i).getO();
     }
     public int getNumberOfRows(){return numberOfRows;}

    public ArrayList<SOrow> getRows() {
        return rows;
    }
    public void sortByS(){
        rows.sort(Comparator.comparing(SOrow::getS));
    }

    public boolean isThereSymmetry(SOrow oldRow){

        //to be used in sortedByO
        for(SOrow row:rows){
            int compareResult=row.getO().compareTo(oldRow.getO());
            if(compareResult>0) return false;
            if(compareResult==0) if(row.getS().compareTo(oldRow.getS())==0) return true;
        }
        return false;
    }
}
