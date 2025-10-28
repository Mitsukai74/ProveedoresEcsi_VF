package com.projectEcsiDef.Servicios;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.projectEcsiDef.Entidades.Proveedores;

@Service
public class ServiceExcel {
	
	public byte[] generarExcelProveedores(List<Proveedores> listaProveedores) throws IOException {
        // Crear un nuevo libro de Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet hoja = (Sheet) workbook.createSheet("Proveedores");

        // Crear la fila de encabezado
        Row filaTitulo = ((org.apache.poi.ss.usermodel.Sheet) hoja).createRow(0);
        Cell celda = filaTitulo.createCell(0);
        celda.setCellValue("Listado de proveedores");

        // Crear la fila con los títulos de las columnas
        Row filaData = ((org.apache.poi.ss.usermodel.Sheet) hoja).createRow(2);
        String[] columnas = {"NIT", "Código ECSI", "Razón social", "Dirección", "Teléfono", "Código de Mun",
                "Código de Depto","Correo electrónico", "Actividad económica","Tipo Prov","Fecha creación"};

        for (int i = 0; i < columnas.length; i++) {
            celda = filaData.createCell(i);
            celda.setCellValue(columnas[i]);
        }

        // Llenar el Excel con los datos de la lista de proveedores
        int numFila = 3;
        for (Proveedores proveedor : listaProveedores) {
            filaData = ((org.apache.poi.ss.usermodel.Sheet) hoja).createRow(numFila);

            filaData.createCell(0).setCellValue(proveedor.getNit());
            filaData.createCell(1).setCellValue(proveedor.getCodigoEcsi());
            filaData.createCell(2).setCellValue(proveedor.getRazonSocial());
            filaData.createCell(3).setCellValue(proveedor.getDireccion());
            filaData.createCell(4).setCellValue(proveedor.getTelefono());
            filaData.createCell(5).setCellValue(proveedor.getCodMun());
            filaData.createCell(6).setCellValue(proveedor.getCodDepto());
            filaData.createCell(7).setCellValue(proveedor.getCorreo());
            filaData.createCell(8).setCellValue(proveedor.getActividad());
            filaData.createCell(9).setCellValue(proveedor.getTipoProv());
            filaData.createCell(10).setCellValue(proveedor.getFechaCreacion());
            
            
            numFila++;
        }

        // Guardar el libro de Excel en un ByteArrayOutputStream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        // Retornar los bytes del archivo generado
        return out.toByteArray();
    }


}
