package com.thoughtworks.collection;

public interface SingleLink<T> {
    public T getHeaderData();
    public T getTailData();
    public int size();
    public boolean isEmpty();
    public boolean deleteFirst();
    public boolean deleteLast();                //删除尾部元素；
    public void addHeadPointer(T item);    //添加头指针
    default public void addTailPointer(T item){
        System.out.println("don't know this meaning of implement this");
    }       //添加尾指针
    public T getNode(int index);
}