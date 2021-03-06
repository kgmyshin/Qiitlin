package kgmyshin.qiitlin.infra.api.v2

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit.RestAdapter
import retrofit.converter.GsonConverter

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ApiClient {

    companion object {
        val BASE_URL = "http://qiita.com/api/v2"
    }

    protected fun getService<T>(cls: java.lang.Class<T>): T {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        val restAdapter =
                RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setConverter(GsonConverter(gson))
                .build()
        return restAdapter.create(cls)
    }

    public fun getQiitaApi(): QiitaApi {
        return getService(javaClass<QiitaApi>())
    }

}