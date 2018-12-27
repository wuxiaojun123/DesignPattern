package com.wxj.datastructure.http.service;

import com.wxj.datastructure.bean.ArticleModel;
import com.wxj.datastructure.bean.HttpResult;
import com.wxj.datastructure.bean.ZhuangbiImage;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by wuxiaojun on 2018/12/26.
 */

public interface ApiService {

	@GET("search") Flowable<List<ZhuangbiImage>> search(@Query("q") String query);

	@GET() Flowable<HttpResult<ArticleModel>> requestArticleList(@Url String url);

}
