package Arvores;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GerarImagem2 {
    public static void main(String[] args) {
        // Dimensões da imagem
        int largura = 100;
        int altura = 100;
        
        // 16 níveis de intensidade (0-15)
        int maxValorPixel = 15;
        
        // Criação do gerador de números aleatórios
        Random random = new Random();
        
        // Nome do arquivo PGM
        String nomeArquivo = "Imagem Tipo P2.pgm";
        
        try (FileWriter arquivo = new FileWriter(nomeArquivo)) {
            // Cabeçalho do PGM
            arquivo.write("P2\n");
            arquivo.write(largura + " " + altura + "\n");
            arquivo.write(maxValorPixel + "\n");
            
            // Gerar e escrever os pixels
            for (int i = 0; i < altura; i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < largura; j++) {
                    // Gera um número aleatório entre 0 e 15 (inclusive)
                    linha.append(random.nextInt(maxValorPixel + 1)).append(" ");
                }
                arquivo.write(linha.toString().trim() + "\n");
            }
            
            System.out.println("Imagem PGM gerada com sucesso: " + nomeArquivo);
            
        } catch (IOException e) {
            System.out.println("Erro ao gerar a imagem: " + e.getMessage());
        }
    }
}