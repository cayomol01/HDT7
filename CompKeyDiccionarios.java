public class CompKeyDiccionarios<K,T> implements IKeyCalculator<K,T> {
    

    public K GetKey(T value){

        Diccionario  palabra = (Diccionario)value;
        return (K)palabra.key; 

    }
}