package com.company.TestErd.Dto;

import java.util.List;

public interface SimpleCrud<K,V> {
    ResponseDto<V> create(V dto);
    ResponseDto<V> get(Integer entityId);
    ResponseDto<V> update(Integer entityId,V dto);
    ResponseDto<V> delete(Integer entityId);
    ResponseDto<List<V>> getAll();
}
