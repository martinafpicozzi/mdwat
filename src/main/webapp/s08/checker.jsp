<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%> <!-- import della libreria java util, utilizzo alcune classi di JU -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP &amp; request</title>
</head>
<body>
    <h1>Hello!</h1>
    <p id="result">
        The user name
        <%
            @SuppressWarnings("unchecked") // elimina i warnings unchecked perché so che non sto facendo una cosa molto corretta
            Set<Character> set = (Set<Character>) request.getAttribute("set"); // prendi set dagli attributi di request (oggetto) e downcastalo a un set of character
            if (set == null || set.isEmpty()) {
                out.print("is empty"); // scrivo sulla response
            } else {
                out.print("contains these letters:");

                Iterator<Character> it = set.iterator(); // iteratore= oggetto che permette di scandire una collezione. Voglio un iteratore per scorrere set
                while (it.hasNext()) {
                    out.print(" " + it.next());
                }
            }
        %>
    </p>
</body>
</html>