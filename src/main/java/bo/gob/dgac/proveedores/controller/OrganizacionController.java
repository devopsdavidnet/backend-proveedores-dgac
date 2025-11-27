package bo.gob.dgac.proveedores.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.proveedores.dto.OrganizacionDTO;
import bo.gob.dgac.proveedores.model.OrganizacionEntity;
import bo.gob.dgac.proveedores.service.OrganizacionService;


@RestController
@RequestMapping("/api/organizaciones")
@CrossOrigin(origins ="*")

public class OrganizacionController {

	@Autowired
	private OrganizacionService organizacionService;

	
	
	
    @PostMapping("save")    
    public ResponseEntity<OrganizacionEntity> guardar(@RequestBody
    		OrganizacionDTO dto) {
        System.out.println(dto);
        System.out.println("getInstructoresCertificadosInfo"+ dto.getInstructoresCertificadosInfo());
        
        //organizacionService.saveOrganizacion(dto);
		return ResponseEntity.ok(organizacionService.saveOrganizacion(dto));
    }
  
    /*
    @PostMapping("guardar")
    public OrganizacionDto guardar1(@RequestBody OrganizacionDto dto) {
    	System.out.println("DAVIDDDDDDDDDDDDDDDDDDDDDD");
		return dto;
        
    } */
    
    @PutMapping("update/{id}")
    public ResponseEntity<OrganizacionEntity> actualizar(
            @PathVariable Long id,
            @RequestBody OrganizacionDTO dto) {
        dto.setId(id);
        System.out.println("llego al controlador con id="+id);
        System.out.println("dto :"+dto.getDireccion());
        System.out.println("dto de:"+dto.getDepartamento());
        System.out.println("Dto de :"+ dto.getAeronaveInfo());
        System.out.println("getCertificadosEspecificosAprobados :"+dto.getCertificadosEspecificosAprobados());
        System.out.println("tipo operacion:"+dto.getTipoOperacion());
        System.out.println("Otro tipo de operacion"+dto.getOtroTipoOperacion());
        System.out.println("tipo CIAC CEAC"+dto.getTipoCiacCeac());
        return ResponseEntity.ok(organizacionService.updateOrganizacion(dto));
    }
    
    @GetMapping()
    public ResponseEntity<List<OrganizacionEntity>> listar(){
    	List<OrganizacionEntity> org= organizacionService.listarOrganizacionesConDocumentos();
    	return ResponseEntity.ok(org);
    }
}


 





































