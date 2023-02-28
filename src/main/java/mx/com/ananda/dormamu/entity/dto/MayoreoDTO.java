package mx.com.ananda.dormamu.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mayoreo")
@Data
public class MayoreoDTO {

    @Id
    @Column(name = "ID")
    private int id_registroM;

    @Column(name = "SKU")
    private String itemCodeM;

    @Column(name = "Cantidad")
    private int cantidadM;

    @Column(name = "Ubicacion")
    private String ubicacionM;

    @Column(name = "Almacen")
    private String almacenM;
}
