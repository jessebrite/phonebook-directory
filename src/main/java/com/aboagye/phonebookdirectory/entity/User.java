package com.aboagye.phonebookdirectory.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Slf4j // for logging
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "First name is required")
	@Column(name = "first_name", nullable = false)
	private final String firstName;

	@NotBlank(message = "Last name is required")
	@Column(name = "last_name", nullable = false)
	private final String lastName;

	@NotBlank(message = "Email is required")
	@Column(nullable = false, unique = true)
	@Size(max = 45)
	@Email
	private final String email;

	@ManyToMany(mappedBy = "serviceType")
	Set<Owner> owners = new HashSet<>();
}
