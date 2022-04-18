package com.android.anonymous_02_22.domain.mapper

import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.local.database.entities.MockCryptic
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import com.android.anonymous_02_22.domain.entities.GitProfile
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class GitProfileMapper @Inject constructor() : DomainMapper<ModelUser, GitProfile> {

    fun toDomainList(initial: List<ModelUser>): List<GitProfile>{
        return initial.map { mapToDomainModel(it) }
    }

    override fun mapToDomainModel(model: ModelUser): GitProfile {
        return GitProfile(id = model.id,
            login = model.login,
            avatarUrl = model.avatarUrl,
            htmlUrl = model.htmlUrl,
            name = model.name,
            blog = model.blog,
            location = model.location,
            email = model.email,
            bio = model.bio,
            twitterUsername = model.twitterUsername,
            publicRepos = model.publicRepos,
            followers = model.followers,
            following = model.following

        )
    }

}