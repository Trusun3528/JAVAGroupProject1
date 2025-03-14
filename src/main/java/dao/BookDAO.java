package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import util.DBUtil;

public class BookDAO {

public static void addBook(Book book) throws Exception{
		
		String sql = "INSERT INTO books (title, author, publisher, year) VALUES (?, ?, ?, ?)";
		
		try(Connection connection = DBUtil.getConnection(); 
				PreparedStatement sqlStatement = connection.prepareStatement(sql)){
			
			 if (connection == null) {
	                throw new SQLException("Failed to establish a database connection.");
	            }
			
			sqlStatement.setString(1,  book.getTitle());
			sqlStatement.setString(2,  book.getAuthor());
			sqlStatement.setString(3,  book.getPublisher());
			sqlStatement.setString(4,  book.getYear());
			
			sqlStatement.execute();
			
		}
		
	}
	
	public static ArrayList<Book> getBooks() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("getBooks called");
		
		String resultBooks = "";
		ArrayList<Book> books = new ArrayList<Book>();
		
		 try(Connection c = DBUtil.getConnection(); 
	                Statement stm = c.createStatement();)
	        {
	            //Step 4: Write a query
	            String sql = "SELECT * FROM books";
	            ResultSet res = stm.executeQuery(sql);

	            while(res.next())
	            {
	                
	            	int id = res.getInt("id");
	                String title = res.getString("title");
	                String author = res.getString("author");
	                String publisher = res.getString("publisher");
	                String year = res.getString("year");
	            	
	            	Book book = new Book(id, title, author, publisher, year);
	            	
	            	// All this does is pops this up on the console to make sure I'm doing it right
	            	String resultLine = "";
	            	resultLine += "Id: " + id + ", ";
	                resultLine += "Title: " + title + ", ";
	                resultLine += "Author: " + author + ", ";
	                resultLine += "Publisher: " + publisher + ", ";
	                resultLine += "Year: " + year + ".";
	                
	                resultBooks += resultLine + "\n";
	                
	                
	                
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		 
		 	System.out.println(resultBooks);

		 	return books;
	}
	
	/*
	public static void main(String[] args) throws Exception {

        //Class.forName("com.mysql.jdbc.Driver");

		// Test Getting All Books
		ArrayList<Book> newBooks = new ArrayList<Book>();
		
        try {
        	
        	System.out.println("Call getBooks()");
        	newBooks = getBooks();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        // Test Creating a book
       // BookDAO bookDAO = new BookDAO();
        Book testBook = new Book(0, "Test Book", "Harry Samson", "Hello Publisher", "2025");
        
        try {
        	addBook(testBook);
            System.out.println("✅ Book added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error inserting book!");
            e.printStackTrace();
        }
    }
    */
	
}
