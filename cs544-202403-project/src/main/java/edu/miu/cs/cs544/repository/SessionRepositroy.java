package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Session;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepositroy extends BaseRepository<Session,Long> {
}
