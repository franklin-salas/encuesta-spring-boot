package com.lanister.encuesta.utils.transformer;

public interface Transformer<K,T> {
    T transformData(K data);
}
