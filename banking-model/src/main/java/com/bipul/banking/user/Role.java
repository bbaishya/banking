package com.bipul.banking.user;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bipul.banking.enums.RoleEnum;

@Entity
@Table(name = "ROLES")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private RoleEnum rolename;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users = new ArrayList<User>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleEnum getRolename() {
		return rolename;
	}

	public void setRolename(RoleEnum rolename) {
		this.rolename = rolename;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}
