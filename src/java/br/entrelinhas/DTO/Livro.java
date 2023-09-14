
package br.entrelinhas.DTO;
public class Livro {
    private int id;
    private String nome;
    private String autor;
    private int secao;
    private int numeroDePaginas;
    private long isbn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getSecao() {
        return secao;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Id: " + id + "/n"
                + "Nome: " + nome + "/n"
                + "Autor: " + autor + "/n"
                + "Secao: " + secao + "/n"
                + "Número De Páginas: " + numeroDePaginas + "/n"
                + "ISBN: " + isbn;
    }

 
    
    
}
