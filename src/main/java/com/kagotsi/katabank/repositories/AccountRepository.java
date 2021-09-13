package com.kagotsi.katabank.repositories;

import com.kagotsi.katabank.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface AccountRepository extends JpaRepository<Account,Long> {
}
