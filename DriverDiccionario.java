

import java.io.*;
import java.util.*;


class DriverDiccionario{

    public static void main(String[] args)throws Exception{
        String arch1 = new File("diccionario.txt").getAbsolutePath();
        String arch2 = new File("oracion.txt").getAbsolutePath();

        File archivo_diccionario = new File(arch1);
        File archivo_oracion = new File(arch2);

        Scanner leedor1 = null;
        Scanner leedor2 = null;
        Scanner scan = new Scanner(System.in);

        HashMap<String, String[]> dic = new HashMap<String, String[]>();

        String s = "";

        int opcion = 0;

        ArbolBinarioBusqueda<String, Diccionario> arbolf = new ArbolBinarioBusqueda<String, Diccionario>(new CompDiccionarios<String,Diccionario>(), 
                                                                                                         new CompKeyDiccionarios<String,Diccionario>()
                                                                                                        );
                                                                                                    
        ArbolBinarioBusqueda<String,Diccionario> arbole = new ArbolBinarioBusqueda<String, Diccionario>(new CompDiccionarios<String,Diccionario>(), 
                                                                                                      new CompKeyDiccionarios<String,Diccionario>()
                                                                                                    );
        ArbolBinarioBusqueda<String,Diccionario> arboli = new ArbolBinarioBusqueda<String, Diccionario>(new CompDiccionarios<String,Diccionario>(), 
                                                                                                        new CompKeyDiccionarios<String,Diccionario>()
                                                                                                        );


        String[] palabras;
        boolean fileOpened;

        try{
            leedor2 = new Scanner(archivo_oracion);
            leedor1 = new Scanner(archivo_diccionario);
            fileOpened = true;
        }catch(FileNotFoundException e){
            System.out.println("--- File Not Found! ---");
            fileOpened = false;
        }
        leedor1.useDelimiter("\\Z");
        leedor2.useDelimiter("\\Z");

        if(fileOpened){
            while(leedor1.hasNextLine()){
                palabras = leedor1.nextLine().split(",");
                arboli.Insert(palabras[0], new Diccionario(palabras[0],palabras[1],palabras[2]));
                arbole.Insert(palabras[1], new Diccionario(palabras[0],palabras[1],palabras[2]));
                arbolf.Insert(palabras[2], new Diccionario(palabras[0],palabras[1],palabras[2]));
                dic.put(palabras[0], palabras);

            }

            System.out.println("Inglés:");
            arboli.InOrder(new VisitarIngles<String, Diccionario>(), arboli._raiz);
            System.out.println(" ");
            System.out.println("Español");
            arbole.InOrder(new VisitarEspanol<String, Diccionario>(), arbole._raiz);
            System.out.println(" ");
            System.out.println("Frances");
            arbolf.InOrder(new VisitarFrances<String, Diccionario>(), arbolf._raiz);




        }


        String[] palabras2 = leedor2.nextLine().split(" ");

        //Quita el punto de la oración
        palabras2[palabras2.length -1] = palabras2[palabras2.length-1].substring(0,palabras2[palabras2.length-1].length()-1);

        
        System.out.println("\nPor favor eliga a que idioma desea traducir su oración");
        System.out.println("1. Español");
        System.out.println("2. Francés");
        opcion = scan.nextInt();
        if(opcion==1){
            for(int i = 0; i<palabras2.length; i++){
                if(dic.containsKey(palabras2[i])){
                    s+= dic.get(palabras2[i])[1] + " ";
                }
                else{
                    s+= "*" + palabras2[i] + "* ";
                }
            }
        }
        else if(opcion==2){
            for(int i = 0; i<palabras2.length; i++){
                if(dic.containsKey(palabras2[i])){
                    s+= dic.get(palabras2[i])[2] + " ";
                }
                else{
                    s+= "*" + palabras2[i] + "* ";
                }
            }
        }
        else{
            System.out.println("\nNo se pudo reconocer la opcion ingresada");
        }
        
    }
}