package com.dot.s3.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dot.s3.Data;
import com.dot.s3.repository.DataRepository;

@Repository
public class DataDAO {

	@Autowired
	private DataRepository dataRepository;

	public void saveData(List<Data> dataList) {
		dataRepository.save(dataList);
	}

	public List<Data> getData() {
		return dataRepository.findAll();
	}

}
