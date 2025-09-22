package bo.gob.dgac.proveedores.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.proveedores.dto.UsuarioLoginDTO;
import bo.gob.dgac.proveedores.model.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByCorreo(String correo);
    
    @Query("""
            SELECT new bo.gob.dgac.proveedores.dto.UsuarioLoginDTO(
                u.nombre,
                u.primerApellido,
                u.segundoApellido,
                u.celular,
                u.idProveedor,
                o.nombreOrganizacion,
    			o.tipoExplotador,
    			o.departamentoId,
    			o.direccion,
    			o.telefono,
    			o.correo,
    			o.fechaInicialCertificacion,
    			o.fechaExpiracionCertificacion,
    			o.numeroCertificado,
    			o.numeroResolucion,
    			o.resolucionClaseCertificacion,
    			o.otraResolucionClaseCertificacion,
    			o.tieneSms,
    			o.fechaAceptacion,
    			o.objetivosIndicadores,
    			o.nacionalidadOrganizacion,
    			o.certificadosEspecificosAprobados,
    			o.aerovanvesRegistradas,
    			o.tamanoOrganizacion,
    			o.complejidadOrganizacion,
    			o.tipoOperacion,
    			o.otroTipoOperacion,
    			o.capacidadesOrganizacion,
    			o.certificados,
    			o.personalDirectorio,
    			o.personalCertificado,
    			o.certificaciones,
    			o.tipoCiacCeac
    			
    			)
            FROM UsuarioEntity u
            JOIN OrganizacionEntity o ON u.idProveedor = o.id
            WHERE u.correo = :correo AND u.contrasenia = :contrasenia
        """)
        UsuarioLoginDTO loginUsuario(@Param("correo") String correo,
                                     @Param("contrasenia") String contrasenia);


}

    








