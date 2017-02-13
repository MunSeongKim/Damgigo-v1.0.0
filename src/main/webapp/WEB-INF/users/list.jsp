<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br /><br /><br />
 	${users}
 	<hr />
	<table class="table table-striped table-bordered table-condensed">
	<c:forEach items="${users}" var="user">
		<tr >
			<!-- 두가지 방식 모두 내부 속성값에 접근 가능 -->
			<td>${user.id}</td>
			<td>${user["email"]}</td>
			<td>${user["name"]}</td>
			<!-- 
			<td>
				<form th:action="@{/users/edit}" method="get">
					<input type="submit" name="form" value="Edit" />
					<input type="hidden" name="id" th:value="${customer.id}" />
				</form>
			</td>
			<td>
				<form th:action="@{/customers/delete}" method="post">
					<input type="submit" value="delete" />
					<input type="hidden" name="id" th:value="${customers.id}" />
				</form>
			</td>
			 -->
		</tr>
	</c:forEach>
	</table>
