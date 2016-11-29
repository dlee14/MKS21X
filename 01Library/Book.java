public class Book {
	private String author, title, isbn;

	public Book() {
		author = "";
		title = "";
		isbn = "";
	}

	public Book(String author, String tile, String isbn) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	private void setAuthor(String author) {
		this.author = author;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}