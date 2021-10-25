package com.evirgenoguz.kitaplaruygulama.network

class ApiUtils {
    companion object{

        private const val BASE_URL = "http://books.canerture.com/"

        fun kitapDaoInterfaceGetir(): KitapDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(KitapDAOInterface::class.java)
        }

    }
}