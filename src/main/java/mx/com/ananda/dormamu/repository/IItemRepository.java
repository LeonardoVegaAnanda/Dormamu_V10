package mx.com.ananda.dormamu.repository;

import mx.com.ananda.dormamu.entity.model.ItemModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IItemRepository extends CrudRepository<ItemModel,Long> {
    Optional<ItemModel> findByItemCode(String itemCode);
}
