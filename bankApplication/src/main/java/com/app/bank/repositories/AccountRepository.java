package com.app.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
