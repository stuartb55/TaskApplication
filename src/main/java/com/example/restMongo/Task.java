package com.example.restMongo;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

public class Task {
	private String id;
	private String subject;
	private String description;
	private LocalDateTime created;
	private LocalDateTime updated;
	private LocalDateTime due;
	private boolean important;

	public Task() {
	}

	// Create new Task
	public Task(String subject, String description, LocalDateTime due, boolean important) {
		id = new ObjectId().toHexString();
		this.subject = subject;
		this.description = description;
		this.due = due;
		this.important = important;
		created = LocalDateTime.now();
	}

	// Already have the ID so populate it with the Updated Date
	public Task(String id, String subject, String description, LocalDateTime due, boolean important) {
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.due = due;
		this.important = important;
		created = LocalDateTime.now();
		updated = LocalDateTime.now();
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

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated() {
		this.updated = LocalDateTime.now();
	}

	public LocalDateTime getDue() {
		return due;
	}

	public void setDue(LocalDateTime due) {
		this.due = due;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	@Override
	public String toString() {
		return "Task{" + "id = " + id + ", subject ='" + subject + '\'' + ", description ='" + description + '\''
				+ ", due ='" + due + '\'' + ", important ='" + important + '\'' + ", created ='" + created + '\''
				+ ", updated ='" + updated + '\'' + '}';
	}
}