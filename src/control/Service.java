package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

import model.domain.Product;

public class Service {

    TreeMap<Integer, Product> treemap = new TreeMap<>();
    String patch = "data.txt";

    public TreeMap obterDadosTxt() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int i = 0;

        try {
            try (FileReader file = new FileReader(patch)) {
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

    public void gravarDadosTxt(TreeMap<Integer, Product> treemap) throws IOException {

        PrintWriter p = new PrintWriter("data.txt");

        for (int i = 0; i <= treemap.size(); i++) {
            if (treemap.containsKey(i)) {
                String codigo = treemap.get(i).getCodigo().toString();
                String nome = treemap.get(i).getNome();
                String valor = treemap.get(i).getValor().toString();
                String data = treemap.get(i).getDataAlteracao();
                String s = ",";

                String line = codigo + s + nome + s + valor + s + data;

                p.println(line);
            }
        }

        p.close();
    }

    /*
    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getCodigo() > p2.getCodigo()) {
            return 1;
        } else if (p1.getCodigo() < p2.getCodigo()) {
            return -1;
        }
        return 0;
    }
    */
}
