import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashTables {
    public static void main(String[] args) {
        // HASHMAP - Armazena pares (chave,valor), permite null
        System.out.println("HASHMAP:");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("user1", 1234);
        hashMap.put("user2", 5432);
        System.out.println("Valor do usuário 1: " + hashMap.get("user1"));
        //também é possível ver o tamanho do hashmap
        System.out.println("Tamanho do HashMap: " + hashMap.size());
        //e é possível printar o hashMap
        System.out.println(hashMap.keySet());

        System.out.println();


        // HASHTABLE - Não permite null, é sincronizado (seguro para múltiplas threads)
        // bem parecido com o hashmap
        System.out.println("HASHTABLE");
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("user1", 1997);
        hashtable.put("user2", 1990);
        hashtable.put("user3", 10);
        System.out.println("Valor do usuário 1: " + hashtable.get("user1"));
        //também é possível ver o tamanho do hashtable
        System.out.println("Tamanho do Hashtable: " + hashtable.size());
        //e é possível printar o hashtable
        System.out.println(hashtable.keySet());
        System.out.println();

        // LINKEDHASHMAP - Mantém a ordem de inserção das chaves
        System.out.println("LINKEDHASHMAP");
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("user1", 1000);
        linkedHashMap.put("user2", 2000);
        System.out.println("Valor de Primeiro: " + linkedHashMap.get("user1"));
        //também é possível ver o tamanho do linkedHashMap
        System.out.println("Tamanho do linkedHashMap: " + linkedHashMap.size());
        //e é possível printar o linkedHashMap
        System.out.println(linkedHashMap.keySet());
        System.out.println();


        // CONCURRENTHASHMAP - Suporta múltiplas threads sem problemas de sincronização
        System.out.println("CONCURRENTHASHMAP");
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("user1", 6000);
        concurrentHashMap.put("user2", 7000);
        System.out.println("Valor de user1: " + concurrentHashMap.get("user1"));
        //também é possível ver o tamanho do concurrentHashMap
        System.out.println("Tamanho do ConcurrentHashMap: " + concurrentHashMap.size());
        //e é possível printar o concurrentHashMap
        System.out.println(concurrentHashMap.keySet());
        System.out.println();

        // HASHSET - Armazena apenas valores únicos, sem ordem, não precisa de key
        System.out.println("HASHSET:");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("user1");
        hashSet.add("user2");
        hashSet.add("user2");  // Tentando adicionar valor duplicado
        //e é possível printar o hashSet porém ele n tem o keySet pois n tem key
        System.out.println("Valores no HashSet: " + hashSet);
        //também é possível ver o tamanho do hashSet
        System.out.println("Tamanho do HashSet: " + hashSet.size());
        System.out.println();
    }
}
