package com.kagotsi.katabank.repositories;

import com.kagotsi.katabank.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ClientRepository  extends JpaRepository<Client, Long> {
}
