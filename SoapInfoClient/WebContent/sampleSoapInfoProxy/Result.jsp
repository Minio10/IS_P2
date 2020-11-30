<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleSoapInfoProxyid" scope="session" class="soap.info.SoapInfoProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleSoapInfoProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleSoapInfoProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleSoapInfoProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        soap.info.SoapInfo getSoapInfo10mtemp = sampleSoapInfoProxyid.getSoapInfo();
if(getSoapInfo10mtemp == null){
%>
<%=getSoapInfo10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String skill_1id=  request.getParameter("skill18");
            java.lang.String skill_1idTemp = null;
        if(!skill_1id.equals("")){
         skill_1idTemp  = skill_1id;
        }
        java.lang.String resFromSkill15mtemp = sampleSoapInfoProxyid.resFromSkill(skill_1idTemp);
if(resFromSkill15mtemp == null){
%>
<%=resFromSkill15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(resFromSkill15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 20:
        gotMethod = true;
        java.lang.String getAllRes20mtemp = sampleSoapInfoProxyid.getAllRes();
if(getAllRes20mtemp == null){
%>
<%=getAllRes20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllRes20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 23:
        gotMethod = true;
        String name_2id=  request.getParameter("name26");
            java.lang.String name_2idTemp = null;
        if(!name_2id.equals("")){
         name_2idTemp  = name_2id;
        }
        java.lang.String infoResearcher23mtemp = sampleSoapInfoProxyid.infoResearcher(name_2idTemp);
if(infoResearcher23mtemp == null){
%>
<%=infoResearcher23mtemp %>
<%
}else{
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(infoResearcher23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>