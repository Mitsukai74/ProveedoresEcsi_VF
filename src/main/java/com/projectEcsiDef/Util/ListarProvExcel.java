package com.projectEcsiDef.Util;

import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarProvExcel extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Creando el archivo con la respectiva ruta	
				response.setHeader("Content-Disposition", "attachment; filename=\"listado_prov.xls\"");
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		
	}

}
