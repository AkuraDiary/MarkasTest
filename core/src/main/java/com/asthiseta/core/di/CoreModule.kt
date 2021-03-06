package com.asthiseta.core.di

import com.asthiseta.core.BuildConfig
import com.asthiseta.core.data.UserRepository
import com.asthiseta.core.data.soure.remote.RemoteDataSource
import com.asthiseta.core.data.soure.remote.network.ClientAPI
import com.asthiseta.core.domain.repository.IUserRepository
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = BuildConfig.BASE_URL
private const val API_KEY = BuildConfig.API_KEY

val networkModule = module {
    single {
        val hostname = "api.github.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/ORtIOYkm5k6Nf2tgAK/uwftKfNhJB3QS0Hs608SiRmE=")
            .add(hostname, "sha256/k2v657xBsOVe1PQRwOsHsw3bsGT2VzIqz5K+59sNQws=")
            .add(hostname, "sha256/uyPYgclc5Jt69vKu92vci6etcBDY8UNTyrHQZJpVoZY=")
            .build()

        OkHttpClient.Builder()
            .addInterceptor{chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder().header("Authorization", API_KEY)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .certificatePinner(certificatePinner)
            .build()
    }

    single{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ClientAPI::class.java)
    }
}

val repositoryModule = module {
    single{RemoteDataSource(get())}
    single<IUserRepository>{
        UserRepository(
            get()
        )
    }
}