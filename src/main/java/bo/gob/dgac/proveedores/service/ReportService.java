package bo.gob.dgac.proveedores.service;
/*
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReportService {

    private final DataSource dataSource;

    public ReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public byte[] generarReport(String reportName, Long id) throws Exception {

        // Cargar el archivo .jasper del reporte principal
        InputStream reportStream = this.getClass().getResourceAsStream("/report/" + reportName + ".jasper");

        if (reportStream == null) {
            throw new FileNotFoundException("Report file not found: " + reportName + ".jasper");
        }

        // Crear el mapa de parámetros
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        
        // Parámetro CRÍTICO para subreportes: la ruta del directorio
        // Asegúrate de que los archivos .jasper de los subreportes
        // se encuentren en este directorio dentro del classpath
        params.put("SUBREPORT_DIR", "reports/");

        // Obtener la conexión a la base de datos
        try (Connection connection = dataSource.getConnection()) {
            
            // Llenar el reporte principal
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, connection);

            // Exportar el reporte a un array de bytes (PDF)
            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            e.printStackTrace();
            throw new JRException("Error generating report: " + e.getMessage(), e);
        }
    }
}
*/

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
   
@Service
public class ReportService {

private final DataSource dataSource;

public ReportService(DataSource dataSource) {
           this.dataSource = dataSource;
       }

   public byte[] generarReport(String reportName, Integer id) throws Exception {
	   
	     
   
       InputStream imageStream = this.getClass().getResourceAsStream("/img/logo_dgac.png");
       if (imageStream == null) {
           throw new JRException("No existe la imagen.");
       }

       
       
       
           // Cargar el archivo .jrxml del reporte principal
           InputStream reportStream = this.getClass().getResourceAsStream("/report/" + reportName + ".jrxml");
           JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
           
           InputStream subReportStream = this.getClass().getResourceAsStream("/report/Blank_Letter_3.jrxml");
           JasperReport subReport = JasperCompileManager.compileReport(subReportStream);

           InputStream subReportStream2 = this.getClass().getResourceAsStream("/report/Blank_Letter_4.jrxml");
           JasperReport subReport2 = JasperCompileManager.compileReport(subReportStream2);

           InputStream subReportStream3 = this.getClass().getResourceAsStream("/report/registro_aeronaves.jrxml");
          JasperReport subReport3 = JasperCompileManager.compileReport(subReportStream3);
           
           InputStream subReportStream4 = this.getClass().getResourceAsStream("/report/caracteristicas_organizacion_O_T_C.jrxml"); 
           JasperReport subReport4 = JasperCompileManager.compileReport(subReportStream4);
          
           InputStream subReportStream5 =this.getClass().getResourceAsStream("/report/capacidad_organizacion.jrxml");
           JasperReport subReport5 = JasperCompileManager.compileReport(subReportStream5);
           
           InputStream subReportStream6 = this.getClass().getResourceAsStream("/report/tipo_organizacion_ciac_ceac.jrxml");
           JasperReport subReport6 = JasperCompileManager.compileReport(subReportStream6);
           
           InputStream subReportStream7 = this.getClass().getResourceAsStream("/report/certificados_especificos_aprobados.jrxml");
           JasperReport subReport7 = JasperCompileManager.compileReport(subReportStream7);
           
           InputStream subReportStream8 = this.getClass().getResourceAsStream("/report/directorio_personal.jrxml");
           JasperReport subReport8 = JasperCompileManager.compileReport(subReportStream8);
           
           InputStream subReportStream9 = this.getClass().getResourceAsStream("/report/personal_certificado.jrxml");
           JasperReport subReport9 = JasperCompileManager.compileReport(subReportStream9);
           
           // Crear el mapa de parámetros
           Map<String, Object> params = new HashMap<>();
           params.put("id", id);
           
           // Opción 1: pasar el objeto compilado
           params.put("SUBREPORT_PARAM", subReport);
           params.put("SUBREPORT_PARAM_2", subReport2);
           params.put("SUBREPORT_PARAM_REGISTRO_AERONAVES", subReport3);
           params.put("SUBREPORT_PARAM_CARAT_ORGANIZACION_O_T_C",subReport4);
           params.put("SUBREPORT_PARAM_CAPACIDAD_ORGANIZACION", subReport5);
           params.put("SUBREPORT_PARAM_TIPO_ORGANIZACION", subReport6);
           params.put("SUBREPORT_PARAM_CERTIFICADOS_APROBADOS", subReport7);
           params.put("SUBREPORT_PARAM_DIRECTORIO_PERSONAL", subReport8);
           params.put("SUBREPORT_PARAM_PERSONAL_CERTIFICADO", subReport9);
           
           params.put("IMAGE_LOGO", imageStream);
        //   params.put("SUBREPORT_DIR", this.getClass().getResource("/report/").getPath());
           
           // Obtener la conexión a la base de datos
           try (Connection connection = dataSource.getConnection()) {
               // Llenar el reporte principal, pasando los parámetros y la conexión.
               // Los subreportes usarán esta misma conexión y parámetros.
               JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);

               // Exportar el reporte a un array de bytes (PDF)
               return JasperExportManager.exportReportToPdf(jasperPrint);

           } catch (Exception e) {
               e.printStackTrace();
               throw new JRException("Error generating report: " + e.getMessage(), e);
           }
       }

   }



