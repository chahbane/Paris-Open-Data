package com.dot.s3.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dot.s3.Data;
import com.dot.s3.dao.DataDAO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class UploadService {

	@Autowired
	private DataDAO dataDAO;

	public String uploadFile(MultipartFile multipartFile) throws IOException {

		File file = convertMultiPartToFile(multipartFile);


		try (Reader reader = new FileReader(file);) {
			@SuppressWarnings("unchecked")
			CsvToBean<Data> csvToBean = new CsvToBeanBuilder<Data>(reader).withType(Data.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Data> dataList = csvToBean.parse();

			dataDAO.saveData(dataList);
		}
		return "uploaded with succes";
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	public List<Data> getdatas() {
		return dataDAO.getData();
	}
}