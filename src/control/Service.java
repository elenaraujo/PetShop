package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.TreeMap;

import model.domain.Product;

public class Service implements Comparator<Product> {
    
    TreeMap<Integer, Product> treemap = new TreeMap<>();

    public TreeMap getData() {

        String data = "data.txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int i = 0;

        try {
            try (FileReader file = new FileReader(data)) {
                BufferedReader br = new BufferedReader(file);

                String line = br.readLine();
                while (line != null) {

                    String[] campos = line.split(",");
                    Product produto = new Product();
                    produto.setCodigo(Integer.parseInt(campos[0]));
                    produto.setNome(campos[1]);
                    produto.setValor(Double.valueOf(campos[2]));

                    LocalDate date = LocalDate.parse(campos[3], formatter);
                    produto.setDataAlteracao(date);
                    
                    treemap.put(i, produto);
                    i++;

                    line = br.readLine();
                }
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
        return treemap;
    }

    @Override
    public int compare(Product other1, Product other2) {
        if (other1.getCodigo() > other2.getCodigo()) {
            return 1;
        } else if (other1.getCodigo() < other2.getCodigo()) {
            return -1;
        }
        return 0;
    }
}
