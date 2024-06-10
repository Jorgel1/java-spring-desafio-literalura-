package br.com.jorge.literalura.service;

public interface IConverteDados {
   <T> T obterDados(String json, Class<T> classe);
}
