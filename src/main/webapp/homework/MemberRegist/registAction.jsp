<%@page import="utils.JSFunction"%>
<%@page import="memberregist.MemberDTO"%>
<%@page import="memberregist.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//폼값받기
String id = request.getParameter("id");
String pass = request.getParameter("pass1");
String name = request.getParameter("name");
String email = request.getParameter("email1")
			+"@"+ request.getParameter("email2");
String mailing = request.getParameter("mailing");
String zipcode = request.getParameter("zipcode");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");
String mobile = request.getParameter("mobile1")
			+"-"+ request.getParameter("mobile2")
			+"-" +request.getParameter("mobile3");
String sms = request.getParameter("sms");

//DTO객체 담기
MemberDTO dto = new MemberDTO();

dto.setId(id);
dto.setPass(pass);
dto.setName(name);
dto.setEmail(email);
dto.setMailing(mailing);
dto.setZipcode(zipcode);
dto.setAddr1(addr1);
dto.setAddr2(addr2);
dto.setMobile(mobile);
dto.setSms(sms);

//DAO객체
MemberDAO dao = new MemberDAO(application);
int iResult = dao.insertWrite(dto);

dao.close();

if(iResult ==1){
	out.print("입력성공");
}
else{
	JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
}



%>
