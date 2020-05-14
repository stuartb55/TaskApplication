package com.example.restMongo;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.bson.types.ObjectId;

public class Task {
	private String id;
	private String subject;
	private String description;
	private ZonedDateTime created;
	private ZonedDateTime updated;
	private ZonedDateTime due;
	private boolean important;

	public Task() {
	}

	// Create new Task
	public Task(String subject, String description, ZonedDateTime due, boolean important) {
		id = new ObjectId().toHexString();
		this.subject = subject;
		this.description = description;
		this.due = due;
		this.important = important;
		created = ZonedDateTime.now(ZoneId.of("UTC"));
	}

	// Already have the ID so populate it with the Updated Date
	public Task(String id, String subject, String description, ZonedDateTime due, boolean important) {
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.due = due;
		this.important = important;
		created = ZonedDateTime.now(ZoneId.of("UTC"));
		updated = ZonedDateTime.now(ZoneId.of("UTC"));
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

	public ZonedDateTime getCreated() {
		return created;
	}

	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}

	public ZonedDateTime getUpdated() {
		return updated;
	}

	public void setUpdated() {
		this.updated = ZonedDateTime.now();
	}

	public ZonedDateTime getDue() {
		return due;
	}

	public void setDue(ZonedDateTime due) {
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