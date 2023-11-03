package com.api.team.mapper;

public interface Mapper <A,B>{
    A mapToEntity(B b);
    B mapFromEntity(A a);
}
