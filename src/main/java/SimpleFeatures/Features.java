package SimpleFeatures;

import java.util.Objects;

public class Features {
    private boolean functional;
    private boolean inverseFunctional;
    private boolean reflexive;
    private boolean irreflexive;
    private boolean symmetric;
    private boolean asymmetric;
    private int n;
    private int ns;
    private int no;

    public Features(TableOfPairs sortedByS, TableOfPairs sortedByO, double t){
        n=sortedByS.getNumberOfRows();
        no=1;
        ns=1;
        int functionalCounter=0;
        int invFunCoounter=0;
        int reflexiveCounter=0;
        int symmetricCounter=0;
        for(int i=0;i<n;i++){
            if(i>0){
                if(sortedByO.isThereSymmetry(sortedByS.getRows().get(i))) symmetricCounter++;
                if(Objects.equals(sortedByS.getO(i),sortedByS.getS(i)))reflexiveCounter++;
                if(!Objects.equals(sortedByS.getS(i), sortedByS.getS(i-1))) {
                    ns++;
                    if (i<n-1)
                    {
                        if(!Objects.equals(sortedByS.getS(i), sortedByS.getS(i+1))) functionalCounter++;
                    }
                    else functionalCounter++;


                }
                if(!Objects.equals(sortedByO.getO(i), sortedByO.getO(i-1))){
                    no++;
                    if(i<n-1){
                        if(!Objects.equals(sortedByO.getO(i), sortedByO.getO(i+1))) invFunCoounter++;
                    }
                    else invFunCoounter++;
                }
            }
            else{
                if(!Objects.equals(sortedByS.getS(i), sortedByS.getS(i+1))) functionalCounter++;
                if(!Objects.equals(sortedByO.getO(i), sortedByO.getO(i+1))) invFunCoounter++;
            }
        }
        functional = functionalCounter / ns >= t;
        inverseFunctional = invFunCoounter / no >= t;
        reflexive = reflexiveCounter / ns >= t;
        irreflexive = 1-reflexiveCounter / ns>t;
        symmetric=symmetricCounter / ns>=t;
        asymmetric=1-symmetricCounter/ns>=t;
    }
    public void printFeatures(){
        if(functional) System.out.println("functional, ");
        if(inverseFunctional) System.out.println("inverse-functional, ");
        if(reflexive) System.out.println("reflexive, ");
        if(irreflexive) System.out.println("irreflexive, ");
        if(symmetric) System.out.println("symmetric, ");
        if(asymmetric) System.out.println("asymmetric, ");
    }
}
