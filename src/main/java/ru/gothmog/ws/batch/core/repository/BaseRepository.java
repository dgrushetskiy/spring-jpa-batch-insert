package ru.gothmog.ws.batch.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, D extends Serializable> extends JpaRepository<T, D>, JpaSpecificationExecutor<T> {}
