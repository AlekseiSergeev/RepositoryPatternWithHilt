package com.example.repositorypatternwithhilt.domain.model

data class Blog (
    var id: Int,
    var title: String,
    var body: String,
    var image: String,
    var category: String)