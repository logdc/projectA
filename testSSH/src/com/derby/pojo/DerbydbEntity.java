package com.derby.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by applec on 15/5/5.
 */
@Entity
@Table(name = "DERBYDB", schema = "APP", catalog = "")
public class DerbydbEntity {
	private int num;
	private String addr;

	@Id
	@Column(name = "NUM")
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Basic
	@Column(name = "ADDR")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DerbydbEntity that = (DerbydbEntity) o;

		if (num != that.num) return false;
		if (addr != null ? !addr.equals(that.addr) : that.addr != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = num;
		result = 31 * result + (addr != null ? addr.hashCode() : 0);
		return result;
	}
}
