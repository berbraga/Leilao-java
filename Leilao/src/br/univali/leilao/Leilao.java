package br.univali.leilao;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Leilao implements Interface_leilao {
    private Date date_start ;
    private Date date_end ;
    private Date time_start ;
    private Date time_end ;
    private Item_Leilao item;
    private boolean status;  // status == true  => leilao esta aberto, 
                             // status == false => leilao esta fechado,

    public Leilao(String date_start, String date_end, String time_start, String time_end, Item_Leilao obj) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
        this.date_start = sdf.parse(date_start);
        this.date_end = sdf.parse(date_end);
        this.time_start = hora.parse(time_start);
        this.time_end = hora.parse(time_end);
        this.status = false;
        this.item = obj;
    }

    public Item_Leilao getItem() {
        return item;
    }

    public void setItem(Item_Leilao item) {
        this.item = item;
    }

    public Date getDate_start()  {return date_start;}
    public Date getDate_end()    {return date_end;}
    public Date getTime_start()  {return time_start;}
    public Date getTime_end()    {return time_end;}
    
    public void setDate_start(Calendar date_start) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.date_start = sdf.parse(String.valueOf(date_start));
    }
    public void setDate_end(Calendar date_end) throws ParseException     {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.date_end = sdf.parse(String.valueOf(date_end));
    }
    public void setTime_start(Time time_start) throws ParseException     {
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
        this.time_start = hora.parse(String.valueOf(time_start));
    }
    public void setTime_end(Time time_end) throws ParseException         {
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
        this.time_end = hora.parse(String.valueOf(time_end));
    }

    @Override
    public boolean getStatus(){
        return status;
    }
    @Override
    public void setStatus(int operador){
        this.status = operador >= 1;
    }
    @Override
    public boolean checkOpen(Leilao obj){
        boolean visto;
        visto = obj.getStatus();
        return visto;
    }

    public ArrayList<Leilao> ConLeilao(Leilao[] leiloado) {  // disparados para consultar leiloes registrados.
        try {
            ArrayList<Leilao> def_objeto = new ArrayList<>();
            for (int i = 0; i <= leiloado.length; i++) {
                if (checkOpen(leiloado[i])) {
                    def_objeto.add(leiloado[i]);
                }
            }
            return def_objeto;

        }catch(ArrayIndexOutOfBoundsException nu) {
            System.out.println("error 01");
            return null;
        }
    }

    public void IniciaLeilao(Item_Leilao objeto) throws ParseException{  // inicia um leilao.
        try{

            setStatus(1);
            objeto.setStatus(1);
            System.out.println("\nO leilao foi aberto com sucesso");

        }catch(NullPointerException nu){

            System.out.println("error 02");

        }

    }

    public void finalizaLeilao(Item_Leilao objeto){  // serve para marcar um leilao como finalizado.
        try {

            setStatus(0);
            objeto.setStatus(0);
            objeto.arremetarItem();
            System.out.println("\nO leilao finalizado");

        }catch(NullPointerException nu){

            System.out.println("error 02");

        }

    }




}
