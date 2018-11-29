package com.project.taewon.sneakersootd.network.model

data class Request(
    var title: String?,
    var totalResults: String?,
    var searchTerms: String?,
    var count: Int?,
    var startIndex: Int?,
    var inputEncoding: String?,
    var outputEncoding: String?,
    var safe: String?,
    var cx: String?,
    var searchType: String?
)