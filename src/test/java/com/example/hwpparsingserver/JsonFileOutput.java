package com.example.hwpparsingserver;

import com.parse.document.DataExtractContext;
import com.parse.document.DocumentExtractorDocx;
import com.parse.document.common.Const;
import com.parse.document.FileDataExtractorDocx;

public class JsonFileOutput extends FileDataExtractorDocx {

	private final DocumentExtractorDocx documentExtractorDocx = new DocumentExtractorDocx();
	private boolean toJson = true;

	public static void main(String[] args) {
		DataExtractContext context = new DataExtractContext();
		JsonFileOutput testInstance = new JsonFileOutput();

		String fileName = "4.약관_신한CEO정기보험Ⅱ(무배당,보증비용부과형)_일반심사형_20230703_v2.2.docx";

		testInstance.makeValue(context, testInstance.toJson, fileName);
	}

	public void makeValue(DataExtractContext context,boolean toJson, String fileName) {
		getDocxFiles(context, Const.YACK_GUAN_NAME, fileName);
		try {
			processDocument(context, Const.YACK_GUAN_NAME, documentExtractorDocx, toJson, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
