package mx.com.ananda.dormamu.service.interfaces;

import mx.com.ananda.dormamu.entity.model.ItemModel;
import mx.com.ananda.dormamu.entity.model.UbicacionItemModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IItemService {

    List<ItemModel> findAllItems();

    Optional<ItemModel> findByItemCodeS(String itemCode);

    Optional<ItemModel> findbyItemCodeM(String itemCode);

    void updateItem(ItemModel itemModel, UbicacionItemModel ubicacionItemModel);
}
