import java.util.ArrayList;
import java.util.List;

public class GenericList <T>{
    private List<T> list;

    public GenericList(){
        list = new ArrayList<T>();
    }
    public void add(T element){
        list.add(element);
    }

    public void delete(T element){
        list.remove(element);
    }
    public String listElements(){
        StringBuilder sb = new StringBuilder();
        int i=0;
        for (T element : list){
            sb.append("Element "+i+" : "+element.toString());
        }
        return sb.toString();
    }


}
