package com.dzakyhdr.beritaguys.data

import com.dzakyhdr.beritaguys.data.api.NewsAPIService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlinesTest_sentRequest(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us", 1)
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=b80745933d1b442c870d5e980ca26396")
        }
    }

    @Test
    fun getTopHeadlinesTest_receiveResponse_correctPageSized(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us", 1).body()
            val articleList = responseBody!!.articles
            //default page size from newsapi.org is 20
            assertThat(articleList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlinesTest_receiveResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us", 1).body()
            val articleList = responseBody!!.articles
            val article = articleList[0]
            // data from newsresponse.json
            assertThat(article.author).isEqualTo("David Aaro")
            assertThat(article.url).isEqualTo("https://www.foxnews.com/science/massive-iceberg-larger-than-new-york-city-breaks-off-in-antarctic")
            assertThat(article.publishedAt).isEqualTo("2021-03-01T05:31:59Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}