package mx.com.ananda.dormamu.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "store")
@Data
public class StoreDTO {

    @Id
    @Column(name = "ID")
    private int id_registroS;

    @Column(name = "SKU")
    private String itemCodeS;

    @Column(name = "Cantidad")
    private int cantidadS;

    @Column(name = "Ubicación")
    private String ubicacionS;

    @Column(name = "Almacen")
    private String almacenS;
}
