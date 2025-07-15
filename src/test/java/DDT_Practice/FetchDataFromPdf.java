package DDT_Practice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDataFromPdf {
	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/Form_pdf_839767110210724.pdf");
		
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		PDFTextStripper pdfData = new PDFTextStripper();
//		String data = pdfData.getText(doc);
//		System.out.println(data);
		
//		pdfData.setStartPage(9);
//		String data = pdfData.getText(doc);
//		System.out.println(data);
		
		pdfData.setStartPage(9);
		pdfData.setEndPage(9);
		String data = pdfData.getText(doc);
		System.out.println(data);
		
	}

}
