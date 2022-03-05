package com.android.anonymous_02_22.domain.mapper

interface DomainMapper  <T, DomainModel>{
    fun mapToDomainModel(model: T): DomainModel
}