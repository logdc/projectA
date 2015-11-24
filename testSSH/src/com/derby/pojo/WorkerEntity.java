package com.derby.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by applec on 15/5/9.
 */
@Entity
@Table(name = "WORKER", schema = "APP", catalog = "")
public class WorkerEntity {
	private int id;
	private String name;

	@Id
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "NAME") // Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		WorkerEntity that = (WorkerEntity) o;

		if (id != that.id) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	private FactoryEntity factory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FACTORYID", nullable = false)
	public FactoryEntity getFactory() {
		return factory;
	}

	public void setFactory(FactoryEntity factory) {
		this.factory = factory;
	}
}
