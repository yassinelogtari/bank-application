package com.app.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private Long id ;
	private String accountHolder;
	private double balance;
}
