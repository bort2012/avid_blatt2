package de.uniulm.avid.roary.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Roar implements Serializable{
	
	static final long serialVersionUID = 1L;

	protected int id;
	protected String text;
	protected String author;
	protected Date  creationDate;
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
