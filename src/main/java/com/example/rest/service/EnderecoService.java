package com.example.rest.service;
import com.example.rest.model.EnderecoModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class EnderecoService {


    private EnderecoModel  endereco = new EnderecoModel();

    public EnderecoModel GetEndereco(String cep) {

        try {
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
        } catch (MalformedURLException e) {
            System.out.println("error");
        } catch (UnsupportedEncodingException e) {
            System.out.println("error");
        } catch (IOException e) {
            System.out.println("error");
        }

    return endereco;
}}
