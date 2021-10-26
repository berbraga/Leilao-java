package br.univali;

import br.univali.leilao.*;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        
        System.out.println("\n\n\n");
        Participante claudio = new Participante("Claudio", "logado", "sanhasenha", "claudiogostosao@hotmail.com", "rua pinho", "91111-1111");
        Participante ana = new Participante("Ana","logada","senhasenha","anamonstrao@gmail.com","rua franca","92222-2222");

        Item_Leilao caneta = new Item_Leilao("Caneta Azul", "Caneta azul Bic, exelenta para escrever em papel", "https://www.google.com/search?q=caneta+azul+bic&sxsrf=AOaemvI6mIVSh-mGK2mSLrWVQDIa-jnrnQ:1635189390718&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjknJiWo-bzAhW5rpUCHbAVAZ8Q_AUoAnoECAEQBA&biw=1366&bih=669&dpr=1#imgrc=RSPih0FZGI3_cM", 1.00);
        Leilao logoAli = new Leilao("26/10/2021","26/10/2021", "16:17:00", "16:18:00",caneta);

        logoAli.IniciaLeilao(caneta);

        Lance lanceClaudio= new Lance(1.50,"16:17:30", claudio, caneta);
        Lance lanceAna = new Lance(1.65,"16:17:40", ana, caneta);

        logoAli.finalizaLeilao(caneta);
        System.out.println("\n\n");



    }
}
