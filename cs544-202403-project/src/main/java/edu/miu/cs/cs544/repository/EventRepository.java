package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends BaseRepository<Event, Integer>{

}


