package ru.gothmog.ws.batch.core.repository.auth;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.batch.core.model.auth.Account;
import ru.gothmog.ws.batch.core.repository.BaseRepository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {}
