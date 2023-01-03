package com.example.OnlineFoodOrder.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.example.OnlineFoodOrder.model.Menu;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

public class PDFGenerator {

	private List<Menu> menuList;

	public  PDFGenerator(List<Menu> menulists) {
		this.menuList = menulists;
	}

	private void writeTableHeader(PdfPTable table) {
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.pink);
		cell.setPadding(4);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.LIGHT_GRAY);

		cell.setPhrase(new Phrase("Menu_id", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Menu_name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Menu_price", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (Menu menu : menuList) {
			table.addCell(String.valueOf(menu.getMenu_id()));
			table.addCell(menu.getMenu_name());
			table.addCell(menu.getMenu_price());
		
		}
	}

	public void exportpdf(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);
		
		Paragraph p = new Paragraph("Menu Details:",font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
		table.setSpacingBefore(10);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();

	}
}
