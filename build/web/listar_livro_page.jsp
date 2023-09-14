

<%@page import="br.entrelinhas.DTO.Livro"%>
<%@page import="br.entrelinhas.DAO.LivroDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="corpo">
        <header id="topo">
            <a href="cadastrar_livro_page.jsp"><button id="btn-novo" class="btn btn-warning btn-lg">Novo Livro</button></a>
            <a href="index.html"><button id="btn-novo" class="btn btn-danger btn-lg">Sair</button></a>        
        </header>
        <main id="principal">
            <h1 id="listah1">Livros</h1>
            <%
                LivroDAO objLivroDAO = new LivroDAO();

                ArrayList<Livro> l = objLivroDAO.listarTodosOsLivros();

                for (int i = 0; i < l.size(); i++) {
                    out.print("<div class='container jumbotron'><p>Código: " + l.get(i).getId() + "</p>");
                    out.print("<p>Nome: " + l.get(i).getNome() + "</p>");
                    out.print("<p>Autor: " + l.get(i).getAutor()+ "</p>");
                    out.print("<p>Seção: " + l.get(i).getSecao()+ "</p>");
                    out.print("<p>Número de Páginas: " + l.get(i).getNumeroDePaginas()+ "</p>");
                    out.print("<p>ISBN: " + l.get(i).getIsbn()+ "</p><br>");
                    

                    out.print("<a href='excluir_livro_page.jsp?"
                            + "codigo=" + l.get(i).getId() + ""
                            + "&nome=" + l.get(i).getNome() + ""
                            + "&autor=" + l.get(i).getAutor()+ ""
                            + "&secao=" + l.get(i).getSecao()+ ""
                            + "&numerodepaginas=" + l.get(i).getNumeroDePaginas()+ ""
                            + "&isbn=" + l.get(i).getIsbn()+ "'><button class='btn btn-danger'>Excluir</button></a>");

                    out.print("<a href='alterar_livro_page.jsp?"
                            + "codigo=" + l.get(i).getId() + ""
                            + "&nome=" + l.get(i).getNome() + ""
                            + "&autor=" + l.get(i).getAutor()+ ""
                            + "&secao=" + l.get(i).getSecao()+ ""
                            + "&numerodepaginas=" + l.get(i).getNumeroDePaginas()+ ""
                            + "&isbn=" + l.get(i).getIsbn()+ "'><button class='btn btn-warning'>Alterar</button></a>");
                }

            %>
        </main>
    </body>
</html>
