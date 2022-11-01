package com.jpaturial.jpaturorial.Repository;

import com.jpaturial.jpaturorial.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySlackUsername(String title);

}
