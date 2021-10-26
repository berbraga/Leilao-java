package br.univali.leilao;

public class Item_Leilao implements Interface_leilao{
    private String title_item;
    private String description_item;
    private String url_photo;
    private double minimal_price;
    private int arremetado;  //pode ser somente 0 ou 1, sendo 0 quando nao foi arrementado, e 1 quando for.]
    private boolean status; // status == true => leilao esta aberto,
                            // status == false => leilao esta fechado,7
    private Participante arrematouPessoa;


    public Item_Leilao( String titleItem, String descricaoItem, String urlFoto, double precoMinimo ){
        this.title_item = titleItem;
        this.description_item = descricaoItem;
        this.url_photo = urlFoto;
        this.minimal_price = precoMinimo;
        this.arremetado = 0;

    }

    public Participante getArrematouPessoa() { return arrematouPessoa; }
    public void setArrematouPessoa(Participante arrematouPessoa) { this.arrematouPessoa = arrematouPessoa; }


    public String getTitle_item()       { return title_item; }
    public String getDescription_item() { return description_item; }
    public String getUrl_photo()        { return url_photo; }
    public double getMinimal_price()    { return minimal_price; }
    public int getArremetado()          { return arremetado; }
    public void setTitle_item(String title_item)             {this.title_item = title_item;}
    public void setDescription_item(String description_item) {this.description_item = description_item;}
    public void setUrl_photo(String url_photo)               {this.url_photo = url_photo;}
    public void setMinimal_price(double minimal_price)       {
        if(minimal_price > getMinimal_price()) { this.minimal_price = minimal_price; }
        else{ System.out.println("\nvalor do lance eh menor que o minimo"); }
    }
    public void setArremetado(int arremetado)                {this.arremetado = arremetado;}
    
    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(int operador) {
        this.status = operador >= 1;
    }

    @Override
    public boolean checkOpen(Leilao obj) {
        boolean visto;
        visto = obj.getStatus();
        return visto;
    }

    public String conItem(Leilao leilao) {  // disparado para consultar um item especifico, estando associado ao metodo => iniciaLeilao() <= da classe Leilao.
        String dados = "";
        if (leilao.getStatus()) {
            if (getArremetado() == 1) {
                dados = getTitle_item() + getDescription_item() + getUrl_photo() + getMinimal_price() + "objeto foi arremetado";
            } else {
                dados = getTitle_item() + getDescription_item() + getUrl_photo() + getMinimal_price() + "objeto ainda nao foi arremetado";
            }
            return dados;
        }
        return dados;
    }

    public void arremetarItem(){  // objetiva definir um determinado item como arremetar.
        setArremetado(1);

    }
}
