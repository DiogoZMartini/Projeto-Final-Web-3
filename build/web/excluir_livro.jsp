
<%@page import="br.entrelinhas.DAO.LivroDAO"%>
<%@page import="br.entrelinhas.DTO.Livro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="refresh" content="0.001; listar_livro_page.jsp">
    </head>
    <body>
        <%
            Livro objLivro = new Livro();
            objLivro.setId(Integer.parseInt(request.getParameter("txtId")));
            
            LivroDAO objLivroDAO = new LivroDAO();
            objLivroDAO.excluirLivro(objLivro);
        
        %>
    </body>
</html>