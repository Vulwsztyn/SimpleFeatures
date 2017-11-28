package SimpleFeatures;

import java.util.Comparator;

public class SOrow{
    private String s;
    private String o;


    public SOrow(String string){
        int i=0;
        StringBuffer sBuffer= new StringBuffer("");
        StringBuffer oBuffer = new StringBuffer("");
        while(string.charAt(i)!='<') i++;
                i++;
        while(string.charAt(i)!='>'){
            oBuffer.append(string.charAt(i));
            i++;
        }
        while(string.charAt(i)!='<') {
            i++;
        }
        i++;
        while(string.charAt(i)!='>'){
            sBuffer.append(string.charAt(i));
            i++;
        }
        s=sBuffer.toString();
        o=oBuffer.toString();
    }
    public String getS(){return this.s;}
    public String getO(){return o;}
    public void printO(){
        System.out.println(o);
    }
    public void printS(){
        System.out.println(s);
    }

}
