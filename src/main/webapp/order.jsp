<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Каталог</title>
<%@include file="header.html"%>
    <body>
    <div class="container">
        <h1>Ваш продукт <c:out value="${product.name}"/> добавлен в корзину</h1>
        <%@include file="footer.html"%>
    </div>
    </body>
</html>

