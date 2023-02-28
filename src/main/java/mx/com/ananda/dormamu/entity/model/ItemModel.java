package mx.com.ananda.dormamu.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "item")
@Data
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long idItem;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "peso")
    private double salesUnitWeight;

    @Column(name = "peso venta")
    private double inventoryWeight;

    @Column(name = "codigo de barras")
    private String BarCode;

    @Column(name = "grupo de Items")
    private int ItemsGroupCode;

    @Column(name = "codigo_item")
    private String U_codigo;

    @Column(name = "cantidad")
    private double QuantityOnStock;

    @OneToMany(mappedBy = "item")
    private List<UbicacionItemModel> ubicaciones;
}
