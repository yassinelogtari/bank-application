package com.app.bank.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private Long id ;
	private String accountHolder;
	private double balance;
}
