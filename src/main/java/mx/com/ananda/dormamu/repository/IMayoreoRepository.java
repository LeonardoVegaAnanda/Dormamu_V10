package mx.com.ananda.dormamu.repository;

import mx.com.ananda.dormamu.entity.dto.MayoreoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMayoreoRepository extends CrudRepository<MayoreoDTO,Integer> {

    List<MayoreoDTO> findByItemCodeM(String itemCode);
}
