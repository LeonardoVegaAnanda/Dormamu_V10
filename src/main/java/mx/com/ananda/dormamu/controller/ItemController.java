package mx.com.ananda.dormamu.controller;

import mx.com.ananda.dormamu.entity.model.ItemModel;
import mx.com.ananda.dormamu.service.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("ananda/dormamu")
@CrossOrigin("*")
public class ItemController {

    private IItemService sItem;

    @Autowired
    public void setSItem(IItemService iItemService){
        this.sItem = iItemService;
    }

    @GetMapping("/item-m/{itemCode}")
    public ResponseEntity<ItemModel> traerItemMayoreo(@PathVariable(value = "itemCode") String itemCode){
        Optional<ItemModel> itemBuscar = sItem.findbyItemCodeM(itemCode).filter(i ->i.getItemCode().contains(itemCode));
        ItemModel itemTraido = itemBuscar.get();
        return new ResponseEntity<>(itemTraido,HttpStatus.OK);
    }

    @GetMapping("/item-s/{itemCode}")
    public ResponseEntity<ItemModel> traerItemStore(@PathVariable(value = "itemCode") String itemCode){
        Optional<ItemModel> itemBuscar = sItem.findByItemCodeS(itemCode).filter(i ->i.getItemCode().contains(itemCode));
        ItemModel itemTraido = itemBuscar.get();
        return new ResponseEntity<>(itemTraido,HttpStatus.OK);
    }
}
