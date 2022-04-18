package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.domain.entities.GitProfile
import com.android.anonymous_02_22.domain.mapper.GitSearchModelMapper
import com.android.anonymous_02_22.domain.repository.RemoteRepository
import javax.inject.Inject

class SearchUserInteraction @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val mapper: GitSearchModelMapper
) : SearchUserUseCase {
    override suspend fun searchUsers(keyword:String): List<FoundUser> {
        val initList = remoteRepository.searchUsers(keyword)
        return mapper.toDomainList(initList)
    }

//    override suspend fun fetchUserDetail(userName: String): GitProfile {
//        val model = remoteRepository.fetchUserDetail(userName)
//        return mapper.mapToDomainModel(model)
//    }
}