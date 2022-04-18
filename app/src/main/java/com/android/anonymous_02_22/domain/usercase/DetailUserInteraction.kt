package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.GitProfile
import com.android.anonymous_02_22.domain.mapper.GitProfileMapper
import com.android.anonymous_02_22.domain.repository.RemoteRepository
import javax.inject.Inject

class DetailUserInteraction @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val mapper: GitProfileMapper
) : DetailUserUseCase {
    override suspend fun fetchUserDetail(userName: String): GitProfile {
        val model = remoteRepository.fetchUserDetail(userName)
        return mapper.mapToDomainModel(model)
    }
}