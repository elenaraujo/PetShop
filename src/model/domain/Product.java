package model.domain;

import java.time.LocalDate;

public class Product implements Comparable<Product> {

    private int codigo;
    private String nome;
    private int quantidade;
    private double valor;
    private LocalDate dataCadastro;

    public Product(int codigo, String nome, int quantidade, double valor, LocalDate dataCadastro) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int compareTo(Product other) {
        return nome.compareTo(other.nome);
    }

    @Override
    public String toString() {
        return "\nProduto: " + getNome() + "\nCodigo: " + getCodigo() + "\nQuantidade: " + getQuantidade()
                + "\nValor" + getValor() + "\nData de cadastro: " + getDataCadastro();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (codigo != other.codigo) {
            return false;
        }
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    public String pesquisa(Product other) {
        if (equals(valor) == true) {
            return toString();
        } else {
            return "Produto não encontrado";
        }
    }

}
