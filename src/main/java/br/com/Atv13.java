package br.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Atv13{

        public static void main(String[] args) {
            List<Produto> produtos = new ArrayList<>();
            produtos.add(new Produto("Notebook", 2500.0));
            produtos.add(new Produto("Smartphone", 1200.0));
            produtos.add(new Produto("Headphones", 150.0));
    
            // Serialização
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("produtos.dat"))) {
                objectOutputStream.writeObject(produtos);
                System.out.println("Lista de produtos serializada com sucesso!");
            } catch (IOException e) {
                System.err.println("Erro ao serializar lista de produtos: " + e.getMessage());
            }
    
            // Deserialização
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
                List<Produto> produtosDeserializados = (List<Produto>) objectInputStream.readObject();
                System.out.println("Produtos deserializados:");
                for (Produto produto : produtosDeserializados) {
                    System.out.println(produto);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao deserializar lista de produtos: " + e.getMessage());
            }
        }
    }