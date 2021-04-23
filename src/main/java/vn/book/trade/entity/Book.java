package vn.book.trade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "books")
public class Book {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    
	    private int id;
	 
	    @Column(name = "title", length = 255, nullable = false)
	    private String title;
	    @Column(name = "name_file", length = 255, nullable = false)
	    private String nameFile;
	    @Column(name = "description", length = 255, nullable = false)
	    private String description;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getNameFile() {
			return nameFile;
		}
		public void setNameFile(String nameFile) {
			this.nameFile = nameFile;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Book(String title, String nameFile, String description) {
			super();
			this.title = title;
			this.nameFile = nameFile;
			this.description = description;
		}
	    
	    
		
		
}
