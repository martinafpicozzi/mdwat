<%@ page import="java.time.LocalTime"%> <!-- sto importando una libreria, come in java -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
    <h1>
        <% // non è codice html ma jsp
            out.print(LocalTime.now()); // print sull'oggetto out (pagina di response) localtimenow
        %>
    </h1>
</body>
</html>