<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<style>
	a{text-decoration:none}
</style>
<meta charset="utf-8">
<center>
	<font color='gray' size='4' face='휴먼편지체'>
	<hr width='600' size='2' color='gray' noshade>
	<h3>Spring Board</h3>
	<font color='gray' size='4' face='휴먼편지체'>
	<a href='write'>글쓰기</a>
	</font>
	<hr width='600' size='2' color='gray' noshade>
	</font>
	
	<table border='2' width='600' align='center' noshade>
	<tr>
	<td width='20%' align='center'>No</td>
	<td>${dto.seq}</td>
	</tr>
	<tr>
	<td width='20%' align='center'>Writer</td>
	<td>${dto.writer}</td>
	</tr>
	<tr>
	<td align='center'>E-mail</td>
	<td>${dto.email}</td>
	</tr>
	<tr>
	<td align='center'>Subject</td>
	<td>${dto.subject}</td>
	</tr>
	<tr>
	<td align='center'>Contents</td>
	<td>${dto.content}</td>
	</tr>
	</table>
	
	<hr width='600' size='2' color='gray' noshade>
	<font color='gray' size='4' face='휴먼편지체'>
	<a href='write?seq=${dto.seq}'>수정</a>
	 &nbsp;&nbsp;| 
	<a href='update?m=del&seq=${dto.seq}'>삭제</a>
	 &nbsp;&nbsp;| 
	<a href='list'>목록</a>
	</font>
	<hr width='600' size='2' color='gray' noshade>
</center>
