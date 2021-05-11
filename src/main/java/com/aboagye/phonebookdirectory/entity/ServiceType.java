package com.aboagye.phonebookdirectory.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "service_type")
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Data
public class ServiceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private final EServiceType type;

	@Column(name = "service_start_date")
	private Date createdAt;

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}
