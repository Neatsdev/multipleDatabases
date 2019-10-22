package com.multiple.maria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Offer")
@Entity
public class DmeoEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7265884014150831091L;
	@Id
	@Column(name = "Id")
	private Long id;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
