package br.univali.leilao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lance {
    private double value;
    private Date time;
    private Participante pessoa;

    public Lance(double value, String tempo, Participante aqui, Item_Leilao thing) throws ParseException {
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
        this.value = value;
        this.time = hora.parse(tempo);
        this.pessoa = aqui;
        RegLance(thing,value,aqui);
    }

    public Participante getPessoa() {
        return pessoa;
    }

    public void setPessoa(Participante pessoa) {
        this.pessoa = pessoa;
    }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public Date getTime() { return time; }
    public void setTime(Date time) throws ParseException {
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
        this.time = hora.parse(String.valueOf(time));
    }

    public void RegLance(Item_Leilao item, double value, Participante person) { // metodo permite registrar um novo lance.
        person.setCont();
        setValue(value);
        item.setMinimal_price(getValue());
    }




}
