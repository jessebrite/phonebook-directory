package com.aboagye.phonebookdirectory.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
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
}
