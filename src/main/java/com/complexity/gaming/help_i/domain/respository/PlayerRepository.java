package com.complexity.gaming.help_i.domain.respository;

import com.complexity.gaming.help_i.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {


}
