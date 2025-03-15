<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Book</title>
</head>
<body>
    <h2>Add New Book</h2>
    
    <!-- Form to add a new book -->
    <form action="AddBookServlet" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br><br>
        
        <label for="publisher">Publisher:</label>
        <input type="text" id="publisher" name="publisher" required><br><br>
        
        <label for="year">Year:</label>
        <input type="number" id="year" name="year" required><br><br>
        
        <button type="submit">Add Book</button>
    </form>

    <br>
    <!-- Link to display all books -->
    <a href="DisplayBooksServlet">View All Books</a>
</body>
</html>
