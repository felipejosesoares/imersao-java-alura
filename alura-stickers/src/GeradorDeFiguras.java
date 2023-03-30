import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.Font;
import java.net.URL;

public class GeradorDeFiguras {

        public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

            // leitura da imagem
            //InputStream inputStream =
            //       new FileInputStream(new File("entrada/TopMovies_1.jpg"));
            //InputStream inputStream =
            //        new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
            BufferedImage ImagemOriginal = ImageIO.read(inputStream);

            // criar nova imagem em memória com transparência e com tamanho novo
            int largura = ImagemOriginal.getWidth();
            int altura = ImagemOriginal.getHeight();
            int novaAltura = altura + 200;
            BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

            // copiar a imagem original pra novo imagem (em memória)
            Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
            graphics.drawImage(ImagemOriginal, 0, 0, null);

            // configurar a fonte
            var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
            graphics.setColor(Color.CYAN);
            graphics.setFont(fonte);

            // escrever uma  frase na nova imagem
            String texto = "Primeira Figura";
            FontMetrics fontMetrics = graphics.getFontMetrics();
            Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
            int larguraTexto = (int) retangulo.getWidth();
            int posicaoTextoX = (largura - larguraTexto) / 2;
            graphics.drawString(texto, posicaoTextoX, novaAltura - 100);

            // criando diretório saída
             var diretorio = new File("saida/");
             diretorio.mkdir();

            // escrever a nova imagem em um arquivo
            ImageIO.write(novaImagem, "png", new File("aula2/saida/", nomeArquivo));
        }
}


