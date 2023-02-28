package mx.com.ananda.dormamu.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ubicacion_item")
@Data
public class UbicacionItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacionItem;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "item_code")
    private String sku;

    @Column(name = "ubicacion")
    private String Ubicacion;


    @Column(name = "codigoAlmacen")
    private String  WarehouseCode;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private ItemModel item;




}
