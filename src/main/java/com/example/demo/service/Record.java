package com.example.demo.service;

public interface Record<T> {

	public int size();

	public boolean add (Object e)throws Exception;

	public boolean remove (Object e);

	public boolean removeAll();

	public Object get(Object e);

	public Object getByIndex(int i);

	public Record<T> getAll(Object o);
}