package com.example.restMongo;

import java.util.Date;
import org.bson.types.ObjectId;

public class Task {
	private String id;
	private String subject;
	private String description;
	private Date created;
	private Date updated;
	private Date due;
	private boolean important;

	public Task() {
	}

	public Task(String subject, String description, Date due, boolean important) {
		id = new ObjectId().toHexString();
		this.subject = subject;
		this.description = description;
		this.due = due;
		this.important = important;
		created = new Date();
	}

	// Already have the ID so populate it with the Updated Date
	public Task(String id, String subject, String description, Date due, boolean important) {
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.due = due;
		this.important = important;
		created = new Date();
		updated = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public void setUpdated() {
		this.updated = new Date();
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
		return "Task{" + "id = " + id + ", subject ='" + subject + '\'' + ", description ='" + description + '\''
				+ ", due ='" + due + '\'' + ", important ='" + important + '\'' + ", created ='" + created + '\''
				+ ", updated ='" + updated + '\'' + '}';
	}
}