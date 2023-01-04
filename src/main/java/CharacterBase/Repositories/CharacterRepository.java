package CharacterBase.Repositories;

import CharacterBase.Entities.CharacterEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends MongoRepository<CharacterEntity, String> {

    Optional<CharacterEntity> findById(String id);

    CharacterEntity findByChar_name(String name);

    @Override
    List<CharacterEntity> findAll(Sort sort);
}