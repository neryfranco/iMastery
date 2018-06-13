package com.neryfranco.masterygame.model;

import android.media.Image;

import java.io.Serializable;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Nery on 13/05/2018.
 */

public class Usuario implements Serializable {
    @PrimaryKey
    @Required
    private String email;
    private String senha;
    private String nome_completo;
    private String nick;
    private String tel_celular;
    private String cidade;
    private String uf;
    private Pais pais;
    private Date dataNasc;
    private Image image;
    private String biografia;
    private String link;
    private RedeSocial redeSocial;

    public Usuario(){}

    public Usuario(String email, String senha, String nome_completo, String nick) {
        this.email = email;
        this.senha = senha;
        this.nome_completo = nome_completo;
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public RedeSocial getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(RedeSocial redeSocial) {
        this.redeSocial = redeSocial;
    }
}
