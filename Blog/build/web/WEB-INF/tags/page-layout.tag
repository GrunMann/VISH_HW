<%-- 
    Document   : page-layout
    Created on : Jan 24, 2017, 7:35:48 PM
    Author     : Daniel
--%>
<%@tag pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/blog/css/groundwork.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <jsp:doBody/>
    </body>
</html>
