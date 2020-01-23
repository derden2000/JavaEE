<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Каталог</title>
<%@include file="header.html"%>
    <body>
    <div class="container">
        <h1>Описание товара</h1>

        <div class="col-12">
                    <table class="table table-bordered my-2">
                        <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <th scope="row"><c:out value="${product.id}"/></th>
                            <td><c:out value="${product.name}"/>
                            <c:url value="/product" var="productUrl">
                                <c:param name="id" value="${product.id}"/>
                                </c:url>
                            </td>
                            <td><c:out value="${product.description}"/></td>
                            <td><c:out value="${product.price}"/></td
                        </tr>
                        </tbody>
                    </table>
                </div>
        <%@include file="footer.html"%>
        </div>
    </body>
</html>