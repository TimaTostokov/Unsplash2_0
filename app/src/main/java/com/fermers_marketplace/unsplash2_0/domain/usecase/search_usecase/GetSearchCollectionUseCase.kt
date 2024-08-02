package com.fermers_marketplace.unsplash2_0.domain.usecase.search_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

data class SearchCollectionParam(
    val query: String,
    val page: Int,
)

class GetSearchCollectionUseCase @Inject constructor(private val searchRepository: SearchRepository) :
    UseCase<SearchCollectionParam, List<CollectionDto>>(Dispatchers.IO) {
    override suspend fun execute(param: SearchCollectionParam): List<CollectionDto> =
        searchRepository.getSearchCollections(param.query, param.page, 10)
}