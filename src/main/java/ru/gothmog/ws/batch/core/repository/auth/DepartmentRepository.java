package ru.gothmog.ws.batch.core.repository.auth;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.batch.core.model.auth.Department;
import ru.gothmog.ws.batch.core.repository.BaseRepository;

@Repository
public interface DepartmentRepository extends BaseRepository<Department, Long> {}
