package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.RecordSequence;

@SpringBootTest

public class RecordSequenceTest {

	RecordSequence<String> record = new RecordSequence<String>();

	@Test

	public void testAdd() throws Exception {

		record.add("Emma");

		record.add("Ronan");

		assertEquals("Adding 2 entity to record", 2, record.size());

	}

	@Test

	public void testSize() throws Exception {

		record.add("Emma");

		record.add("Ronan");

		record.add("Antonio");
		assertEquals("Checking size of record", 3, record.size());

	}

	@Test

	public void testRemove() throws Exception {

		record.add("Antonio");

		record.add("Paul");

		record.remove("Paul");

		assertEquals("Removing 1 entity from record", 1, record.size());
	}

	@Test

	public void testRemoveAll() throws Exception {

		record.add("Antonio");

		record.add("Paul");

		record.removeAll();

		assertEquals("Removing all entity", 0, record.size());
	}

	@Test

	public void testGet() throws Exception {

		record.add("Antonio");
		record.add("Paul");

		assertEquals("get first entity that matches entity", "Antonio", record.get("Antonio"));
	}

	@Test

	public void testGetNotPresentInRecord() throws Exception {

		record.add("Antonio");

		record.add("Paul");

		assertEquals("test for not present entity", null, record.get("Itishri"));
	}

	@Test

	public void testSizeWithNull() {

		Exception exception = assertThrows(Exception.class, () ->

		record.add(null));

		assertEquals("Entity can not be null", exception.getMessage());
	}

	@Test

	public void testGetAll() throws Exception {

		record.add("Antonio");

		record.add("Paul");

		record.add("Antonio");

		assertEquals("get all entity that matches entity", 2, record.get("Antonio"));
	}
}