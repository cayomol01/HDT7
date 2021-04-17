public class VisitarIngles<K,T> implements IVisitar<K,T> {


    @Override
    public void VisitarNodo(NodoArbol<K, T> arbol) {
        String arreglo = "";
        Diccionario actual = (Diccionario)arbol._value;
        arreglo = "   -Ingles: " + actual.ingles + ", Español: " + actual.espanol + ", Frances: " + actual.frances;
        System.out.println(arreglo);
        
    }
    
}
