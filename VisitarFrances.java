class VisitarFrances<K,T> implements IVisitar<K,T>{
    

    @Override
    public void VisitarNodo(NodoArbol<K, T> arbol) {
        String arreglo = "";
        Diccionario actual = (Diccionario)arbol._value;
        arreglo = "   -Frances: " + actual.frances + ", Ingles: " + actual.ingles + ", Espanol: " + actual.espanol;
        System.out.println(arreglo);
        
    }

}