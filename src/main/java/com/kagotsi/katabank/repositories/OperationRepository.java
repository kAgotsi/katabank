package com.kagotsi.katabank.repositories;

import com.kagotsi.katabank.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OperationRepository extends JpaRepository<Operation,Long> {

    @Query("SELECT op FROM Operation op WHERE op.account.accountNumber = :accountNumber")
    List<Operation> operations(@Param("accountNumber") Long accountNumber);
}
