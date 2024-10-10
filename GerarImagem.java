package Arvores;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GerarImagem {
    public static void main(String[] args) {
        // Dimensões da imagem
        int largura = 100;
        int altura = 100;
        
        // Criação do gerador de números aleatórios
        Random random = new Random();
        
        // Nome do arquivo PBM
        String nomeArquivo = "Imagem Tipo P1.pbm";
        
        try (FileWriter arquivo = new FileWriter(nomeArquivo)) {
            // Cabeçalho do PBM
            arquivo.write("P1\n");
            arquivo.write(largura + " " + altura + "\n");
            
            // Gerar e escrever os pixels
            for (int i = 0; i < altura; i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < largura; j++) {
                    linha.append(random.nextInt(2)).append(" ");
                }
                arquivo.write(linha.toString().trim() + "\n");
            }
            
            System.out.println("Imagem PBM gerada com sucesso: " + nomeArquivo);
            
        } catch (IOException e) {
            System.out.println("Erro ao gerar a imagem: " + e.getMessage());
        }
    }
}