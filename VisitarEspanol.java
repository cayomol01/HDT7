public class VisitarEspanol<K,T> implements IVisitar<K,T> {


    @Override
    public void VisitarNodo(NodoArbol<K, T> arbol) {
        String arreglo = "";
        Diccionario actual = (Diccionario)arbol._value;
        arreglo = "   -Espanol: " + actual.espanol + ", Ingles: " + actual.ingles + ", Frances: " + actual.frances;
        System.out.println(arreglo);
        
    }

}
