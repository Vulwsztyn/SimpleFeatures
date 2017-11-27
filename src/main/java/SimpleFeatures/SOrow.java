package SimpleFeatures;

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
        while(string.charAt(i)!='<') i++;
        i++;
        while(string.charAt(i)!='>'){
            sBuffer.append(i);
            i++;
        }
        s=sBuffer.toString();
        o=oBuffer.toString();


    }
}
