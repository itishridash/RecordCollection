package com.example.demo.service;

import java.util.Arrays;

public class RecordSequence<E> implements Record<E> {

	private static final int DEFAULT_CAPACITY = 5;

	private static final Object[] EMPTY_ELEMENTDATA = {};
	private Object[] object;

	public RecordSequence() {
		object = new Object[DEFAULT_CAPACITY];
	}

	@Override
	public int size() {

		int size = 0;
		int i = 0;

		while (i < this.object.length) {

			if (this.object[i] == null) {

			} else {
				size = size + 1;
			}

			i++;
		}

		return size;
	}

	@Override

	public boolean add(Object e) throws Exception {
		if (e == null) {

			throw new Exception("Entity can not be null");
		}

		int filled_space = size() % DEFAULT_CAPACITY;// 10-0

		int arr_num = size() / DEFAULT_CAPACITY;// 10-2

		if (arr_num != 0 && filled_space == 0) {

			arr_num = arr_num + 1;
			object = Arrays.copyOf(object, arr_num * DEFAULT_CAPACITY);
		}

		int j = 0;
		while (j < this.object.length) {

			if (this.object[j] == null) {

				this.object[j] = e;

				return true;
			}

			j++;
		}

		return false;
	}

	@Override

	public boolean remove(Object o) {

		int j = 0;

		boolean objectFound = false;

		Object[] object1;
		Object[] object2;

		while (j < size()) {

			if (this.object[j] != null && this.object[j].equals(o)) {

				object1 = Arrays.copyOfRange(object, 0, j);

				object2 = Arrays.copyOfRange(object, j + 1, size());

				System.arraycopy(object1, 0, object, 0, object1.length);
				System.arraycopy(object2, 0, object, object1.length, object2.length);
				object[size() - 1] = null;
				objectFound = true;
			}

			else {

				j++;
			}

			
		}

		return objectFound;
	}

	@Override

	public boolean removeAll() {
		this.object = EMPTY_ELEMENTDATA;

		return true;
	}

	@Override

	public Object get(Object o) {

		int j = 0;
		while (j < this.object.length) {

			if (this.object[j] != null && this.object[j].equals(o)) {

				return this.object[j];
			}

			j++;
		}

		return null;
	}

	@Override

	public Record<E> getAll(Object o) {

		Record r = new RecordSequence();

		int j = 0;

		while (j < this.object.length) {

			if (this.object[j] != null && this.object[j].equals(o)) {

				try {

					r.add(o);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			j++;
		}

		return r;
	}

	@Override

	public Object getByIndex(int i) {

		if (i > size()) {
			return null;
		}
		return this.object[i];
	}
}