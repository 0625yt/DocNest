package com.example.hwpparsingserver;

import com.parse.document.DataExtractContext;
import com.parse.document.common.Const;
import com.parse.document.DocumentExtractorDocx;
import com.parse.document.FileDataExtractorDocx;

public class ParsingOutputDocx extends FileDataExtractorDocx {

	private DocumentExtractorDocx documentExtractorDocx = new DocumentExtractorDocx();
	private boolean toJson = false;

	public static void main(String[] args) {
		DataExtractContext context = new DataExtractContext();
		String fileName = "4.약관_신한CEO정기보험Ⅱ(무배당,보증비용부과형)_일반심사형_20230703_v2.2.docx";
		ParsingOutputDocx testInstance = new ParsingOutputDocx();
		testInstance.makeValue(context, testInstance.toJson, fileName);
	}

	public void makeValue(DataExtractContext context, boolean toJson, String fileName) {
		getDocxFiles(context, Const.YACK_GUAN_NAME, fileName);
		try {
			processDocument(context, Const.YACK_GUAN_NAME, documentExtractorDocx, toJson, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
