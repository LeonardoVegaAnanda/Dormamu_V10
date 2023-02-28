package mx.com.ananda.dormamu.repository;

import mx.com.ananda.dormamu.entity.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStoreRepository extends CrudRepository<StoreDTO,Integer> {

    List<StoreDTO> findByItemCodeS(String itemCode);
}
