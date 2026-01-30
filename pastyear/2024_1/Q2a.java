public class Q2a {
    public static void main(String[] args) {
        Book booka = new Book("book name", "person", 2000);
        booka.getDetails();
    }
}

class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished)
    {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void getDetails()
    {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Year published: " + this.yearPublished);
    }
}
