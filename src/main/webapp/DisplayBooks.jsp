<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Display All Books</title>
</head>
<body>
    <h2>List of Books</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Year</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.publisher}</td>
                    <td>${book.year}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="AddBook.jsp">Add New Book</a>
</body>
</html>
