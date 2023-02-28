package mx.com.ananda.dormamu.repository;

import mx.com.ananda.dormamu.entity.model.UbicacionItemModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUbicacionItemRepository extends CrudRepository<UbicacionItemModel,Long> {

}
