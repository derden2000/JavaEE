<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Каталог</title>
<%@include file="header.html"%>
    <body>
    <div class="container">
        <h1>Каталог товаров</h1>

        <div class="col-12">
                    <table class="table table-bordered my-2">
                        <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Actions</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%-- for (Product product : (List<Product>) request.getAttribute("products")) { --%>
                        <c:forEach var="product" items="${requestScope.products}">
                        <tr>
                            <th scope="row"><c:out value="${product.id}"/></th>
                            <td><c:out value="${product.name}"/>
                            <c:url value="/product" var="productUrl">
                                <c:param name="id" value="${product.id}"/>
                                </c:url>
                            </td>
                            <td><c:out value="${product.description}"/></td>
                            <td><c:out value="${product.price}"/></td>
                            <td>
                                <c:url value="/order" var="orderProductUrl">
                                    <c:param name="id" value="${product.id}"/>
                                </c:url>
                                <a class="btn btn-success" href="${orderProductUr}">Заказать<i class="fas fa-edit"></i></a>

                            </td>
                        </tr>
                        </c:forEach>
                        <%-- } --%>
                        </tbody>
                    </table>
                </div>
        <%@include file="footer.html"%>
        </div>
    </body>
</html>

