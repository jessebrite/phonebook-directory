package com.aboagye.phonebookdirectory.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Table(name = "owner")
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Size(max = 25, message = "First name should not be more than 25 characters")
	private final String firstname;

	@NotBlank
	@Size(max = 45, message = "Last name should not be more than 45 characters")
	private final String lastname;

	@NotBlank(message = "Email is required")
	@Size(max = 45)
	@Column(nullable = false, unique = true)
	@Email
	private final String email;

	@NotBlank
	@Column(name = "msisdn", nullable = false, unique = true)
	@Size(max = 12, message = "msisdn should not be more than 12 characters")
	private final String msisdn;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_owner",
		joinColumns = @JoinColumn(name = "customer_id_owner"),
		inverseJoinColumns = @JoinColumn(name = "customer_id_user"))
	private Set<User> users = new HashSet<>();

	@ManyToOne(targetEntity = ServiceType.class)
	@Value("${EnumType.STRING:MOBILE_PREPAID}")
	@NotNull(message = "Please choose a service plan")
	private ServiceType serviceTypes;
}
