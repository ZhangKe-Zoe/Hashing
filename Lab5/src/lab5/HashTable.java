/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author apple
 */
public class HashTable<Key, Value> {
    private int M;
    private Value[] values;   
    private Key[] keys;   
    //Task1.b Add a constructor, takes custom integer M’s to determine the size of the HashTable
    public HashTable(int M) {
        this.M = M;  
        this.values = (Value[]) new Object[M];
        this.keys = (Key[]) new Object[M];
    }   
    //Task1.c Add a method to the HashTable public boolean isColliding(Key key)
    public boolean isColliding(Key key){
    //true, if the hash of key is already in the list but the keys are different
    if(get(key)!=null && !key.equals(keys[hash(key)])) return true;
    //false if the key is not set (null) or the keys are equal
    else return false;
//    Key element = keys[hash(key)];
//    return(element == null)?false:!key.equals(element);
    } 
    private int hash(Key key) { 
        return (key.hashCode()&0x7fffffff)%M;
    }
    public void put(Key key, Value value) { 
        //int keyHash = key.hashCode();
        keys[hash(key)] = key;
        values[hash(key)] = value;      
    }
    public Value get(Key key) { 
        //int keyHash = key.hashCode();
        return values[hash(key)];
    }
}
