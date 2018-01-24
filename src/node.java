/**
 * Created by Admin on 1/21/18.
 */
public class node {
    public node rt;
    public node lt;
    public String node;
    node(String a,node l,node r){
        rt=r;
        lt=l;
        node=a;
    }
    public String toString(){
        return node;
    }
}
