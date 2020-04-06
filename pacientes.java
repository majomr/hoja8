/* Universidad del Valle de Guatemala
Maria Jose Morales 19145
Hoja de Trabajo No. 8 
pacientes*/
import java.util.ArrayList; 
import java.util.*;

public class pacientes<E extends Comparable<E>>{
    ArrayList<String> info;
    ArrayList<String> orden = new ArrayList<String>();
    ArrayList<String> info2 = new ArrayList<String>();
    ArrayList<String> order = new ArrayList<String>();
    
    public pacientes(ArrayList<String> p){
		info = p;
    }
    //vector con las prioridades en orden
    public VectorHeap result(){
        VectorHeap data = new VectorHeap();
        for(int i=0; i<info.size(); i++){
            String partes[] = (info.get(i)).split(",");
            orden.add(partes[0]);
            info2.add(partes[0]);
            info2.add(partes[1]);
        }
        Collections.sort(orden);
        for(int i=0; i<orden.size(); i++){
            //int lugar = info2.indexOf(orden.get(i));
            String informacion = info2.get(i) + ", "+info2.get(i+1);
            order.add(informacion);      
        }
        for(int i=0; i<order.size(); i++){
            data.add(order.get(i));
        }
        return data;
    }
}