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
import java.util.*;

/**
 * <h1>Owner Entity</h1>
 * The Owner class describes the mobile subscriber and details their respective
 * attributes
 *
 * @author Aboagye Bright
 * @version 1.0.0
 * @since 11-05-2021
 */

@Slf4j // for logging
@Table(name = "owners",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "msisdn"),
	})
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Column(name = "first_name", nullable = false)
	@Size(max = 25, message = "First name should not be more than 25 characters")
	private final String firstName;

	@NotBlank
	@Size(max = 45, message = "Last name should not be more than 45 characters")
	@Column(name = "last_name", nullable = false)
	private final String lastName;

	@NotBlank(message = "Email is required")
	@Size(max = 45)
	@Column(nullable = false)
	@Email
	private final String email;

	@NotBlank
	@Column(name = "msisdn")
	@Size(max = 12, message = "msisdn should not be more than 12 characters")
	private final String msisdn;

	/**
	 * Creates a reference table for owners and users.
	 * Since many owners can pay for many users and many users can use
	 * many lines paid for by many owners, @ManyToMany is ideal
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "owners_users",
		joinColumns = @JoinColumn(name = "owners_id"),
		inverseJoinColumns = @JoinColumn(name = "users_id"))
	private Set<User> users = new HashSet<>();

//	@ManyToOne(targetEntity = User.class)
//	private User users;

	@Enumerated(EnumType.STRING)
	@Column(name = "service_type")
//	@NotNull(message = "Please select a service plan")
	private ServiceType serviceType;

	@Column(name = "service_start_date")
	private Date createdAt;

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}