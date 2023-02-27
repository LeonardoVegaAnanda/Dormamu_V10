package mx.com.ananda.dormamu.repository;

import mx.com.ananda.dormamu.entity.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<ItemModel,Long> {

}
