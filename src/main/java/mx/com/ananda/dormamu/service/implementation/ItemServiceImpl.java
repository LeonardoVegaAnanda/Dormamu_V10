package mx.com.ananda.dormamu.service.implementation;

import mx.com.ananda.dormamu.entity.dto.ItemDTO;
import mx.com.ananda.dormamu.entity.dto.MayoreoDTO;
import mx.com.ananda.dormamu.entity.dto.StoreDTO;
import mx.com.ananda.dormamu.entity.model.ItemModel;
import mx.com.ananda.dormamu.entity.model.UbicacionItemModel;
import mx.com.ananda.dormamu.repository.*;
import mx.com.ananda.dormamu.service.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ItemServiceImpl implements IItemService {


    @Autowired
    private IMayoreoRepository iMayoreo;

    @Autowired
    private IStoreRepository iStore;

    @Autowired
    private IUbicacionItemRepository iUbicacionItem;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IItemRepository iItem;


    private String basePath = "http://localhost:3090/ananda/eternity/";

    @Override
    @Transactional
    public List<ItemModel> findAllItems() {
        return (List<ItemModel>) iItem.findAll();
    }

    @Override
    @Transactional
    public Optional<ItemModel> findByItemCodeS(String itemCode) {
        ItemModel itemSAP = mapearItemmodel(restTemplate.getForObject(basePath + "Item?itemCode=" + itemCode, ItemDTO.class));
        if (!itemSAP.getItemCode().equals("0")) {
            Optional<ItemModel> oItem = iItem.findByItemCode(itemSAP.getItemCode());
            if (oItem.isPresent()) {
                return oItem;
            } else {
                List<UbicacionItemModel> listaUbicaciones = new ArrayList<>();
                List<StoreDTO> listaItemsStore = iStore.findByItemCodeS(itemCode);
                UbicacionItemModel ubicacionItemModel = new UbicacionItemModel();
                for (var ubicacion : listaItemsStore) {
                    listaUbicaciones.add(mapearEntidadStore(ubicacion));
                    for(var ubi:listaUbicaciones){
                        String itemCodeBuscar = ubi.getSku();
                        Optional<ItemModel> itemTraido = iItem.findByItemCode(itemCodeBuscar);
                        if(itemTraido.isPresent()){
                            ubi.setItem(itemTraido.get());
                            iUbicacionItem.save(ubi);
                        }
                        else {
                            ItemModel itemNuevo =null;
                            try{
                               itemNuevo = iItem.save(itemSAP);
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            ubi.setItem(itemNuevo);
                            iUbicacionItem.save(ubi);
                        }
                    }
                }
                Optional<ItemModel> itemDevuelto = iItem.findByItemCode(itemSAP.getItemCode());
                return  itemDevuelto;
            }
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public Optional<ItemModel> findbyItemCodeM(String itemCode) {

        ItemModel itemSAP = mapearItemmodel(restTemplate.getForObject(basePath + "Item?itemCode=" + itemCode, ItemDTO.class));
        if (!itemSAP.getItemCode().equals("0")) {
            Optional<ItemModel> oItem = iItem.findByItemCode(itemSAP.getItemCode());
            if (oItem.isPresent()) {
                return oItem;
            } else {
                List<UbicacionItemModel> listaUbicaciones = new ArrayList<>();
                List<MayoreoDTO> listaItemsMayoreo = iMayoreo.findByItemCodeM(itemCode);
                UbicacionItemModel ubicacionItemModel = new UbicacionItemModel();
                for (var ubicacion : listaItemsMayoreo) {
                    listaUbicaciones.add(mapearEntidadMayoreo(ubicacion));
                    for(var ubi:listaUbicaciones){
                        String itemCodeBuscar = ubi.getSku();
                        Optional<ItemModel> itemTraido = iItem.findByItemCode(itemCodeBuscar);
                        if(itemTraido.isPresent()){
                            ubi.setItem(itemTraido.get());
                            iUbicacionItem.save(ubi);
                        }
                        else {
                            ItemModel itemNuevo =null;
                            try{
                                itemNuevo = iItem.save(itemSAP);
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            ubi.setItem(itemNuevo);
                            iUbicacionItem.save(ubi);
                        }
                    }
                }
                Optional<ItemModel> itemDevuelto = iItem.findByItemCode(itemSAP.getItemCode());
                return  itemDevuelto;
            }
        }
        else{
            return null;
        }
    }


    @Override
    @Transactional
    public void updateItem(ItemModel itemModel, UbicacionItemModel ubicacionItemModel) {
        iUbicacionItem.save(itemModel.getUbicaciones().get(Math.toIntExact(ubicacionItemModel.getIdUbicacionItem())));
    }

    private UbicacionItemModel mapearEntidadStore(StoreDTO storeDTO) {
        UbicacionItemModel ubicacionItemModel = new UbicacionItemModel();
        ubicacionItemModel.setSku(storeDTO.getItemCodeS());
        ubicacionItemModel.setUbicacion(storeDTO.getUbicacionS());
        ubicacionItemModel.setCantidad(storeDTO.getCantidadS());
        ubicacionItemModel.setWarehouseCode("ALPC");
        return ubicacionItemModel;
    }
    private UbicacionItemModel mapearEntidadMayoreo(MayoreoDTO mayoreoDTO) {
        UbicacionItemModel ubicacionItemModel = new UbicacionItemModel();
        ubicacionItemModel.setSku(mayoreoDTO.getItemCodeM());
        ubicacionItemModel.setUbicacion(mayoreoDTO.getUbicacionM());
        ubicacionItemModel.setWarehouseCode("ALPM");
        ubicacionItemModel.setCantidad(mayoreoDTO.getCantidadM());
        return ubicacionItemModel;
    }

    private ItemModel mapearItemmodel(ItemDTO itemDTO) {
        ItemModel itemMapeado = new ItemModel();
        itemMapeado.setItemCode(itemDTO.getItemCode());
        itemMapeado.setItemName(itemDTO.getItemName());
        itemMapeado.setItemsGroupCode(itemDTO.getItemsGroupCode());
        itemMapeado.setBarCode(itemDTO.getBarCode());
        itemMapeado.setQuantityOnStock(itemDTO.getQuantityOnStock());
        itemMapeado.setInventoryWeight(itemDTO.getInventoryWeight());
        itemMapeado.setSalesUnitWeight(itemDTO.getSalesUnitWeight());
        itemMapeado.setU_codigo(itemDTO.getU_codigo());
        return itemMapeado;
    }
}
