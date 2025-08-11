package com.example.hwpparsingserver;

import com.parse.document.DataExtractContext;
import com.parse.document.common.Const;
import com.parse.document.DocumentExtractorHwp;
import com.parse.document.FileDataExtractorHwp;

public class JsonFileOutput extends FileDataExtractorHwp {

	private DocumentExtractorHwp documentExtractorHwp = new DocumentExtractorHwp();
	private boolean toJson = true;
	
	public static void main(String[] args) {
		DataExtractContext context = new DataExtractContext();
		JsonFileOutput testInstance = new JsonFileOutput();

		String fileName = "";
		
		testInstance.makeValue(context, testInstance.toJson, fileName);
	}

	public void makeValue(DataExtractContext context,boolean toJson, String fileName) {
		getHWPFile(context, Const.YACK_GUAN_NAME, fileName);
		try {
			processDocument(context, Const.YACK_GUAN_NAME, documentExtractorHwp, toJson, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
