package br.univali.leilao;

import java.io.IOException;
import java.util.Objects;

public class Participante {
    private String name;
    private String login;
    private String password;
    private String email;
    private String address;
    private String phone;
    private int cont; //contador para ver quantos lances ela fez

    public Participante(String nome, String login, String senha, String mail, String endereco, String telefone){
        this.name = nome;
        this.login = login;
        this.password = senha;
        this.email = mail;
        this.address = endereco;
        this.phone = telefone;

    }

    public int getCont()          { return cont; }
    public void setCont() { this.cont = cont + 1; }

    public String getPhone()    { return phone; }
    public String getAddress()  { return address; }
    public String getEmail()    { return email; }
    public String getPassword() { return password; }
    public String getLogin()    { return login; }
    public String getName()     { return name; }
    public void setPhone(String phone)       { this.phone = phone; }
    public void setAddress(String address)   { this.address = address; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email)       { this.email = email; }
    public void setLogin(String login)       { this.login = login; }
    public void setName(String name)         { this.name = name; }

    public boolean RegPar() throws IOException {
        System.out.println("\nVoce ira se cadastrar!");
        setName("Bernardo vai tirar 10 na profa da proff");
        setLogin("logado");
        setEmail("bernardo.sbraga@yahoo.com");
        setPassword("senhaMudou");
        setAddress("Sao Jose");
        setPhone("48999346334");
        System.out.println("\nVoce se cadastrou com sucesso");
        return true;
    }

    public boolean Login(String log_digitado, Participante nome){
        if(Objects.equals(nome.getLogin(), log_digitado)){
            System.out.println("\nAcesso liberado...");
            return true;
        }else{
            System.out.println("\nAcesso negado: login digitado nao corresponde");
            return false;
        }

    }


}