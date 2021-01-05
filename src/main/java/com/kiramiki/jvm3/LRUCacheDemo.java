package com.kiramiki.jvm3;

import java.util.HashMap;

/**
 * LRU算法
 */
public class LRUCacheDemo {
    static class Node<K,V>{
        private K key;
        private V value;
        Node<K,V> prev;
        Node<K,V> next;



        Node(){
            this.prev = this.next = null;
        }
        Node(K key ,V value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    /**
     * 构建一个双向链表
     * @param <K>
     * @param <V>
     */
    static class DoubleLinkedNode<K,V>{
        Node<Integer,Integer> head = new Node<>();
        Node<Integer,Integer> tail = new Node<>();
        DoubleLinkedNode(){
            head.next = tail;
            tail.prev = head;
        }
        private void addNode(Node node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        private void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }
    private Integer cacheSize;
    HashMap<Integer,Node<Integer,Integer>> map;
    DoubleLinkedNode<Integer,Integer> doubleLinkedNode;

    /**
     * 构建一个哈希链表
     * @param cacheSize
     */
    LRUCacheDemo(Integer cacheSize){
        this.cacheSize = cacheSize;//坑位
        map = new HashMap<>();//查找
        doubleLinkedNode = new DoubleLinkedNode<>();
    }
    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        Node<Integer,Integer> node =map.get(key);
        doubleLinkedNode.removeNode(node);
        doubleLinkedNode.addNode(node);
        return node.value;
    }
    public void put(int key,int value){
        if (map.containsKey(key)){
            Node<Integer,Integer> node =map.get(key);
            node.value = value;
            map.put(key,node);
            doubleLinkedNode.removeNode(node);
            doubleLinkedNode.addNode(node);
        }else{
            if (map.size() == cacheSize){
                Node<Integer,Integer> last = doubleLinkedNode.tail.prev;
                doubleLinkedNode.removeNode(last);
                map.remove(last.key);
            }
            //新增
            Node<Integer,Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedNode.addNode(newNode);
        }
    }
    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);
        lruCacheDemo.put(1,1);
        lruCacheDemo.put(2,2);
        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(4,4);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3,1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3,1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5,5);
        System.out.println(lruCacheDemo.map.keySet());
    }
}
