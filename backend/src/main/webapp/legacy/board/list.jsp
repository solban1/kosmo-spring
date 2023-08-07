<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
	<title> Spring Board </title>
	<meta charset="utf-8">
	<style>
		a{text-decoration:none}
	</style>
</head>
<body>
<center>
<font color='gray' size='4' face='휴먼편지체'>
<hr width='600' size='2' color='gray' noshade>
<h3> Spring Board</h3>
<font color='gray' size='4' face='휴먼편지체'>
<a href='../'>인덱스</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='write'>글쓰기</a><br/>
</font>
<hr width='600' size='2' color='gray' noshade>

<TABLE border='2' width='600' align='center' noshade>
<TR size='2' align='center' noshade bgcolor='AliceBlue'>
	<th bgcolor='AliceBlue'>no</th>
	<th color='gray'>writer</th>
	<th color='gray'>e-mail</th>
	<th color='gray'>subject</th>
	<th color='gray'>date</th>
</TR>

      
<c:forEach items="${page.content}" var="dto">
    <TR align='center' noshade>
		<TD>${dto.seq}</TD>
		<TD>${dto.writer}</TD>
		<TD>${dto.email}</TD>
	    <TD>
	      <a href="content?seq=${dto.seq}">
		    ${dto.subject}
		  </a>
		</TD>
		<TD>
			<fmt:formatDate value="${dto.rdate}" pattern="MM-dd HH:mm"/>
		</TD>
	   </TR> 
	</c:forEach>
      
</TABLE>
<hr width='600' size='2' color='gray' noshade>
<font color='gray' size='3' face='휴먼편지체'>
    (총페이지수 : ${pages})
    &nbsp;&nbsp;&nbsp;
    <c:forEach begin="1" end="${page.totalPages}" varStatus="p">
        <a href="list?page=${p.index}&size=${page.size}">
            
                
                	<c:if test="${currentPage == p.index}">
						<strong>
					</c:if>
							${p.index}
					<c:if test="${currentPage == p.index}">
						</strong>
					</c:if>
                
                
            
    	</a>&nbsp;
    </c:forEach>
    ( TOTAL : ${count} )
    
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       페이지 싸이즈 : 
    <select id="psId" name="ps" onchange="f(this)">
    	
    		
    		   <option value="3" selected>3</option>
		       <option value="5">5</option>
		       <option value="10">10</option>
    		
    		
    		
    	
    </select>
    
    <script language="javascript">
       function f(select){
           //var el = document.getElementById("psId");
           var ps = select.value;
           //alert("ps : " + ps);
           location.href="list?size="+ps;
       }
    </script>
	<script defer>
		document.getElementById("psId").value = ${page.size};
	</script>
    
</font>
<hr width='600' size='2' color='gray' noshade>
<!--
<form action="">
      <select name="catgo">
        <option value="subject">제목</option>
        <option value="writer">글쓴이</option>
        <option value="content">내용</option>
      </select>
      <input type="text" name="keyword" size="40" required="required" /> <button>검색</button>
    </form> 
-->    
</center>
</body>
</html>