<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板(Board)</title>
<link rel="stylesheet" type="text/css" href="/board/style.css"> 
</head>
<body>
  <jsp:include page="header.jsp" />
  <div class="post">
    <h2>投稿欄</h2>
        <form method="POST"action="<c:choose>
        <c:when test="${post.edit == true}">update</c:when><c:otherwise>board/create</c:otherwise></c:choose>">
          <input name="id" type="hidden" value="${post.id}"/>
	      <label>名前</label><br>
	      <input name="author" type="text" value="${post.author}"}><br>
	      <label>タイトル</label><br>
	      <input name="title" type="text" value="${post.title}"}><br>
	      <label>本文</label><br>
	      <textarea name="body" id="" cols="30" rows="10"}>${post.body}</textarea><br>
	      <input type="submit" value="<c:choose><c:when test="${post.edit == true}">編集</c:when><c:otherwise>投稿</c:otherwise></c:choose>">
	      
	    </form>
  </div>
    <div>
    <h2>スレッド</h2>   
      <table>
        <tbody class="title">
          <c:forEach items="${postBeanList}" var="bean">
            <c:if test="${bean.deleted == false}">
	            <tr>
	              <td valign="bottom">
	                <b class="post-title">
	                  <c:out value="${bean.title}" />
	                </b>
	                <b class="post-name">
	                　 <c:out value="${bean.author}" />
	                </b>
	                　 <c:out value="${bean.createDate}" />		
	              </td>
	              <form action="bbs29.cgi" method="POST"></form>
				  <td class="edit">
					<a href="edit?id=<c:out value="${bean.id}"/>">編集</a>
				  </td>
				  <td class="delete">
					<a href="delete?id=<c:out value="${bean.id}"/>"/>削除</a>
				  </td>
	            </tr>
	          </tbody class="body">
		      <tbody>
		        <tr>
				  <td>
					<p><c:out value="${bean.body}" /></p>
				  </td>
				</tr>
		      </tbody>
	      </c:if>
		</c:forEach>
      </table>
  </div>
  <jsp:include page="footer.jsp" />
</body>
</html>
