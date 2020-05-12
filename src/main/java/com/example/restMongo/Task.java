package com.example.restMongo;

import java.util.Date;

public class Task {
	private long id;
	private String subject;
	private String description;
	private Date created;
	private Date updated;
	private Date due;
	private boolean important;

	public Task() { }

	public Task(Long id, String subject, String description, Date due, boolean important) {
		this.subject = subject;
		this.description = description;
		this.due = due;
		this.important = important;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
		updated = new Date();
	}

	@Override
	public String toString() {
		return "Task{" +
                "id = " + id +
                ", subject ='" + subject + '\'' +
				", description ='" + description + '\'' +
				", due ='" + due + '\'' +
				", important ='" + important + '\'' +
				", created ='" + created + '\'' +
				", updated ='" + updated + '\'' +
                '}';
	}
}