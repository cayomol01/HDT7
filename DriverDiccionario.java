

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
            leedor1 = new Scanner(archivo_diccionario);
            leedor2 = new Scanner(archivo_oracion);
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
                arboli.Insert(palabras[0], new Diccionario(palabras[0],palabras[0],palabras[1],palabras[2]));
                arbole.Insert(palabras[1], new Diccionario(palabras[1],palabras[0],palabras[1],palabras[2]));
                arbolf.Insert(palabras[2], new Diccionario(palabras[2],palabras[0],palabras[1],palabras[2]));

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
    }
}