package home;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class home {

public static void main(String args[])	{
	Scanner scanner = new Scanner (System.in);
	ArrayList<String> UserNames = new ArrayList<>();
	int option;
	float question; 
	question = 1;
	do	{
	System.out.println("=== Seleccione un procesos ===");
	System.out.println("1. Ingresar productos e organizarlos.");
	System.out.println("2. Leer archivo");
	System.out.println("3. Salir");
	System.out.print("- ");
	
	option = scanner.nextInt();
	
	switch (option)	{
	case 1: 
		System.out.println("Ingrese los nombres de clientes");
		while (question == 1) {
			System.out.print("- ");
			scanner.nextLine();
			String Users = scanner.nextLine();
			UserNames.add(Users);
			System.out.println("Decea ingresar otro? (Si = 1 ; No = 0)");
			System.out.print("- ");
			question = scanner.nextInt();	
		};	
	System.out.println("= Lista de usuarios =");
	System.out.println(UserNames);
	System.out.println("= Lista de usuarios ordenanda =");
	ordenarPorBurbuja(UserNames);
	System.out.println(UserNames);
	
	try {
		String UserFile = "UserNamesFile.txt";
		FileWriter writer = new FileWriter(UserFile);
		for (String UserName : UserNames)	{
			writer.write(UserNames + "/n");
		}
		writer.close();	
	}catch(IOException  e) {
		System.out.println("Error al crear el archivo");
	}
	break;
	case 2:
		System.out.println("Contenido de UserNameFile.txt");
		try{
			FileReader reader = new FileReader ("UserNameFIle.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);		
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
		}catch(IOException e)	{
			System.out.println("El archivo no se pudo leer");
		}
	break;
	case 3:
		System.out.println("gracias");
	default:
		System.out.println("Error, Intente de nuevo (1-3)");
	break;
	}
	}while(option != 1 || option != 2 || option != 3);
}
public static void ordenarPorBurbuja(ArrayList<String> array) {
    int n = array.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                String temp = array.get(j);
                array.set(j, array.get(j + 1));
                array.set(j + 1, temp);
            }
        }
    }
}

}