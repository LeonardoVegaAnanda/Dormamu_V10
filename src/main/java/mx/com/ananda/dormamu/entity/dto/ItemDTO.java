package mx.com.ananda.dormamu.entity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ItemDTO {
    @Id
    private long id;
    private String ItemCode;
    private String ItemName;
    private double SalesUnitWeight;
    private double InventoryWeight;
    private String BarCode;
    private int ItemsGroupCode;
    private String U_codigo;
    private double QuantityOnStock;
}
