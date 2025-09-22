package bo.gob.dgac.proveedores.controller;

import java.io.FileNotFoundException;
import java.io.InputStream;  //para logo
import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.proveedores.service.ReportService;
import jakarta.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/organizaciones")
@CrossOrigin(origins ="*")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<byte[]> generateReport(@PathVariable Integer id) {
    	
        try {
        	
             byte[] report = reportService.generarReport("Blank_Letter_2", id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
            
        } catch (FileNotFoundException e) {
            // Manejar si el archivo del reporte no se encuentra
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (JRException e) {
            // Manejar errores específicos de JasperReports
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (SQLException e) {
            // Manejar errores de la base de datos
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (Exception e) {
            // Manejar cualquier otra excepción inesperada
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}



/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.proveedores.service.ReportService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="*")
public class ReportController {

@Autowired
private ReportService reportService;

/*
@GetMapping("/report/{id}")
public ResponseEntity<byte[]> generateReport(@PathVariable Long id) {
    try {
        byte[] report = reportService.generarReport("Blank_Letter_2", id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.add("Content-Disposition", "inline; filename=report.pdf");
        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    } catch (JRException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}*/
/*@GetMapping("/report/{id}")
public ResponseEntity<byte[]> generateReport(@PathVariable Long id) {

    try {
        //byte[] report = reportService.generarReport("mi_reporte");
    	byte[] report = reportService.generarReport("Blank_Letter_2",id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.add("Content-Disposition","inline; filename=report.pdf");
        return new ResponseEntity<>(report,headers,HttpStatus.OK);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

}*/
