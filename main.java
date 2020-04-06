/* Universidad del Valle de Guatemala
Maria Jose Morales 19145
Hoja de Trabajo No. 8 
Main*/
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue; 
import java.util.Vector;
public class main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//instance a scanner that reads what the user writes when we ask them to 
		String archive = "pacientes.txt";
		File fichero = new File(archive);
		Scanner s = null;
		String linea = "";
		ArrayList<String> pacientes = new ArrayList<String>();
		//guarda en un array list todos los pacientes 
		//we create a try that tries to read txt that catches if the txt does not exist
		try {
			//the scanner reads the file
			s = new Scanner(fichero);
			while(s.hasNextLine()){
				//what the scanner reads it saves it on linea
				linea = s.nextLine();
				String data[] = linea.split(",");//se separa la informacion por las comas que tiene el string
                linea = data[2]+", "+ data[0]+" con "+data[1]; //se reordena el strign como prioridad, nombre y enfermedad
				pacientes.add(linea); 
			}
		}
		//if the txt does not exist it prints the exception message
		catch (Exception ex) { 
			System.out.println("Mensaje: " + ex.getMessage());
		}
		//FInally we close the txt
		finally {
			try {
				if (s != null) {
					s.close();
				}
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		
		System.out.println("Ingrese el numero que desee implementar: \n1.  VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>\n2.  Java Collection Framework para el PriorityQueue");
		String opcion = scan.nextLine();
		if(opcion.equals("1")){
			//VectorHeap<String> pacientesH = new VectorHeap(pacientes);
			pacientes p = new pacientes(pacientes);
			VectorHeap resultado = p.result();
			System.out.println("Orden:");
			for(int i=0;i<resultado.size();i++){
				System.out.println(resultado.elementAt(i));
			}
		}
		else if(opcion.equals("2")){
			PriorityQueue<String> pacientesH2 = new PriorityQueue<String>(); 
			for(int i=0;i<pacientes.size();i++){
				pacientesH2.add(pacientes.get(i));//se agregan elementos
			}
			System.out.println("Orden:");
			while(!pacientesH2.isEmpty()){
				//mientras que el queue no este vacio lo y elimina
				System.out.println(pacientesH2.poll() + "\n");
			}
		}
		else{
			System.out.println("La opcion ingresada es incorrecta");
		}
	}
}