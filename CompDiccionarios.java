class CompDiccionarios<K,T> implements IComparator<K,T>{
    

    public int Compare(K abb1, K abb2){
        String key1 = (String)abb1;
        String key2 = (String)abb2;
        return key1.compareTo(key2);

    }
}