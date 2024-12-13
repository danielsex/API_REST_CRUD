package com.example.rest.service;
import com.example.rest.model.EnderecoModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class EnderecoService {


    public EnderecoModel GetEndereco(String cep) throws IOException {
        EnderecoModel endereco =null;
        URL url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String linha = "";

        StringBuilder jsonCep = new StringBuilder();

        while((linha=br.readLine()) != null){
            jsonCep.append(cep);

        }
        endereco = new Gson().fromJson(jsonCep.toString(), EnderecoModel.class);


    return endereco;
}}
