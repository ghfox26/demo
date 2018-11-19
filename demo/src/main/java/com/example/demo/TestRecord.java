package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class TestRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer number;
	private Integer rounds;
	private Integer rusult_number;
	private Integer counts;
	private long times;
	private String funcName;

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getRounds() {
		return rounds;
	}

	public void setRounds(Integer rounds) {
		this.rounds = rounds;
	}

	public Integer getRusult_number() {
		return rusult_number;
	}

	public void setRusult_number(Integer rusult_number) {
		this.rusult_number = rusult_number;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public String toString() {
		return "id:" + this.id + ",number:" + this.number + ",rusult_number:" + this.rusult_number + ",rounds:"
				+ this.rounds + ",counts:" + this.counts + ",times:" + this.times;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

}
