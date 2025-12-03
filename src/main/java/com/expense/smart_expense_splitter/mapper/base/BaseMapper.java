package com.expense.smart_expense_splitter.mapper.base;

public interface BaseMapper<M, D> {
    D toDto(M model);
    M toModel(D dto);
}
