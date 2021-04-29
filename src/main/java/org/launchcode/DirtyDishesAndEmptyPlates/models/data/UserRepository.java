package org.launchcode.DirtyDishesAndEmptyPlates.models.data;

import org.launchcode.DirtyDishesAndEmptyPlates.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

        User findByUsername(String username);

    }

