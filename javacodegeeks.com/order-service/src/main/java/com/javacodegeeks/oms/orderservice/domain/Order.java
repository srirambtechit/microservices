package com.javacodegeeks.oms.orderservice.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {
	@Id
	private Long id;

	@Column(unique = true)
	private String externalReference;
	private String customerId;

	@CreatedDate
	private LocalDateTime createdDate;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items;
}
