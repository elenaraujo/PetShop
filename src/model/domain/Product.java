package model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Product implements Comparable<Product> {

    private Integer codigo;
    private String nome;
    private Double valor;
    private LocalDate dataAlteracao;
    
    public Product(){
    }

    public Product(Integer codigo, String nome, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.dataAlteracao = LocalDate.now();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataAlteracao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String dataFormatada = formatter.format(dataAlteracao);
        return dataFormatada;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public int compareTo(Product other) {
        return nome.compareTo(other.nome);
    }

    @Override
    public String toString() {
        return "\nProduto: " + getNome() + "\nCodigo: " + getCodigo() + "\nQuantidade: "
                + "\nValor" + getValor() + "\nData de cadastro: " + getDataAlteracao();
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
        if (!Objects.equals(codigo, other.codigo)) {
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
        if (!codigo.equals(other.codigo)) {
            return "Produto não encontrado";
        } else {
            return toString();
        }
    }
}
